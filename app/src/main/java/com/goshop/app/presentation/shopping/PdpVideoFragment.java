package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.base.BaseFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;

public class PdpVideoFragment extends BaseFragment {

    private static String videoUrl;

    @BindView(R.id.iv_video_pdp)
    ImageView ivVideoPdp;

    public static PdpVideoFragment getInstance(String url) {
        videoUrl = url;
        return new PdpVideoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        assert rootView != null;
        return rootView;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_pdp_video;
    }

    @Override
    public void inject() {
        // now no need implement it
    }

}
