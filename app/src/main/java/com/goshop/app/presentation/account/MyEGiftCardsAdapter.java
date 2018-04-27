package com.goshop.app.presentation.account;

import com.goshop.app.Const;
import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightItalicTextView;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoRegularEditText;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.MyEGiftCardsDetailsVM;
import com.goshop.app.presentation.model.MyEGiftModel;
import com.goshop.app.utils.DateFormater;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyEGiftCardsAdapter extends RecyclerView.Adapter {

    private List<MyEGiftModel> myEGiftModels;

    private OnActiveCardClickListener onActiveCardClickListener;

    public MyEGiftCardsAdapter(
        List<MyEGiftModel> myEGiftModels) {
        this.myEGiftModels = myEGiftModels;
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

            case MyEGiftModel.VIEW_TYPE_NO_DATA:
                View nodataView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_points_transactions_nodata, parent, false);
                viewHolder = new NodataViewHolder(nodataView);
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

    public void setOnActiveCardClickListener(OnActiveCardClickListener onActiveCardClickListener) {
        this.onActiveCardClickListener = onActiveCardClickListener;
    }

    interface OnActiveCardClickListener {

        void onActivieClick(String code);

        void onEmptyClick();
    }

    class NodataViewHolder extends RecyclerView.ViewHolder {

        public NodataViewHolder(View itemView) {
            super(itemView);
        }
    }

    class TopViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.et_egift_cards)
        RobotoRegularEditText etEgiftCards;

        @BindView(R.id.tv_btn_active_now)
        RobotoRegularTextView tvBtnActiveNow;

        public TopViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData() {
            tvBtnActiveNow.setOnClickListener(v -> {
                String code = etEgiftCards.getText().toString();
                if (!TextUtils.isEmpty(code)) {
                    onActiveCardClickListener.onActivieClick(code);
                } else {
                    onActiveCardClickListener.onEmptyClick();
                }
            });
        }
    }

    class DetailViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_egift_title)
        RobotoRegularTextView tvEGiftTitle;

        @BindView(R.id.tv_egift_price)
        RobotoLightTextView tvEgiftPrice;

        @BindView(R.id.tv_egift_sender)
        RobotoRegularTextView tvEgiftSender;

        @BindView(R.id.tv_egift_status)
        RobotoLightItalicTextView tvEgiftStatus;

        @BindView(R.id.tv_egift_time)
        RobotoRegularTextView tvEgiftTime;

        public DetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(MyEGiftCardsDetailsVM detailsVM) {
            tvEGiftTitle.setText(detailsVM.getTitle());
            tvEgiftPrice.setText(detailsVM.getPrice());
            tvEgiftSender.setText(detailsVM.getSender());
            // TODO: 2018/4/27  status need api decide
            tvEgiftStatus.setText(detailsVM.getStatus().equals("0")?"Inactive":"Active");
            Log.d("jay", "bindingData: "+detailsVM.getDate());
            tvEgiftTime.setText(Const.EXPIRE_TILL+DateFormater.formaterDDMMMYYYY(detailsVM.getDate()));
        }
    }
    class CenterViewHolder extends RecyclerView.ViewHolder {

        public CenterViewHolder(View itemView) {
            super(itemView);
        }
    }

}
