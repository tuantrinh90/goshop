package com.goshop.app.presentation.shopping;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.presentation.model.ImagesVM;
import com.goshop.app.utils.GlideUtils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PdpImagesAdapter extends RecyclerView.Adapter {

    private List<ImagesVM> imagesVMS;

    private OnImageItemClickListener onImageItemClickListener;

    public PdpImagesAdapter(List<ImagesVM> imagesVMS) {
        this.imagesVMS = imagesVMS;
    }

    public void setUpdateDatas(List<ImagesVM> imagesVMS) {
        this.imagesVMS.clear();
        this.imagesVMS = imagesVMS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_pdp_details_images, parent, false);
        return new PdpImagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((PdpImagesViewHolder) holder).bindingData(imagesVMS.get(position), position);
    }

    @Override
    public int getItemCount() {
        return imagesVMS.size();
    }

    public void changeSelectDatas(int position) {
        for (int i = 0; i < imagesVMS.size(); i++) {
            imagesVMS.get(i).setSelected(i == position);
        }
        notifyDataSetChanged();
    }

    public void setOnImageItemClickListener(OnImageItemClickListener onImageItemClickListener) {
        this.onImageItemClickListener = onImageItemClickListener;
    }

    public interface OnImageItemClickListener {

        void onImageItemClick(int position);
    }

    class PdpImagesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_image_selected)
        ImageView ivImageSelected;

        @BindView(R.id.iv_image_unselected)
        ImageView ivImageUnselected;

        public PdpImagesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(ImagesVM imagesVM, int position) {
            GlideUtils.loadImageError(
                itemView.getContext(),
                imagesVM.getImageUrl(),
                ivImageSelected,
                imagesVM.getImageDefault());

            GlideUtils.loadImageError(
                itemView.getContext(),
                imagesVM.getImageUrl(),
                ivImageUnselected,
                imagesVM.getImageDefault());
            ivImageSelected.setVisibility(imagesVM.isSelected() ? View.VISIBLE : View.GONE);
            ivImageUnselected.setVisibility(imagesVM.isSelected() ? View.GONE : View.VISIBLE);
            itemView.setOnClickListener(v -> {
                changeSelectDatas(position);
                onImageItemClickListener.onImageItemClick(position);
            });
        }

    }
}
