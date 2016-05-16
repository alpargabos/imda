package com.alpargabos.imda.welcome;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTouch;
import com.alpargabos.imda.R;
import com.alpargabos.imda.utils.AnimatorUtils;

import java.util.Arrays;

public class WelcomeFragment extends Fragment {

	@BindView(R.id.welcome_login_button) Button loginButton;
	@BindView(R.id.welcome_signup_button) Button signupButton;
	@BindView(R.id.welcome_texts) View textsContainer;
	@BindView(R.id.login_layout) View loginLayout;
	@BindView(R.id.signup_layout) View signupLayout;

	View root;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		root = inflater.inflate(R.layout.fragment_welcome, container, false);
		ButterKnife.bind(this, root);

		setRetainInstance(true);
		return root;
	}

	public static WelcomeFragment newInstance() {
		return new WelcomeFragment();
	}

	@OnTouch(R.id.welcome_login_button)
	public boolean onTouchLogin(View view, MotionEvent motionEvent) {
		if (motionEvent.getAction() == MotionEvent.ACTION_UP) {

			Animation fadeOut = new AnimatorUtils().createAnimation(getActivity().getBaseContext(), android.R.anim.fade_out, Arrays.asList(textsContainer, loginButton, signupButton));
			fadeOut.start();

			// get the final radius for the clipping circle
			int finalRadius = Math.max(loginLayout.getWidth(), loginLayout.getHeight());

			System.out.println("motionEvent = " + motionEvent);
			// create the animator for this view (the start radius is zero)
			Animator anim =
				ViewAnimationUtils.createCircularReveal(loginLayout, (int) (loginButton.getLeft() + motionEvent.getX()), (int) (motionEvent.getRawY() - (root.getHeight() - loginLayout.getHeight())) - view.getHeight() / 2, 0, finalRadius);

			// make the view visible and start the animation
			anim.setInterpolator(new AccelerateInterpolator());
			anim.setDuration(600);
			loginLayout.setVisibility(View.VISIBLE);
			anim.start();
		}
		return false;
	}

	@OnTouch(R.id.welcome_signup_button)
	public boolean onTouchSignup(View view, MotionEvent motionEvent) {
		if (motionEvent.getAction() == MotionEvent.ACTION_UP) {

			Animation fadeOut = new AnimatorUtils().createAnimation(getActivity().getBaseContext(), android.R.anim.fade_out, Arrays.asList(textsContainer, loginButton, signupButton));
			fadeOut.start();

			// get the final radius for the clipping circle
			int finalRadius = Math.max(signupLayout.getWidth(), signupLayout.getHeight());

			// create the animator for this view (the start radius is zero)
			Animator anim =
				ViewAnimationUtils.createCircularReveal(signupLayout, (int) (signupButton.getLeft() + motionEvent.getX()), (int) (motionEvent.getRawY() - (root.getHeight() - signupLayout.getHeight())) - view.getHeight() / 2, 0, finalRadius);

			// make the view visible and start the animation
			anim.setInterpolator(new AccelerateInterpolator());
			anim.setDuration(600);
			signupLayout.setVisibility(View.VISIBLE);
			anim.start();
		}
		return false;
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	void exitReveal(@NonNull final View myView) {
		// get the center for the clipping circle
		int cx = myView.getMeasuredWidth() / 2;
		int cy = myView.getMeasuredHeight() / 2;

		// get the initial radius for the clipping circle
		int initialRadius = myView.getWidth() / 2;

		// create the animation (the final radius is zero)
		Animator anim =
			ViewAnimationUtils.createCircularReveal(myView, cx, cy, initialRadius, 0);

		// make the view invisible when the animation is done
		anim.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				myView.setVisibility(View.INVISIBLE);
			}
		});

		// start the animation
		anim.start();
	}
}
