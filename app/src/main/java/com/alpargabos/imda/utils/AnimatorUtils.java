package com.alpargabos.imda.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.List;

public class AnimatorUtils {

	public static final int CIRCULAR_DURATION = 600;
	public static final int ANIM_DURATION = 400;

	@NonNull
	public Animation createAnimation(Context context, final int animatioResource, final List<View> views) {
		Animation animation = AnimationUtils.loadAnimation(context, animatioResource);
		animation.setStartTime(AnimationUtils.currentAnimationTimeMillis());
		animation.setDuration(ANIM_DURATION);
		animation.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				for (View view : views) {
					view.setVisibility(animatioResource == android.R.anim.fade_out ? View.GONE : View.VISIBLE);
				}
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		for (View view : views) {
			view.setAnimation(animation);
		}
		return animation;
	}

	@NonNull
	public Animator createCircularReveal(@NonNull View layout, int startX, int startY) {
		// get the final radius for the clipping circle
		int finalRadius = Math.max(layout.getWidth(), layout.getHeight());
		// create the animator for this view (the start radius is zero)
		Animator anim = ViewAnimationUtils.createCircularReveal(layout, startX, startY, 0, finalRadius);
		// make the view visible and start the animation
		anim.setInterpolator(new AccelerateInterpolator());
		anim.setDuration(CIRCULAR_DURATION);
		layout.setVisibility(View.VISIBLE);
		return anim;
	}

	@NonNull
	public Animator createExitReveal(@NonNull final View layout, int endX, int endY) {
		// get the final radius for the clipping circle
		int finalRadius = Math.max(layout.getWidth(), layout.getHeight());
		// create the animator for this view (the start radius is zero)
		Animator anim = ViewAnimationUtils.createCircularReveal(layout, endX, endY, finalRadius, 0);
		// make the view visible and start the animation
		anim.setInterpolator(new AccelerateInterpolator());
		anim.setDuration(CIRCULAR_DURATION);
		anim.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				layout.setVisibility(View.INVISIBLE);
			}
		});
		return anim;
	}
}
