package com.goshop.app.base;

import com.goshop.app.R;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;

@SuppressWarnings("ALL")
public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {

    private static final String TAG = BaseFragment.class.getSimpleName();

    @Inject
    public T mPresenter;

    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentView(), container, false);
        ButterKnife.bind(this, view);
        inject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        return view;
    }

    public abstract int getContentView();

    public abstract void inject();

    public void showLoadingBar() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).showLoadingBar();
        } else {
            progressDialog = new ProgressDialog(getContext(), R.style.ProgressDialogTheme);
            progressDialog.setCancelable(false);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();
        }
    }

    public void hideLoadingBar() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).hideLoadingBar();
        } else {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }

    }
}
