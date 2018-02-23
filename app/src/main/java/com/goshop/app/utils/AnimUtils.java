package com.goshop.app.utils;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

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

    public static void rotateArrow(View arrow, boolean rotate) {
        Context context = GoShopApplication.getAppContext();
        if (rotate) {
            Animation operatingAnim = AnimationUtils
                .loadAnimation(context, R.anim.anim_rotate_to_180);
            operatingAnim.setFillAfter(true);
            arrow.startAnimation(operatingAnim);
        } else {
            Animation operatingAnim = AnimationUtils
                .loadAnimation(context, R.anim.anim_rotate_from180);
            arrow.startAnimation(operatingAnim);
        }
    }

    public static void setPageBottomToTopAnim(Activity context) {
        context.overridePendingTransition(R.anim.enter_bottom_top, R.anim.exit_bottom_top);
    }

    public static void setPageTopToBottomAnim(Activity context) {
        context.overridePendingTransition(R.anim.enter_top_bottom, R.anim.exit_top_bottom);
    }

}
