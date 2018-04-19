package com.goshop.app.common.view.irecyclerview.widget.footer;

import com.goshop.app.R;
import com.goshop.app.utils.ScreenHelper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

@SuppressWarnings("ALL")
public class LoadMoreFooterView extends FrameLayout {

    public static final int FOOTER_HEIGHT = 48;

    private Status mStatus;

    private View mLoadingView;

    private View mErrorView;

    private View mTheEndView;

    private TextView tvTheEnd;

    public TextView getTheEndTextView() {
        return tvTheEnd;
    }

    private OnRetryListener mOnRetryListener;

    public LoadMoreFooterView(Context context) {
        this(context, null);
    }

    public LoadMoreFooterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadMoreFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context)
            .inflate(R.layout.layout_irecyclerview_load_more_footer_view, this, true);

        mLoadingView = findViewById(R.id.loadingView);
        mErrorView = findViewById(R.id.errorView);
        mTheEndView = findViewById(R.id.theEndView);
        mErrorView.setOnClickListener(v -> {
            if (mOnRetryListener != null) {
                mOnRetryListener.onRetry(LoadMoreFooterView.this);
            }
        });
        setStatus(Status.GONE);
    }

    public void setOnRetryListener(OnRetryListener listener) {
        this.mOnRetryListener = listener;
    }

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        this.mStatus = status;
        change();
    }

    public boolean canLoadMore() {
        return mStatus == Status.GONE || mStatus == Status.ERROR;
    }

    private boolean theEndShowView = true;

    public void setTheEndShowView(boolean show) {
        theEndShowView = show;
    }

    private void change() {
        switch (mStatus) {
            case GONE:
                if (getLayoutParams() != null) getLayoutParams().height = 0;
                mLoadingView.setVisibility(GONE);
                mErrorView.setVisibility(GONE);
                mTheEndView.setVisibility(GONE);
                break;

            case LOADING:
                if (getLayoutParams() != null)
                    getLayoutParams().height = ScreenHelper.dip2px(getContext(), FOOTER_HEIGHT);
                mLoadingView.setVisibility(VISIBLE);
                mErrorView.setVisibility(GONE);
                mTheEndView.setVisibility(GONE);
                break;

            case ERROR:
                if (getLayoutParams() != null)
                    getLayoutParams().height = ScreenHelper.dip2px(getContext(), FOOTER_HEIGHT);
                mLoadingView.setVisibility(GONE);
                mErrorView.setVisibility(VISIBLE);
                mTheEndView.setVisibility(GONE);
                break;

            case THE_END:
                if (getLayoutParams() != null)
                    getLayoutParams().height = ScreenHelper.dip2px(getContext(), FOOTER_HEIGHT);
                mLoadingView.setVisibility(GONE);
                mErrorView.setVisibility(GONE);
                if (theEndShowView) {
                    mTheEndView.setVisibility(VISIBLE);
                } else {
                    mTheEndView.setVisibility(GONE);
                }
                break;
        }
    }

    public enum Status {
        GONE, LOADING, ERROR, THE_END
    }

    public interface OnRetryListener {

        void onRetry(LoadMoreFooterView view);
    }

}
