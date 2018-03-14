package com.goshop.app.widget.adapter;

import com.goshop.app.R;
import com.goshop.app.common.CustomMPEditText;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomEditText;
import com.goshop.app.common.view.CustomPagerCircleIndicator;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.PdpAdditionalInformationVM;
import com.goshop.app.presentation.model.PdpExpandTitleVM;
import com.goshop.app.presentation.model.PdpFrequentlyBoughtTogetherVM;
import com.goshop.app.presentation.model.PdpQAVM;
import com.goshop.app.presentation.model.PdpReviewsVM;
import com.goshop.app.presentation.model.ProductDetailModel;
import com.goshop.app.presentation.model.ProductDetailTopVM;
import com.goshop.app.presentation.shopping.PdpBannerAdapter;

import android.graphics.Paint;
import android.support.v4.view.ViewPager;
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

public class WidgetPdpAdapter extends RecyclerView.Adapter {

    private List<ProductDetailModel> allDetailModels;

    private List<ProductDetailModel> displayDetailModels;

    private OnProductDetailItemClickListener onProductDetailItemClickListener;

    public WidgetPdpAdapter(
        List<ProductDetailModel> detailModels) {
        this.allDetailModels = new ArrayList<>();
        this.displayDetailModels = detailModels;
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
                    .inflate(R.layout.item_product_detail_top_fix, parent, false);
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
                    .inflate(R.layout.item_additional_information, parent, false);
                viewHolder = new AdditionalInformationViewHolder(additionalView);
                break;
            case ProductDetailModel.DETAIL_FREQUENTLY_BOUGHT_TOGETHER:
                View boughtView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_widget_horizontal, parent, false);
                viewHolder = new WidgetProductScrollerViewHolder(boughtView);
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

    public void setOnProductDetailItemClickListener(
        OnProductDetailItemClickListener onProductDetailItemClickListener) {
        this.onProductDetailItemClickListener = onProductDetailItemClickListener;
    }

    public interface OnProductDetailItemClickListener {

        void onCheckClick();

        void onWriteAReviewClick();

        void onMoreReviewClick();

        void onAskQuestionClick();

        void onMoreQuestionClick();
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
            WidgetProductGridHorizontalAdapter detailAdapter = new
                WidgetProductGridHorizontalAdapter(
                productScrollerVM.getProductsVMS());
            recyclerViewHorizontal.setAdapter(detailAdapter);
        }
    }

    class AdditionalInformationViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_additional_info_lable)
        CustomTextView tvAdditionalInfoLable;

        @BindView(R.id.tv_additional_info_value)
        CustomTextView tvAdditionalInfoValue;

        public AdditionalInformationViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpAdditionalInformationVM additionalInformationVM) {
            tvAdditionalInfoLable.setText(additionalInformationVM.getLable());
            tvAdditionalInfoValue.setText(additionalInformationVM.getUnit());
        }
    }

    class PDPQaViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recyclerview_qa)
        RecyclerView recyclerViewQA;

        @BindView(R.id.tv_answers_num)
        CustomBoldTextView tvAnswersNum;

        @BindView(R.id.tv_btn_add_more)
        CustomBoldTextView tvBtnAddMore;

        @BindView(R.id.tv_question_num)
        CustomBoldTextView tvQuestionNum;

        @BindView(R.id.tv_btn_ask_question)
        CustomTextView tvBtnAskQuestion;

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
            tvBtnAddMore.setOnClickListener(v -> {
                onProductDetailItemClickListener.onMoreQuestionClick();
            });

            tvBtnAskQuestion.setOnClickListener(v->onProductDetailItemClickListener.onAskQuestionClick());
        }
    }

    class PDPReviewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ratingbar_reviews_top)
        RatingBar ratingBar;

        @BindView(R.id.recyclerview_reviews)
        RecyclerView recyclerView;

        @BindView(R.id.tv_btn_add_more)
        CustomBoldTextView tvBtnAddMore;

        @BindView(R.id.tv_btn_review_top)
        CustomTextView tvBtnReviewTop;

        @BindView(R.id.tv_reviews_total_count)
        CustomBoldTextView tvReviewsTotalCount;

        public PDPReviewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindingData(PdpReviewsVM pdpReviewsVM) {
            tvReviewsTotalCount.setText(pdpReviewsVM.getReviewsCounts());
            ratingBar.setRating(pdpReviewsVM.getTotalStarStep());
            tvBtnAddMore.setOnClickListener(v -> {
                onProductDetailItemClickListener.onMoreReviewClick();
            });

            tvBtnReviewTop.setOnClickListener(v->onProductDetailItemClickListener.onWriteAReviewClick());

            LinearLayoutManager manager = new LinearLayoutManager(itemView.getContext());
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(manager);
            PDPReviewsItemAdapter detailAdapter = new PDPReviewsItemAdapter(
                pdpReviewsVM.getReviewsVMS());
            recyclerView.setAdapter(detailAdapter);
        }
    }

    class SingleTextViewHolder extends RecyclerView.ViewHolder {

        public SingleTextViewHolder(View itemView) {
            super(itemView);
        }
    }

    class ProductDetailTopViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.indicator_product_detail_top)
        CustomPagerCircleIndicator circleIndicator;

        @BindView(R.id.et_product_detail_delivery)
        CustomEditText etProductDetailDelivery;

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

        @BindView(R.id.tv_btn_product_detail_check)
        CustomBoldTextView tvBtnProductDetailCheck;

        @BindView(R.id.tv_product_detail_color)
        CustomTextView tvProductDetailColor;

        @BindView(R.id.tv_product_detail_now)
        CustomBoldTextView tvProductDetailNow;

        @BindView(R.id.tv_product_detail_old)
        CustomTextView tvProductDetailOld;

        @BindView(R.id.tv_product_detail_percent)
        CustomTextView tvProductDetailPercent;

        @BindView(R.id.tv_product_detail_size)
        CustomTextView tvProductDetailSize;

        @BindView(R.id.tv_product_detail_title)
        CustomBoldTextView tvProductDetailTitle;

        @BindView(R.id.viewpager_product_detail_top)
        ViewPager viewPager;

        public ProductDetailTopViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(ProductDetailTopVM bannerVM) {

            viewPager
                .setAdapter(new PdpBannerAdapter(itemView.getContext(), bannerVM.getBannerUrls()));
            circleIndicator.setViewPager(viewPager);
            etProductMinusPlus.setText(bannerVM.getAmount());
            tvProductDetailNow.setText(bannerVM.getPriceNow());
            tvProductDetailOld.setText(bannerVM.getPriceOld());
            tvProductDetailOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            tvProductDetailPercent.setText("(" + bannerVM.getPercent() + ")");

            ivProductDetailWish.setSelected(false);
            ivProductDetailShare.setOnClickListener(v -> {
            });
            ivProductDetailWish.setOnClickListener(v -> {
                ivProductDetailWish.setSelected(!ivProductDetailWish.isSelected());
            });
            rlProductDetailColor.setOnClickListener(v -> {
            });
            rlProductDetailSize.setOnClickListener(v -> {
            });
            tvBtnProductDetailCheck.setOnClickListener(v -> {
                onProductDetailItemClickListener.onCheckClick();
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
        CustomBoldTextView tvItemTitleExpand;

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
