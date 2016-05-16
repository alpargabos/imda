package com.alpargabos.imda.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.List;

public class AnimatorUtils {
	@NonNull
	public Animation createAnimation(Context context, int animatioResource, final List<View> views) {
		Animation fadeOut = AnimationUtils.loadAnimation(context, animatioResource);
		fadeOut.setStartTime(AnimationUtils.currentAnimationTimeMillis());
		fadeOut.setDuration(400);
		fadeOut.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				for (View view : views) {
					view.setVisibility(View.GONE);
				}
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		for (View view : views) {
			view.setAnimation(fadeOut);
		}
		return fadeOut;
	}
}
