package com.goshop.app.utils;

import com.goshop.app.R;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by img on 2018/1/22.
 */

public class AnimUtils {

    public static void setFilterBarAnim(View view, boolean isShow) {
        view.clearAnimation();
        Animation animation;
        if (isShow) {
            animation = AnimationUtils
                .loadAnimation(view.getContext(), R.anim.anim_filter_bar_show);
        } else {
            animation = AnimationUtils
                .loadAnimation(view.getContext(), R.anim.anim_filter_bar_hidden);
        }
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (isShow) {
                    view.setVisibility(View.VISIBLE);
                } else {
                    view.setVisibility(View.GONE);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animation);

    }

}
