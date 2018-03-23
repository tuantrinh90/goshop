package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.presentation.model.ImagesVM;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class PDPDetailImagesActivity extends BaseActivity {

    @BindView(R.id.iv_pdp_images_finish)
    ImageView ivPdpImagesFinish;

    @BindView(R.id.ll_pdp_images_bottom)
    LinearLayout llPdpImagesBottom;

    @BindView(R.id.tv_btn_pdp_images)
    RobotoLightTextView tvBtnPdpImages;

    @BindView(R.id.tv_btn_pdp_video)
    RobotoLightTextView tvBtnPdpVideo;

    @BindView(R.id.viewpager_pdp_images)
    ViewPager viewpagerPdpImages;

    private PdpVideoImageAdapter pdpVideoImageAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewpagerPdpImages.setCurrentItem(0);
        tvBtnPdpVideo.setSelected(true);
        tvBtnPdpImages.setSelected(false);

        viewpagerPdpImages.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                viewpagerPdpImages.setCurrentItem(position);
                tvBtnPdpVideo.setSelected(position == 0);
                tvBtnPdpImages.setSelected(position == 1);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public int getContentView() {
        return R.layout.activity_pdp_detail_images;
    }

    @Override
    public void inject() {
        initViewPager();
    }

    private void initViewPager() {
        List<BaseFragment> fragments = new ArrayList<>();
        //todo wait for api
        fragments.add(PdpVideoFragment.getInstance(""));
        fragments.add(PdpImagesFragment.getInstance(getMockData()));
        pdpVideoImageAdapter = new PdpVideoImageAdapter(getSupportFragmentManager(), fragments);
        viewpagerPdpImages.setAdapter(pdpVideoImageAdapter);
    }

    private List<ImagesVM> getMockData() {
        List<ImagesVM> imagesVMS = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                imagesVMS.add(new ImagesVM(R.drawable.ic_product_one, ""));
            } else {
                imagesVMS.add(new ImagesVM(R.drawable.ic_product_two, ""));
            }
        }
        return imagesVMS;
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    @OnClick({R.id.tv_btn_pdp_video, R.id.tv_btn_pdp_images})
    public void onPdpVideoImagesClick(View view) {
        switch (view.getId()) {
            case R.id.tv_btn_pdp_video:
                viewpagerPdpImages.setCurrentItem(0);
                break;
            case R.id.tv_btn_pdp_images:
                viewpagerPdpImages.setCurrentItem(1);
                break;
        }
    }
}
