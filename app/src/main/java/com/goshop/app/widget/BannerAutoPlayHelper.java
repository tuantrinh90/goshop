package com.goshop.app.widget;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;

import java.lang.ref.WeakReference;

public class BannerAutoPlayHelper {

    private static int NUM_PAGES;

    private ImageHandler mImageHandler;

    private ViewPager sliderViewPager;

    public BannerAutoPlayHelper(ViewPager sliderViewPager) {
        this.sliderViewPager = sliderViewPager;
        NUM_PAGES = sliderViewPager.getAdapter().getCount();
        mImageHandler = new ImageHandler(sliderViewPager);
    }

    public void destory() {
        if (mImageHandler != null) {
            mImageHandler.removeCallbacksAndMessages(null);
        }
    }

    public void autoPlay() {
        sliderViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mImageHandler.sendMessage(
                    Message.obtain(mImageHandler, ImageHandler.MSG_PAGE_CHANGED, position, 0));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        mImageHandler.sendEmptyMessage(ImageHandler.MSG_KEEP_SILENT);
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        mImageHandler.sendEmptyMessageDelayed(ImageHandler.MSG_UPDATE_IMAGE,
                            ImageHandler.MSG_DELAY);
                        break;
                    default:
                        break;
                }
            }

        });
        mImageHandler
            .sendEmptyMessageDelayed(ImageHandler.MSG_UPDATE_IMAGE, ImageHandler.MSG_DELAY);
    }

    private static class ImageHandler extends Handler {

        static final int MSG_BREAK_SILENT = 3;

        static final long MSG_DELAY = 2000;

        static final int MSG_KEEP_SILENT = 2;

        static final int MSG_PAGE_CHANGED = 4;

        static final int MSG_UPDATE_IMAGE = 1;

        WeakReference<ViewPager> viewPagerWeakReference;

        private int currentItem = -1;

        ImageHandler(ViewPager viewPager) {
            viewPagerWeakReference = new WeakReference<>(viewPager);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (this.hasMessages(MSG_UPDATE_IMAGE)) {
                this.removeMessages(MSG_UPDATE_IMAGE);
            }
            if (viewPagerWeakReference.get() == null) return;
            switch (msg.what) {
                case MSG_UPDATE_IMAGE:
                    if (currentItem == NUM_PAGES) {
                        currentItem = 0;
                    }
                    viewPagerWeakReference.get().setCurrentItem(currentItem++);
                    this.sendEmptyMessageDelayed(MSG_UPDATE_IMAGE, MSG_DELAY);
                    break;
                case MSG_KEEP_SILENT:
                    break;
                case MSG_BREAK_SILENT:
                    this.sendEmptyMessageDelayed(MSG_UPDATE_IMAGE, MSG_DELAY);
                    break;
                case MSG_PAGE_CHANGED:
                    currentItem = msg.arg1;
                    this.sendEmptyMessageDelayed(MSG_UPDATE_IMAGE, MSG_DELAY);
                    break;
                default:
                    break;
            }
        }
    }
}
