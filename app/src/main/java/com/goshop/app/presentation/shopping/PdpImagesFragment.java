package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.presentation.model.ImagesVM;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class PdpImagesFragment extends BaseFragment implements PdpImagesAdapter
    .OnImageItemClickListener {

    private static int currentPosition = 0;

    private static List<ImagesVM> imagesVMS;

    @BindView(R.id.iv_left_page)
    ImageView ivLeftPage;

    @BindView(R.id.iv_right_page)
    ImageView ivRightPage;

    @BindView(R.id.recyclerview_pdp_images)
    RecyclerView recyclerviewPdpImages;

    Unbinder unbinder;

    @BindView(R.id.viewpager_pdp_image_display)
    ViewPager viewPagerPdpImageDisplay;

    private PdpImagesAdapter imagesAdapter;

    private PdpImagesPagerAdapter pdpImagesPagerAdapter;

    public static PdpImagesFragment getInstance(List<ImagesVM> imagesVMList) {
        imagesVMS = imagesVMList;
        //todo wait for api
        imagesVMS.get(currentPosition).setSelected(true);
        return new PdpImagesFragment();
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        assert rootView != null;
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_pdp_images;
    }

    @Override
    public void initView() {
        initRecyclerview();
        initViewPager();
        ivRightPage.setVisibility(
            (currentPosition == imagesVMS.size() - 1) ? View.GONE : View.VISIBLE);
        ivLeftPage.setVisibility((currentPosition == 0) ? View.GONE : View.VISIBLE);
    }

    private void initRecyclerview() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerviewPdpImages.setLayoutManager(layoutManager);
        imagesAdapter = new PdpImagesAdapter(imagesVMS);
        recyclerviewPdpImages.setAdapter(imagesAdapter);
        imagesAdapter.setOnImageItemClickListener(this::onImageItemClick);
    }

    private void initViewPager() {
        pdpImagesPagerAdapter = new PdpImagesPagerAdapter(imagesVMS);
        viewPagerPdpImageDisplay.setAdapter(pdpImagesPagerAdapter);
        viewPagerPdpImageDisplay.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                currentPosition = position;
                imagesAdapter.changeSelectDatas(currentPosition);
                recyclerviewPdpImages.scrollToPosition(currentPosition);
                ivRightPage.setVisibility(
                    (currentPosition == imagesVMS.size() - 1) ? View.GONE : View.VISIBLE);
                ivLeftPage.setVisibility((currentPosition == 0) ? View.GONE : View.VISIBLE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void setup() {

    }

    @OnClick({R.id.iv_left_page, R.id.iv_right_page})
    public void onImagesClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left_page:
                if (currentPosition > 0) {
                    currentPosition--;
                }
                break;
            case R.id.iv_right_page:
                if (currentPosition < imagesVMS.size() - 1) {
                    currentPosition++;
                }
                break;
        }
        viewPagerPdpImageDisplay.setCurrentItem(currentPosition);
        recyclerviewPdpImages.scrollToPosition(currentPosition);
    }

    @Override
    public void onImageItemClick(int position) {
        currentPosition = position;
        viewPagerPdpImageDisplay.setCurrentItem(currentPosition);
        recyclerviewPdpImages.scrollToPosition(currentPosition);
    }
}
