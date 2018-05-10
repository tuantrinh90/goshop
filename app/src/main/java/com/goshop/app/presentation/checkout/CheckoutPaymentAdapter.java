package com.goshop.app.presentation.checkout;

import com.goshop.app.Const;
import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.PaymentMethodVM;
import com.goshop.app.presentation.model.ProfileMetaVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckoutPaymentAdapter extends RecyclerView.Adapter {

    private List<PaymentMethodVM> paymentMethodVMS;

    private PaymentSelectListener paymentSelectListener;

    public CheckoutPaymentAdapter(
        List<PaymentMethodVM> paymentMethodVMS) {
        this.paymentMethodVMS = paymentMethodVMS;
    }

    private void updateDatas(int position) {
        for (int i = 0; i < paymentMethodVMS.size(); i++) {
            paymentMethodVMS.get(i).setSelect(i == position);
        }
        notifyDataSetChanged();
    }

    public void setPaymentSelectListener(PaymentSelectListener paymentSelectListener) {
        this.paymentSelectListener = paymentSelectListener;
    }

    public void setPaymentMethodVMS(List<PaymentMethodVM> paymentMethodVMS) {
        this.paymentMethodVMS.clear();
        this.paymentMethodVMS = paymentMethodVMS;
        updateDatas(0);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.item_checkout_payment, viewGroup, false);
        return new PaymentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((PaymentViewHolder) viewHolder).bindingData(paymentMethodVMS.get(i), i);
    }

    @Override
    public int getItemCount() {
        return paymentMethodVMS.size();
    }

    class PaymentViewHolder extends RecyclerView.ViewHolder implements CheckoutActivity
        .OnPaymentListListener {

        @BindView(R.id.iv_checkout_payment)
        ImageView ivCheckoutPayment;

        @BindView(R.id.tv_checkout_payment)
        RobotoLightTextView tvCheckoutPayment;

        @BindView(R.id.ll_checkout_payment)
        LinearLayout llCheckoutPayment;

        @BindView(R.id.tv_checkout_installment)
        RobotoRegularTextView tvCheckoutInstallment;

        public PaymentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            ((CheckoutActivity)itemView.getContext()).setOnPaymentListListener(this);
        }

        void bindingData(PaymentMethodVM paymentMethodVM, int position) {
            tvCheckoutPayment.setText(paymentMethodVM.getTitle());
            ivCheckoutPayment.setSelected(paymentMethodVM.isSelect());
            llCheckoutPayment.setOnClickListener(v -> {
                if (!paymentMethodVM.isSelect()) {
                    updateDatas(position);
                    paymentSelectListener.onPaymentSelect();
                    if (paymentMethodVM.getCode().equals(Const.PAYMENT_CODE)) {
                        tvCheckoutInstallment.setVisibility(View.VISIBLE);
                    } else {
                        tvCheckoutInstallment.setVisibility(View.GONE);
                    }
                }
            });
            tvCheckoutInstallment.setOnClickListener(
                v -> paymentSelectListener.onOptionsPop(paymentMethodVM.getMonths()));
        }

        @Override
        public void onListSelect(String content) {
            tvCheckoutInstallment.setText(content);
        }
    }

    public interface PaymentSelectListener {

        void onPaymentSelect();

        void onOptionsPop(List<ProfileMetaVM> profileMetaVMS);
    }
}
