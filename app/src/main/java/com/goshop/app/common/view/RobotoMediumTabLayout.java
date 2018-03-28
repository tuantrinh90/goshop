package com.goshop.app.common.view;

import com.goshop.app.common.Typefaces;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.ViewGroup;

@SuppressWarnings("ALL")
public class RobotoMediumTabLayout extends TabLayout {

    public RobotoMediumTabLayout(Context context) {
        super(context);
    }

    public RobotoMediumTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RobotoMediumTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        super.setupWithViewPager(viewPager);
        Typeface typeface = Typefaces.get(viewPager.getContext(), Typefaces.PATH_FONT_ROBOTO_MEDIUM);
        if (typeface != null) {
            this.removeAllTabs();
            ViewGroup slidingTabStrip = (ViewGroup) getChildAt(0);
            PagerAdapter pagerAdapter = viewPager.getAdapter();
            for (int i = 0; i < pagerAdapter.getCount(); i++) {
                Tab tab = this.newTab();
                this.addTab(tab.setText(pagerAdapter.getPageTitle(i)));
                AppCompatTextView view = (AppCompatTextView) ((ViewGroup) slidingTabStrip
                    .getChildAt(i)).getChildAt(1);
                view.setTypeface(typeface);
            }
        }
    }
}
