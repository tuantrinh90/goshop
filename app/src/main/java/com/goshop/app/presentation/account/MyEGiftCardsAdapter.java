package com.goshop.app.presentation.account;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomEditText;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.MyEGiftCardsDetailsVM;
import com.goshop.app.presentation.model.MyEGiftModel;
import com.goshop.app.utils.NumberFormater;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyEGiftCardsAdapter extends RecyclerView.Adapter {

    private List<MyEGiftModel> myEGiftModels;

    public MyEGiftCardsAdapter(
        List<MyEGiftModel> myEGiftModels) {
        this.myEGiftModels = myEGiftModels;
    }

    public void setUpDatas(List<MyEGiftModel> myEGiftModels) {
        this.myEGiftModels.clear();
        this.myEGiftModels = myEGiftModels;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case MyEGiftModel.VIEW_TYPE_TOP:
                View topView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_egiftcards_top, parent, false);
                viewHolder = new TopViewHolder(topView);
                break;

            case MyEGiftModel.VIEW_TYPE_CENTER:
                View centerView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_egiftcards_center, parent, false);
                viewHolder = new CenterViewHolder(centerView);
                break;
            case MyEGiftModel.VIEW_TYPE_DETAIL:
                View detailView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_egiftcards_detail, parent, false);
                viewHolder = new DetailViewHolder(detailView);
                break;

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyEGiftModel myEGiftModel = myEGiftModels.get(position);
        if (holder instanceof DetailViewHolder) {
            ((DetailViewHolder) holder).bindingData((MyEGiftCardsDetailsVM) myEGiftModel);
        } else if (holder instanceof TopViewHolder) {
            ((TopViewHolder) holder).bindingData();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return myEGiftModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return myEGiftModels.size();
    }

    class TopViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.et_egift_cards)
        CustomEditText etEgiftCards;

        @BindView(R.id.tv_btn_active_now)
        CustomTextView tvBtnActiveNow;

        public TopViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData() {
            tvBtnActiveNow.setOnClickListener(v -> {
            });
        }
    }

    class DetailViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_egift_title)
        CustomBoldTextView tvEGiftTitle;

        @BindView(R.id.tv_egift_price)
        CustomTextView tvEgiftPrice;

        @BindView(R.id.tv_egift_sender)
        CustomTextView tvEgiftSender;

        @BindView(R.id.tv_egift_status)
        CustomTextView tvEgiftStatus;

        @BindView(R.id.tv_egift_time)
        CustomTextView tvEgiftTime;

        public DetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(MyEGiftCardsDetailsVM detailsVM) {
            tvEGiftTitle.setText(detailsVM.getTitle());
            tvEgiftPrice.setText(NumberFormater.formaterMoneyNoRM(detailsVM.getPrice()));
            tvEgiftSender.setText(detailsVM.getSender());
            tvEgiftStatus.setText(detailsVM.getStatus());
            tvEgiftTime.setText(detailsVM.getDate());
        }
    }

    class CenterViewHolder extends RecyclerView.ViewHolder {

        public CenterViewHolder(View itemView) {
            super(itemView);
        }
    }

}
