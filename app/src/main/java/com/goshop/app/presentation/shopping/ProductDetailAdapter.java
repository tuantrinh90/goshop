package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.common.CustomMPEditText;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularEditText;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.PdpAdditionalInformationVM;
import com.goshop.app.presentation.model.PdpExpandTitleVM;
import com.goshop.app.presentation.model.PdpFrequentlyBoughtTogetherVM;
import com.goshop.app.presentation.model.PdpQAVM;
import com.goshop.app.presentation.model.PdpReviewsVM;
import com.goshop.app.presentation.model.ProductDetailModel;
import com.goshop.app.presentation.model.ProductDetailTopVM;
import com.goshop.app.widget.adapter.PDPQaItemAdapter;
import com.goshop.app.widget.adapter.PDPReviewsItemAdapter;
import com.goshop.app.widget.adapter.ProductGridHorizontalAdapter;
import com.goshop.app.widget.listener.OnProductDetailItemClickListener;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailAdapter extends RecyclerView.Adapter {

    private List<ProductDetailModel> allDetailModels;

    private List<ProductDetailModel> displayDetailModels;

    private OnProductDetailItemClickListener onProductDetailItemClickListener;

    private Context context;

    public ProductDetailAdapter(Context context, OnProductDetailItemClickListener onProductDetailItemClickListener,
        List<ProductDetailModel> detailModels) {
        this.onProductDetailItemClickListener = onProductDetailItemClickListener;
        this.allDetailModels = new ArrayList<>();
        this.displayDetailModels = detailModels;
        this.context = context;
    }

    public void setUpdateDatas(List<ProductDetailModel> detailModels) {
        this.allDetailModels.clear();
        this.displayDetailModels.clear();
        this.allDetailModels = detailModels;
        expandAll(allDetailModels);
        notifyDataSetChanged();
    }

    private void expandAll(List<ProductDetailModel> productDetailModels) {
        for (ProductDetailModel detailModel : productDetailModels) {
            if (detailModel instanceof PdpExpandTitleVM) {
                ((PdpExpandTitleVM) detailModel)
                    .setExpand(((PdpExpandTitleVM) detailModel).isClickable());
            }
        }
        displayDetailModels.addAll(productDetailModels);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case ProductDetailModel.DETAIL_TOP_VIEW:
                View bannerView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_product_detail_top, parent, false);
                viewHolder = new ProductDetailTopViewHolder(bannerView);
                break;
            case ProductDetailModel.DETAIL_EXPAND_TITLE:
                View expandView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_expand_space_title, parent, false);
                viewHolder = new WidgetExpandTitleViewHolder(expandView);
                break;
            case ProductDetailModel.DETAIL_SINGLE_TEXT:
                View singleTextView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pdp_product_summary, parent, false);
                viewHolder = new SingleTextViewHolder(singleTextView);
                break;
            case ProductDetailModel.DETAIL_REVIEWS:
                View reviewsView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_widget_reviews, parent, false);
                viewHolder = new PDPReviewsViewHolder(reviewsView);
                break;
            case ProductDetailModel.DETAIL_QUESTION_ANSWER:
                View qaView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_widget_qa, parent, false);
                viewHolder = new PDPQaViewHolder(qaView);
                break;
            case ProductDetailModel.DETAIL_ADDITIONAL_INFORMATION:
                View additionalView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_additional_infomation, parent, false);
                viewHolder = new AdditionalInformationViewHolder(additionalView);
                break;
            case ProductDetailModel.DETAIL_FREQUENTLY_BOUGHT_TOGETHER:
                View boughtView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_widget_horizontal, parent, false);
                viewHolder = new WidgetProductScrollerViewHolder(boughtView);
                break;
            case ProductDetailModel.DETAIL_DELIVERY_INFO:
                View deliveryView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pdp_delivery_info, parent, false);
                viewHolder = new DeliveryInfoViewHolder(deliveryView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ProductDetailTopViewHolder) {
            ((ProductDetailTopViewHolder) holder).bindingData(
                (ProductDetailTopVM) displayDetailModels.get(position));
        } else if (holder instanceof WidgetExpandTitleViewHolder) {
            ((WidgetExpandTitleViewHolder) holder).bindingData(
                (PdpExpandTitleVM) displayDetailModels.get(position), position);
        } else if (holder instanceof PDPReviewsViewHolder) {
            ((PDPReviewsViewHolder) holder).bindingData(
                (PdpReviewsVM) displayDetailModels.get(position));
        } else if (holder instanceof PDPQaViewHolder) {
            ((PDPQaViewHolder) holder).bindingData((PdpQAVM) displayDetailModels.get(position));
        } else if (holder instanceof AdditionalInformationViewHolder) {
            ((AdditionalInformationViewHolder) holder).bindingData(
                (PdpAdditionalInformationVM) displayDetailModels.get(position));
        } else if (holder instanceof WidgetProductScrollerViewHolder) {
            ((WidgetProductScrollerViewHolder) holder).bindingData(
                (PdpFrequentlyBoughtTogetherVM) displayDetailModels.get(position));
        } else if (holder instanceof DeliveryInfoViewHolder) {
            ((DeliveryInfoViewHolder) holder).bindData();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return displayDetailModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return displayDetailModels.size();
    }

    public void expand(int position) {
        int expandPosition = allDetailModels.indexOf(displayDetailModels.get(position));
        int insert = position;
        for (int i = expandPosition + 1; i < allDetailModels.size() && (allDetailModels
            .get(i).getViewType() != ProductDetailModel.DETAIL_EXPAND_TITLE); i++) {
            insert++;
            displayDetailModels.add(insert, allDetailModels.get(i));
        }
        notifyDataSetChanged();
    }

    public void closed(int position) {
        int closePosition = allDetailModels.indexOf(displayDetailModels.get(position));
        for (int i = closePosition + 1; i < allDetailModels.size() && (allDetailModels
            .get(i).getViewType() != ProductDetailModel.DETAIL_EXPAND_TITLE); i++) {
            displayDetailModels.remove(position + 1);
        }
        notifyDataSetChanged();
    }

    class WidgetProductScrollerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recyclerview_horizontal)
        RecyclerView recyclerViewHorizontal;

        public WidgetProductScrollerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpFrequentlyBoughtTogetherVM productScrollerVM) {
            LinearLayoutManager manager = new LinearLayoutManager(itemView.getContext());
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerViewHorizontal.setLayoutManager(manager);
            ProductGridHorizontalAdapter detailAdapter = new
                ProductGridHorizontalAdapter(
                productScrollerVM.getProductsVMS());
            recyclerViewHorizontal.setAdapter(detailAdapter);

        }
    }

    class AdditionalInformationViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recyclerview_additional)
        RecyclerView recyclerViewAdditional;

        public AdditionalInformationViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpAdditionalInformationVM additionalInformationVM) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            recyclerViewAdditional.setLayoutManager(layoutManager);
            recyclerViewAdditional
                .setAdapter(new AdditionalItemAdapter(additionalInformationVM.getItemVMS()));
        }
    }

    class PDPQaViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recyclerview_qa)
        RecyclerView recyclerViewQA;

        @BindView(R.id.tv_answers_num)
        RobotoMediumTextView tvAnswersNum;

        @BindView(R.id.tv_btn_add_more)
        RobotoMediumTextView tvBtnAddMore;

        @BindView(R.id.tv_btn_ask_question)
        RobotoLightTextView tvBtnAskQuestion;

        @BindView(R.id.tv_question_num)
        RobotoMediumTextView tvQuestionNum;

        public PDPQaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindingData(PdpQAVM widgetPDPQaVM) {
            tvAnswersNum.setText(widgetPDPQaVM.getAnswersCounts());
            tvQuestionNum.setText(widgetPDPQaVM.getQuestionCounts());
            LinearLayoutManager manager = new LinearLayoutManager(itemView.getContext());
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerViewQA.setLayoutManager(manager);
            PDPQaItemAdapter detailAdapter = new PDPQaItemAdapter(widgetPDPQaVM.getQavms());
            recyclerViewQA.setAdapter(detailAdapter);
            tvBtnAddMore
                .setOnClickListener(v -> onProductDetailItemClickListener.onMoreQuestionClick());

            tvBtnAskQuestion
                .setOnClickListener(v -> onProductDetailItemClickListener.onAskQuestionClick());
        }
    }

    class PDPReviewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ratingbar_reviews_top)
        RatingBar ratingBar;

        @BindView(R.id.recyclerview_reviews)
        RecyclerView recyclerView;

        @BindView(R.id.tv_btn_add_more)
        RobotoMediumTextView tvBtnAddMore;

        @BindView(R.id.tv_btn_review_top)
        RobotoLightTextView tvBtnReviewTop;

        @BindView(R.id.tv_reviews_total_count)
        RobotoMediumTextView tvReviewsTotalCount;

        public PDPReviewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindingData(PdpReviewsVM pdpReviewsVM) {
            tvReviewsTotalCount.setText(pdpReviewsVM.getReviewsCounts());
            ratingBar.setRating(pdpReviewsVM.getTotalStarStep());
            tvBtnAddMore
                .setOnClickListener(v -> onProductDetailItemClickListener.onMoreReviewClick());

            tvBtnReviewTop
                .setOnClickListener(v -> onProductDetailItemClickListener.onWriteAReviewClick());

            LinearLayoutManager manager = new LinearLayoutManager(itemView.getContext());
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(manager);
            PDPReviewsItemAdapter detailAdapter = new PDPReviewsItemAdapter(
                pdpReviewsVM.getReviewsVMS());
            recyclerView.setAdapter(detailAdapter);
        }
    }

    class DeliveryInfoViewHolder extends RecyclerView.ViewHolder
        implements ProductDetailActivity.OnDeliveryCheckSuccessListener{

        @BindView(R.id.et_product_detail_delivery)
        RobotoRegularEditText etProductDetailDelivery;

        @BindView(R.id.tv_btn_product_detail_check)
        RobotoMediumTextView tvBtnProductDetailCheck;

        public DeliveryInfoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            ((ProductDetailActivity)context).setOnDeliveryCheckSuccessListener(this);
        }

        void bindData() {
            tvBtnProductDetailCheck.setOnClickListener(v -> {
                String zipcode = etProductDetailDelivery.getText().toString();
                onProductDetailItemClickListener.onDeliveryCheckClick(zipcode);
            });
        }

        @Override
        public void success() {
            etProductDetailDelivery.setText("");
        }
    }

    class SingleTextViewHolder extends RecyclerView.ViewHolder {

        public SingleTextViewHolder(View itemView) {
            super(itemView);
        }
    }

    class ProductDetailTopViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.et_product_minus_plus)
        CustomMPEditText etProductMinusPlus;

        @BindView(R.id.iv_product_detail_share)
        ImageView ivProductDetailShare;

        @BindView(R.id.iv_product_detail_wish)
        ImageView ivProductDetailWish;

        @BindView(R.id.rl_product_detail_color)
        RelativeLayout rlProductDetailColor;

        @BindView(R.id.rl_product_detail_size)
        RelativeLayout rlProductDetailSize;

        @BindView(R.id.tv_product_detail_color)
        RobotoRegularTextView tvProductDetailColor;

        @BindView(R.id.tv_product_detail_now)
        RobotoMediumTextView tvProductDetailNow;

        @BindView(R.id.tv_product_detail_old)
        RobotoLightTextView tvProductDetailOld;

        @BindView(R.id.tv_product_detail_percent)
        RobotoLightTextView tvProductDetailPercent;

        @BindView(R.id.tv_product_detail_size)
        RobotoRegularTextView tvProductDetailSize;

        @BindView(R.id.tv_product_detail_title)
        RobotoMediumTextView tvProductDetailTitle;

        public ProductDetailTopViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(ProductDetailTopVM bannerVM) {
            etProductMinusPlus.setText(bannerVM.getAmount());
            tvProductDetailNow.setText(bannerVM.getPriceNow());
            tvProductDetailOld.setText(bannerVM.getPriceOld());
            tvProductDetailOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            //todo hard code wait for decide
            tvProductDetailPercent.setText("(" + bannerVM.getPercent() + ")");

            ivProductDetailWish.setSelected(false);
            ivProductDetailShare.setOnClickListener(v -> {
            });
            ivProductDetailWish.setOnClickListener(
                v -> {
                    onProductDetailItemClickListener
                        .onWishlistSelect(!ivProductDetailWish.isSelected());
                    ivProductDetailWish.setSelected(!ivProductDetailWish.isSelected());

                });
            rlProductDetailColor.setOnClickListener(v -> {
            });
            rlProductDetailSize.setOnClickListener(v -> {
            });
            //todo this is mock data
            tvProductDetailColor.setText(bannerVM.getColorVMS().get(0).getColorName());
            tvProductDetailSize.setText(bannerVM.getSizeVMS().get(0).getSize());
        }

    }

    class WidgetExpandTitleViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.view_title_space_divider)
        View divider;

        @BindView(R.id.iv_item_title_expand)
        ImageView ivItemTitleExpand;

        @BindView(R.id.rl_expand_title)
        RelativeLayout rlExpandTitle;

        @BindView(R.id.tv_item_title_expand)
        RobotoMediumTextView tvItemTitleExpand;

        public WidgetExpandTitleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindingData(PdpExpandTitleVM expandVM, int position) {
            divider.setVisibility(position == 0 ? View.GONE : View.VISIBLE);
            tvItemTitleExpand.setText(expandVM.getTitle());

            if (expandVM.isClickable()) {
                divider.setVisibility(View.GONE);
                //todo wait for api
                ivItemTitleExpand.setVisibility(View.VISIBLE);
                ivItemTitleExpand.setSelected(expandVM.isExpand());
                rlExpandTitle.setSelected(expandVM.isExpand());

                rlExpandTitle.setOnClickListener(v -> {
                    expandVM.setExpand(!expandVM.isExpand());
                    rlExpandTitle.setSelected(expandVM.isExpand());
                    ivItemTitleExpand.setSelected(expandVM.isExpand());
                    if (expandVM.isExpand()) {
                        expand(position);
                    } else {
                        closed(position);
                    }
                });
            } else {
                divider.setVisibility(View.VISIBLE);
                ivItemTitleExpand.setVisibility(View.GONE);
                rlExpandTitle.setSelected(true);
                rlExpandTitle.setOnClickListener(null);
            }
        }


    }
}
