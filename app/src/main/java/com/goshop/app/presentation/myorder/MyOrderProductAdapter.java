package com.goshop.app.presentation.myorder;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.RobotoItaticTextView;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.MyOrdersProductVM;
import com.goshop.app.utils.GlideUtils;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyOrderProductAdapter extends RecyclerView.Adapter {

    private List<MyOrdersProductVM> myOrdersProductVMS;

    private OnOrderDetailItemClickListener onOrderDetailItemClickListener;

    public MyOrderProductAdapter(
        List<MyOrdersProductVM> myOrdersProductVMS) {
        this.myOrdersProductVMS = myOrdersProductVMS;
    }

    public void setUpdateDatas(List<MyOrdersProductVM> myOrdersProductVMS) {
        this.myOrdersProductVMS.clear();
        this.myOrdersProductVMS = myOrdersProductVMS;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_order_product, parent, false);
        return new MyOrdersProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyOrdersProductViewHolder) holder).bindingDatas(myOrdersProductVMS.get(position));
    }

    @Override
    public int getItemCount() {
        return myOrdersProductVMS.size();
    }

    public void setOnOrderDetailItemClickListener(
        OnOrderDetailItemClickListener onOrderDetailItemClickListener) {
        this.onOrderDetailItemClickListener = onOrderDetailItemClickListener;
    }

    public interface OnOrderDetailItemClickListener {

        void onWriteReviewClick();

        void onTrackClick();

        void onReturnClick();
    }

    class MyOrdersProductViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_order_product_thumb)
        ImageView ivOrderProductThumb;

        @BindView(R.id.tv_order_product_attr)
        RobotoLightTextView tvOrderProductAttr;

        @BindView(R.id.tv_order_product_count)
        RobotoLightTextView tvOrderProductCount;

        @BindView(R.id.tv_order_product_now)
        RobotoMediumTextView tvOrderProductNow;

        @BindView(R.id.tv_order_product_number)
        RobotoLightTextView tvOrderProductNumber;

        @BindView(R.id.tv_order_product_old)
        RobotoLightTextView tvOrderProductOld;

        @BindView(R.id.tv_order_product_statu)
        RobotoItaticTextView tvOrderProductStatu;

        @BindView(R.id.tv_order_product_title)
        RobotoLightTextView tvOrderProductTitle;

        @BindView(R.id.tv_order_product_track)
        RobotoLightTextView tvOrderProductTrack;

        @BindView(R.id.tv_order_product_write)
        RobotoLightTextView tvOrderProductWrite;

        private static final String DELIVERED = "Delivered";

        private static final String BTN_RETURN = "Return";

        private static final String BTN_TRACK = "Track";

        private static final String MIDDLE_SPACE = ":\t";

        private static final String END_SPACE = ";\t";


        public MyOrdersProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingDatas(MyOrdersProductVM productVM) {
            tvOrderProductNumber.setText(productVM.getStatuNo());
            tvOrderProductStatu.setText(productVM.getStatuContent());
            //todo this part is wait for api
            tvOrderProductTrack
                .setText(productVM.getStatuContent().equals(DELIVERED) ? BTN_RETURN : BTN_TRACK);
            GlideUtils.loadImageError(
                itemView.getContext(),
                productVM.getThumb(),
                ivOrderProductThumb,
                R.drawable.ic_image_404_big);
            tvOrderProductTitle.setText(productVM.getTitle());
            tvOrderProductOld.setText( productVM.getPriceOld());
            tvOrderProductOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            tvOrderProductNow.setText(productVM.getPriceNow());
            tvOrderProductCount.setText(productVM.getCount());
            Map<String, String> attrsMap = productVM.getAttrMap();
            String attr = "";
            for (Map.Entry<String, String> entry : attrsMap.entrySet()) {
                attr = attr + entry.getKey() + MIDDLE_SPACE + entry.getValue() + END_SPACE;
            }
            tvOrderProductAttr.setText(attr);
            tvOrderProductTrack.setOnClickListener(v -> {
                if (productVM.getStatuContent().equals(DELIVERED)) {
                    onOrderDetailItemClickListener.onReturnClick();
                } else {
                    onOrderDetailItemClickListener.onTrackClick();
                }

            });
            tvOrderProductWrite.setOnClickListener(v -> onOrderDetailItemClickListener.onWriteReviewClick());
        }
    }
}
