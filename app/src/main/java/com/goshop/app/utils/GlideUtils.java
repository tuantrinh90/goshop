package com.goshop.app.utils;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;

import android.content.Context;
import android.widget.ImageView;

public class GlideUtils {

    // TODO: 2018/5/7  The latest Glide version (4.x) will be used in the future.
    /**
     * Glide 3.x Features
     * Simple to use
     * High configurability and high self-adaptation
     * Support common picture formats Jpg png gif webp
     * Support multiple data sources Network, Local, Resources, Assets, etc.
     * Efficient caching strategy Supports Memory and Disk image caching The default Bitmap format uses RGB_565 memory usage to reduce by at least half
     * Life cycle integration automatically manages requests based on Activity/Fragment life cycle
     * Efficient processing Bitmap Use Bitmap Pool to reuse Bitmap, actively call recycle to recover Bitmap that needs to be recycled, reduce system recovery pressure
     * Context is supported by default here, Glide supports Context, Activity, Fragment, FragmentActivity
     */

    //Default loading
    public static void loadImage(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).into(mImageView);
    }

    //Load the specified size
    public static void loadImageSize(Context mContext, String path, int width, int height, ImageView mImageView) {
        Glide.with(mContext).load(path).override(width, height).into(mImageView);
    }

    //Set placeholder image
    public static void loadImagePlaceHolder(Context mContext, String path, ImageView mImageView, int placeholderImage) {
        Glide.with(mContext).load(path).placeholder(placeholderImage).into(mImageView);
    }

    //Set error image
    public static void loadImageError(Context mContext, String path, ImageView mImageView,int errorImage) {
        Glide.with(mContext).load(path).error(errorImage).into(mImageView);
    }

    //Set error image
    public static void loadImageError(Context mContext, int path, ImageView mImageView,int errorImage) {
        Glide.with(mContext).load(path).error(errorImage).into(mImageView);
    }

    //Set download priority
    public static void loadImagePriority(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).priority(Priority.NORMAL).into(mImageView);
    }

    /**
     * Disk cache strategy：
     * all:Cache source resources and converted resources
     * none:Do not make any disk cache
     * source:Cache source resources
     * result：Cache converted resources
     */

    //Set up a caching strategy
    public static void loadImageDiskCache(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).diskCacheStrategy(DiskCacheStrategy.ALL).into(mImageView);
    }

    //Set loading animation
    public static void loadImageAnim(Context mContext, String path, int anim, ImageView mImageView) {
        Glide.with(mContext).load(path).animate(anim).into(mImageView);
    }

    //Set up thumbnail support
    public static void loadImageThumbnail(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).thumbnail(0.1f).into(mImageView);
    }

    //Set up dynamic conversion
    public static void loadImageCrop(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).centerCrop().into(mImageView);
    }

    //Set the dynamic GIF loading method
    public static void loadImageDynamicGif(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).asGif().into(mImageView);
    }

    //Set static GIF loading method
    public static void loadImageStaticGif(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).asBitmap().into(mImageView);
    }

    //Set request listener
    public static void loadImageListener(Context mContext, String path, ImageView mImageView, RequestListener<String, GlideDrawable> requstlistener) {
        Glide.with(mContext).load(path).listener(requstlistener).into(mImageView);
    }

    //Set content to load
    public static void loadImageContent(Context mContext, String path, SimpleTarget<GlideDrawable> simpleTarget) {
        Glide.with(mContext).load(path).centerCrop().into(simpleTarget);
    }

    //Clean up the disk cache
    public static void GuideClearDiskCache(Context mContext) {
        //The disk cache needs to be executed in a child thread
        Glide.get(mContext).clearDiskCache();
    }

    //Clean up the memory cache
    public static void GuideClearMemory(Context mContext) {
        //Clearing the memory cache can be done in the UI main thread
        Glide.get(mContext).clearMemory();
    }
}
