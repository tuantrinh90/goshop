package com.goshop.app.common.view;

import com.goshop.app.R;
import com.goshop.app.utils.ScreenHelper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class CustomButtomLineRelativeLayout extends RelativeLayout {
    private TextView lineTextView;
    static float  purpleLineHeight=1.6f;
    static  float defaultLine=0.8f;
    public CustomButtomLineRelativeLayout(Context context) {
        super(context);
    }

    public CustomButtomLineRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        lineTextView = new TextView(context);
        LayoutParams lp = new LayoutParams(context, attrs);
        lp.width = LinearLayout.LayoutParams.MATCH_PARENT;
        lp.height = ScreenHelper.dip2px(context, defaultLine);
        lineTextView.setBackgroundColor(ScreenHelper.getColor(R.color.color_bg_disabled_divider));
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        lineTextView.setLayoutParams(lp);
        this.addView(lineTextView);
    }

    public void setBottomLineActive(boolean active) {

        LayoutParams lp=(LayoutParams)lineTextView.getLayoutParams() ;
        if (active) {
            lineTextView.setBackgroundColor(ScreenHelper.getColor(R.color.colorAccent));
            lp.height=ScreenHelper.dip2px(this.getContext(),purpleLineHeight);
            lineTextView.requestLayout();
        }else{
            lineTextView.setBackgroundColor(ScreenHelper.getColor(R.color.color_bg_disabled_divider));
            lp.height=ScreenHelper.dip2px(this.getContext(),defaultLine);
            lineTextView.requestLayout();
        }
    }


    public static void setBottomLineActive(View view,boolean active) {

        LinearLayout.LayoutParams lp=(LinearLayout.LayoutParams)view.getLayoutParams() ;
        if (active) {
            view.setBackgroundColor(ScreenHelper.getColor(R.color.colorAccent));
            lp.height=ScreenHelper.dip2px(view.getContext(),purpleLineHeight);
            view.requestLayout();
        }else{
            view.setBackgroundColor(ScreenHelper.getColor(R.color.color_bg_disabled_divider));
            lp.height=ScreenHelper.dip2px(view.getContext(),defaultLine);
            view.requestLayout();
        }
    }
    public static void setRelativeBottomLineActive(View view,boolean active) {
        LayoutParams lp=(LayoutParams)view.getLayoutParams() ;
        if (active) {
            view.setBackgroundColor(ScreenHelper.getColor(R.color.colorAccent));
            lp.height=ScreenHelper.dip2px(view.getContext(),purpleLineHeight);
            view.requestLayout();
        }else{
            view.setBackgroundColor(ScreenHelper.getColor(R.color.color_bg_disabled_divider));
            lp.height=ScreenHelper.dip2px(view.getContext(),defaultLine);
            view.requestLayout();
        }
    }
}

