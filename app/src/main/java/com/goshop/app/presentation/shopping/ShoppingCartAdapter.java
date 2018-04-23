package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularEditText;
import com.goshop.app.presentation.model.ShoppingCartApplyVM;
import com.goshop.app.presentation.model.ShoppingCartModel;
import com.goshop.app.presentation.model.ShoppingCartProductVM;
import com.goshop.app.utils.NumberFormater;
import com.goshop.app.widget.adapter.WidgetProductListAdapter;
import com.goshop.app.widget.listener.OnBannerItemClickListener;
import com.goshop.app.widget.listener.OnItemMenuClickListener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoppingCartAdapter extends RecyclerView.Adapter {

    private List<ShoppingCartModel> cartModels;

    private OnItemMenuClickListener menuClickListener;

    public ShoppingCartAdapter(List<ShoppingCartModel> cartModels) {
        this.cartModels = cartModels;
    }

    public void setOnItemMenuClickListener(OnItemMenuClickListener menuClickListener) {
        this.menuClickListener = menuClickListener;
    }

    public void setDatas(List<ShoppingCartModel> cartModels) {
        this.cartModels.clear();
        this.cartModels = cartModels;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case ShoppingCartModel.CART_PRODUCT:
                View productView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recyclerview, parent, false);
                viewHolder = new ProductViewHolder(productView);
                break;
            case ShoppingCartModel.CART_APPLY:
                View applyView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_cart_apply, parent, false);
                viewHolder = new ApplyViewHolder(applyView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ShoppingCartModel shoppingCartModel = cartModels.get(position);
        if (holder instanceof ProductViewHolder) {
            ((ProductViewHolder) holder)
                .bindingData((ShoppingCartProductVM) shoppingCartModel, menuClickListener);
        } else if (holder instanceof ApplyViewHolder) {
            ((ApplyViewHolder) holder).bindingData((ShoppingCartApplyVM) shoppingCartModel);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return cartModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return cartModels.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recyclerview)
        RecyclerView recyclerView;

        public ProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(ShoppingCartProductVM cartProductVM,
            OnItemMenuClickListener menuClickListener) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            recyclerView.setLayoutManager(layoutManager);
            WidgetProductListAdapter productListAdapter = new WidgetProductListAdapter(
                cartProductVM.getProductListModels());
            recyclerView.setAdapter(productListAdapter);
            productListAdapter.setOnItemMenuClickListener(menuClickListener);
        }
    }

    class ApplyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_btn_cart_apply)
        RobotoMediumTextView tvBtnCartApply;

        @BindView(R.id.et_cart_apply)
        RobotoRegularEditText etCartApply;

        @BindView(R.id.tv_cart_billing_subtotal)
        RobotoLightTextView tvCartBillingSubtotal;

        @BindView(R.id.tv_cart_billing_shipping)
        RobotoLightTextView tvCartBillingShipping;

        @BindView(R.id.tv_cart_billing_disscount)
        RobotoLightTextView tvCartBillingDisscount;

        @BindView(R.id.tv_cart_billing_total)
        RobotoMediumTextView tvCartBillingTotal;

        public ApplyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(ShoppingCartApplyVM applyVM) {
            tvBtnCartApply.setOnClickListener(v->{
                String code = etCartApply.getText().toString();

            });
            tvCartBillingSubtotal.setText(applyVM.getSubTotal());
            tvCartBillingShipping.setText(applyVM.getShipping());
            tvCartBillingDisscount.setText(applyVM.getDiscount());
            tvCartBillingTotal.setText(applyVM.getTotal());
        }
    }
}
