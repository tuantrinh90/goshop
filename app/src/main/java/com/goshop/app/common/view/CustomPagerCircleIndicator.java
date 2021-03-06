package com.goshop.app.common.view;

import com.goshop.app.R;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class CustomPagerCircleIndicator extends LinearLayout implements ViewPager
    .OnPageChangeListener {

    private List<View> points;

    private ViewPager viewPager;

    public CustomPagerCircleIndicator(Context context) {
        super(context);
        init();
    }

    private void init() {
        setOrientation(LinearLayout.HORIZONTAL);
        points = new ArrayList<>();
    }

    public CustomPagerCircleIndicator(Context context,
        @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomPagerCircleIndicator(Context context,
        @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        viewPager.addOnPageChangeListener(this);
        initIndicator();
    }

    public void initIndicator() {
        this.removeAllViews();
        this.points.clear();
        if (viewPager.getAdapter() == null || viewPager.getAdapter().getCount() == 1) return;
        for (int i = 0; i < viewPager.getAdapter().getCount(); i++) {
            View vPoint = LayoutInflater.from(getContext())
                .inflate(R.layout.item_circle_page_indicator_point, this, false);
            vPoint.setSelected(i == 0);
            points.add(vPoint);
            addView(vPoint);
        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        setPointSelected(i);
    }

    private void setPointSelected(int index) {
        for (int i = 0; i < points.size(); i++) {
            View view = points.get(i);
            view.setSelected(index == i);
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
