package com.alpargabos.imda.welcome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTouch;
import com.alpargabos.imda.R;
import com.alpargabos.imda.utils.AnimatorUtils;

import java.util.Arrays;

public class WelcomeActivity extends AppCompatActivity {

	@BindView(R.id.welcome_login_button) Button loginButton;
	@BindView(R.id.welcome_signup_button) Button signupButton;
	@BindView(R.id.welcome_texts) View textsContainer;
	@BindView(R.id.login_layout) View loginLayout;
	@BindView(R.id.signup_layout) View signupLayout;
	@BindView(R.id.welcome_container) View welcomeContainer;

	AnimatorUtils animatorUtils = new AnimatorUtils();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		ButterKnife.bind(this);
	}

	@Override
	public void onBackPressed() {
		if (loginLayout.getVisibility() == View.VISIBLE) {
			animatorUtils.createAnimation(this, android.R.anim.fade_in, Arrays.asList(textsContainer, loginButton, signupButton)).start();
			int endX = loginButton.getLeft() + loginButton.getWidth() / 2;
			int endY = (loginButton.getTop() - (welcomeContainer.getHeight() - loginLayout.getHeight())) + loginButton.getHeight() / 2;
			animatorUtils.createExitReveal(loginLayout, endX, endY).start();
		} else if (signupLayout.getVisibility() == View.VISIBLE) {
			animatorUtils.createAnimation(this, android.R.anim.fade_in, Arrays.asList(textsContainer, loginButton, signupButton)).start();
			int endX = signupButton.getLeft() + signupButton.getWidth() / 2;
			int endY = (signupButton.getTop() - (welcomeContainer.getHeight() - signupLayout.getHeight())) + signupButton.getHeight() / 2;
			animatorUtils.createExitReveal(signupLayout, endX, endY).start();
		} else {
			super.onBackPressed();
		}
	}

	@OnTouch(R.id.welcome_login_button)
	public boolean onTouchLogin(View view, MotionEvent motionEvent) {
		if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
			animatorUtils.createAnimation(this, android.R.anim.fade_out, Arrays.asList(textsContainer, loginButton, signupButton)).start();

			int startX = (int) (loginButton.getLeft() + motionEvent.getX());
			int startY = (int) (motionEvent.getRawY() - (welcomeContainer.getHeight() - loginLayout.getHeight())) - view.getHeight() / 2;
			animatorUtils.createCircularReveal(loginLayout, startX, startY).start();
		}
		return false;
	}

	@OnTouch(R.id.welcome_signup_button)
	public boolean onTouchSignup(View view, MotionEvent motionEvent) {
		if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
			animatorUtils.createAnimation(this, android.R.anim.fade_out, Arrays.asList(textsContainer, loginButton, signupButton)).start();

			int startX = (int) (signupButton.getLeft() + motionEvent.getX());
			int startY = (int) (motionEvent.getRawY() - (welcomeContainer.getHeight() - signupLayout.getHeight())) - view.getHeight() / 2;
			animatorUtils.createCircularReveal(signupLayout, startX, startY).start();
		}
		return false;
	}
}
