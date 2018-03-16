package com.goshop.app.presentation.myorder;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.RobotoBoldTextView;
import com.goshop.app.common.view.RobotoItaticTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.MyOrdersProductVM;
import com.goshop.app.utils.NumberFormater;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyOrderProductAdapter extends RecyclerView.Adapter {

    private List<MyOrdersProductVM> myOrdersProductVMS;

    public MyOrderProductAdapter(
        List<MyOrdersProductVM> myOrdersProductVMS) {
        this.myOrdersProductVMS = myOrdersProductVMS;
    }

    public void setUpdateDatas(List<MyOrdersProductVM> myOrdersProductVMS) {
        this.myOrdersProductVMS.clear();
        this.myOrdersProductVMS = myOrdersProductVMS;
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

    class MyOrdersProductViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_order_product_thumb)
        ImageView ivOrderProductThumb;

        @BindView(R.id.tv_order_product_attr)
        RobotoRegularTextView tvOrderProductAttr;

        @BindView(R.id.tv_order_product_count)
        RobotoRegularTextView tvOrderProductCount;

        @BindView(R.id.tv_order_product_now)
        RobotoBoldTextView tvOrderProductNow;

        @BindView(R.id.tv_order_product_number)
        RobotoRegularTextView tvOrderProductNumber;

        @BindView(R.id.tv_order_product_old)
        RobotoRegularTextView tvOrderProductOld;

        @BindView(R.id.tv_order_product_statu)
        RobotoItaticTextView tvOrderProductStatu;

        @BindView(R.id.tv_order_product_title)
        RobotoRegularTextView tvOrderProductTitle;

        @BindView(R.id.tv_order_product_track)
        RobotoRegularTextView tvOrderProductTrack;

        @BindView(R.id.tv_order_product_write)
        RobotoRegularTextView tvOrderProductWrite;

        public MyOrdersProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingDatas(MyOrdersProductVM productVM) {
            tvOrderProductNumber.setText(productVM.getStatuNo());
            tvOrderProductStatu.setText(productVM.getStatuContent());

            Glide.with(itemView.getContext()).load(productVM.getThumb()).asBitmap()
                .error(productVM.getThumbDefault())
                .into(ivOrderProductThumb);
            tvOrderProductTitle.setText(productVM.getTitle());
            tvOrderProductOld.setText(NumberFormater.formaterMoney(productVM.getPriceOld()));
            tvOrderProductOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            tvOrderProductNow.setText(NumberFormater.formaterMoney(productVM.getPriceNow()));
            //todo hard code wait for decide
            tvOrderProductCount.setText("x" + productVM.getCount());
            List<String> attrs = productVM.getAttr();
            String attr = "Color:" + attrs.get(0) + ", Size:" + attrs.get(1);
            tvOrderProductAttr.setText(attr);
            tvOrderProductTrack.setOnClickListener(v -> {
            });
            tvOrderProductWrite.setOnClickListener(v -> {
            });
        }
    }
}
