package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.common.CustomMinusPlusEditText;
import com.goshop.app.common.FlowLayout;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomPagerCircleIndicator;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.PdpAdditionalInformationVM;
import com.goshop.app.presentation.model.PdpBannerVM;
import com.goshop.app.presentation.model.PdpDeliveryInfoVM;
import com.goshop.app.presentation.model.PdpDetailsContentVM;
import com.goshop.app.presentation.model.PdpExpandTitleVM;
import com.goshop.app.presentation.model.PdpFrequentlyBoughtTogetherVM;
import com.goshop.app.presentation.model.PdpProductSummaryVM;
import com.goshop.app.presentation.model.PdpQAContentTopVM;
import com.goshop.app.presentation.model.PdpQAContentVM;
import com.goshop.app.presentation.model.PdpReviewsContentVM;
import com.goshop.app.presentation.model.PdpReviewsTopVM;
import com.goshop.app.presentation.model.PdpTipVM;
import com.goshop.app.presentation.model.PdpTopContentVM;
import com.goshop.app.presentation.model.ProductDetailModel;

import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailAdapter extends RecyclerView.Adapter {

    private boolean addData = true;

    private List<ProductDetailModel> allDetailModels;

    private List<ProductDetailModel> displayDetailModels;

    public ProductDetailAdapter(
        List<ProductDetailModel> detailModels) {
        allDetailModels = new ArrayList<>();
        this.displayDetailModels = detailModels;
    }

    public void updateDatas(List<ProductDetailModel> detailModels) {
        this.displayDetailModels.clear();
        this.allDetailModels.clear();
        this.allDetailModels = detailModels;
        for (int i = 0; i < allDetailModels.size(); i++) {
            ProductDetailModel detailModel = allDetailModels.get(i);
            if (addData) {
                displayDetailModels.add(detailModel);
                if (detailModel instanceof PdpExpandTitleVM) {
                    if (((PdpExpandTitleVM) detailModel)
                        .getIcon() == PdpExpandTitleVM.HAS_ICON && !((PdpExpandTitleVM) detailModel)
                        .isExpand()) {
                        addData = false;
                    }
                }
            } else {
                if (detailModel instanceof PdpExpandTitleVM) {
                    addData = true;
                    displayDetailModels.add(detailModel);
                    if (((PdpExpandTitleVM) detailModel)
                        .getIcon() == PdpExpandTitleVM.HAS_ICON && !((PdpExpandTitleVM) detailModel)
                        .isExpand()) {
                        addData = false;
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case ProductDetailModel.DETAIL_TOP_BANNER:
                View bannerView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pdp_top_banner, parent, false);
                viewHolder = new TopBannerViewHolder(bannerView);
                break;
            case ProductDetailModel.DETAIL_TOP_CONTENT:
                View topContentView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pdp_top_content, parent, false);
                viewHolder = new TopContentViewHolder(topContentView);
                break;
            case ProductDetailModel.DETAIL_EXPAND_TITLE:
                View expandView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pdp_expand_title, parent, false);
                viewHolder = new ExpandTitleViewHolder(expandView);
                break;
            case ProductDetailModel.DETAIL_PRODUCT_SUMMARY_CONTENT:
                View summaryView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pdp_product_summary, parent, false);
                viewHolder = new SummaryViewHolder(summaryView);
                break;
            case ProductDetailModel.DETAIL_DELIVERY_INFO:
                View deliveryView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pdp_delivery_info, parent, false);
                viewHolder = new DeliveryViewHolder(deliveryView);
                break;
            case ProductDetailModel.DETAIL_DETAILS_CONTENT:
                //todo(helen)this part need decide
                View detailsContentView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pdp_product_summary, parent, false);
                viewHolder = new DetailsContentViewHolder(detailsContentView);
                break;
            case ProductDetailModel.DETAIL_QA_CONTENT:
                View qaContent = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pdp_qa_content, parent, false);
                viewHolder = new QAViewHolder(qaContent);
                break;
            case ProductDetailModel.DETAIL_QA_CONTENT_TOP:
                View qaTopView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pdp_qa_top, parent, false);
                viewHolder = new QATopViewHolder(qaTopView);
                break;
            case ProductDetailModel.DETAIL_REVIEWS_CONTENT_TOP:
                View reviewTopView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pdp_reviews_top, parent, false);
                viewHolder = new ReviewsTopViewHolder(reviewTopView);
                break;
            case ProductDetailModel.DETAIL_REVIEWS_CONTENT:
                View reviewsView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pdp_reviews_content, parent, false);
                viewHolder = new ReviewsViewHolder(reviewsView);
                break;
            case ProductDetailModel.DETAIL_ADDITIONAL_INFORMATION:
                View additionalView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pdp_additional_information_content, parent, false);
                viewHolder = new AdditionalInfoViewHolder(additionalView);
                break;
            case ProductDetailModel.DETAIL_FREQUENTLY_BOUGHT_TOGETHER:
                View boughtView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pdp_frequently_bought_together_content, parent, false);
                viewHolder = new BoughtTogetherViewHolder(boughtView);
                break;

            case ProductDetailModel.DETAIL_VIEW_MORE:
                View addMoreView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_view_more, parent, false);
                viewHolder = new AddMoreViewHolder(addMoreView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ProductDetailModel detailModel = displayDetailModels.get(position);
        if (holder instanceof TopBannerViewHolder) {
            ((TopBannerViewHolder) holder).bindingData((PdpBannerVM) detailModel);
        } else if (holder instanceof TopContentViewHolder) {
            ((TopContentViewHolder) holder).bindingData((PdpTopContentVM) detailModel);
        } else if (holder instanceof ExpandTitleViewHolder) {
            ((ExpandTitleViewHolder) holder).bindingData((PdpExpandTitleVM) detailModel, position);
        } else if (holder instanceof SummaryViewHolder) {
            ((SummaryViewHolder) holder).bindingData((PdpProductSummaryVM) detailModel);
        } else if (holder instanceof DeliveryViewHolder) {
            ((DeliveryViewHolder) holder).bindingData((PdpDeliveryInfoVM) detailModel);
        } else if (holder instanceof DetailsContentViewHolder) {
            //Todo(helen) this is need decide
            ((DetailsContentViewHolder) holder).bindingData((PdpDetailsContentVM) detailModel);
        } else if (holder instanceof QAViewHolder) {
            ((QAViewHolder) holder).bindingData((PdpQAContentVM) detailModel);
        } else if (holder instanceof QATopViewHolder) {
            ((QATopViewHolder) holder).bindingData((PdpQAContentTopVM) detailModel);
        } else if (holder instanceof ReviewsTopViewHolder) {
            ((ReviewsTopViewHolder) holder).bindingData((PdpReviewsTopVM) detailModel);
        } else if (holder instanceof ReviewsViewHolder) {
            ((ReviewsViewHolder) holder).bindingData((PdpReviewsContentVM) detailModel);
        } else if (holder instanceof AdditionalInfoViewHolder) {
            ((AdditionalInfoViewHolder) holder)
                .bindingData((PdpAdditionalInformationVM) detailModel);
        } else if (holder instanceof BoughtTogetherViewHolder) {
            ((BoughtTogetherViewHolder) holder)
                .bindingData((PdpFrequentlyBoughtTogetherVM) detailModel);
        } else if (holder instanceof AddMoreViewHolder) {
            ((AddMoreViewHolder) holder).bindingData(position);
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

    private void expand(int position) {
        int expandPosition = allDetailModels.indexOf(displayDetailModels.get(position));
        int insert = position;
        int count = 0;
        for (int i = expandPosition + 1; i < allDetailModels.size() && (allDetailModels.get(i)
            .getViewType() != ProductDetailModel.DETAIL_EXPAND_TITLE); i++) {
            count++;
            insert++;
            displayDetailModels.add(insert, allDetailModels.get(i));
        }
        //Todo(helen)this part need to decide
        notifyDataSetChanged();
//        notifyItemRangeInserted(position + 1, count);
    }

    private void closeUp(int position) {
        int closePosition = allDetailModels.indexOf(displayDetailModels.get(position));
        int count = 0;
        for (int i = closePosition + 1; i < allDetailModels.size() && (allDetailModels.get(i)
            .getViewType() != ProductDetailModel.DETAIL_EXPAND_TITLE); i++) {
            count++;
            displayDetailModels.remove(position + 1);
        }
        //Todo(helen)this part need to decide
        notifyDataSetChanged();
//        notifyItemRangeRemoved(position + 1, count);

    }

    class TopBannerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cpci_indicator)
        CustomPagerCircleIndicator circleIndicator;

        @BindView(R.id.vp_pdp_banner)
        ViewPager viewPager;

        public TopBannerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpBannerVM bannerVM) {
            viewPager.setAdapter(new PdpBannerAdapter(itemView.getContext(), bannerVM.getUrls()));
            circleIndicator.setViewPager(viewPager);
        }
    }

    class SummaryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_pdp_product_summary_content)
        CustomTextView tvContent;

        public SummaryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpProductSummaryVM summaryVM) {
            //todo(helen) this is wait for complete
        }
    }

    class AddMoreViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_btn_pdp_add_more)
        CustomTextView tvBtnPdpAddMore;

        public AddMoreViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(int position) {
            itemView.setOnClickListener(v -> {
            });
        }
    }

    class DeliveryViewHolder extends RecyclerView.ViewHolder {

        public DeliveryViewHolder(View itemView) {
            super(itemView);
            //todo(helen) this is wait for complete
//            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpDeliveryInfoVM deliveryInfoVM) {
        }
    }

    class AdditionalInfoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_pdp_additional_lable)
        CustomTextView tvPdpAdditionalLable;

        public AdditionalInfoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpAdditionalInformationVM additionalInformationVM) {
            tvPdpAdditionalLable.setText(additionalInformationVM.getLable());
        }
    }

    class DetailsContentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_pdp_product_summary_content)
        CustomTextView tvContent;

        public DetailsContentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpDetailsContentVM detailsContentVM) {
            //todo(helen) this is wait for complete
        }
    }

    class BoughtTogetherViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recycler_pdp_frequently)
        RecyclerView recyclerPdpFrequently;

        public BoughtTogetherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpFrequentlyBoughtTogetherVM boughtTogetherVM) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerPdpFrequently.setLayoutManager(layoutManager);
            PdpFrequentlyBoughtAdapter boughtAdapter = new PdpFrequentlyBoughtAdapter(
                boughtTogetherVM.getDataVMS());
            recyclerPdpFrequently.setAdapter(boughtAdapter);
        }
    }

    class QATopViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_pdp_qa_top_answers_num)
        CustomTextView tvPdpQaTopAnswersNum;

        @BindView(R.id.tv_pdp_qa_top_question_num)
        CustomTextView tvPdpQaTopQuestionNum;

        public QATopViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpQAContentTopVM contentTopVM) {
            tvPdpQaTopAnswersNum.setText(contentTopVM.getAnswerNum());
            tvPdpQaTopQuestionNum.setText(contentTopVM.getQuestionNum());
        }
    }

    class QAViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_pdp_qa_answer)
        CustomTextView tvPdpQaAnswer;

        @BindView(R.id.tv_pdp_qa_answer_detail)
        CustomTextView tvPdpQaAnswerDetail;

        @BindView(R.id.tv_pdp_qa_question)
        CustomTextView tvPdpQaQuestion;

        @BindView(R.id.tv_pdp_qa_questioner_detail)
        CustomTextView tvPdpQaQuestionerDetail;

        public QAViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpQAContentVM qaContentVM) {
            tvPdpQaQuestion.setText(qaContentVM.getQuestion());
            tvPdpQaQuestionerDetail.setText(qaContentVM.getQuestionerDetail());
            tvPdpQaAnswer.setText(qaContentVM.getAnswer());
            tvPdpQaAnswerDetail.setText(qaContentVM.getAnswerDetail());
        }
    }

    class ReviewsTopViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ratingbar_pdp_reviews_top)
        RatingBar ratingBar;

        @BindView(R.id.tv_pdp_reviews_top_num)
        CustomTextView tvPdpReviewsTopNum;

        public ReviewsTopViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpReviewsTopVM reviewsTopVM) {
            tvPdpReviewsTopNum.setText(reviewsTopVM.getReviewNum());
            ratingBar.setRating(reviewsTopVM.getReviewRating());
        }
    }

    class ReviewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ratingbar_pdp_review_content)
        RatingBar ratingBar;

        @BindView(R.id.tv_pdp_review_info)
        CustomTextView tvPdpReviewInfo;

        @BindView(R.id.tv_pdp_review_review)
        CustomBoldTextView tvPdpReviewReview;

        @BindView(R.id.tv_pdp_reviewer_detail)
        CustomTextView tvPdpReviewerDetail;

        public ReviewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpReviewsContentVM reviewsContentVM) {
            ratingBar.setRating(reviewsContentVM.getRatingNum());
            tvPdpReviewReview.setText(reviewsContentVM.getReview());
            tvPdpReviewInfo.setText(reviewsContentVM.getReviewInfo());
            tvPdpReviewerDetail.setText(reviewsContentVM.getReviewerDetail());
        }
    }

    class TopContentViewHolder extends RecyclerView.ViewHolder {

        List<Integer> childColors;

        ColorSelectorHelper colorSelectorHelper;

        @BindView(R.id.flowlayout_pdp_tips)
        FlowLayout flowLayoutPdpTips;

        @BindView(R.id.mpet_pdp_quantily)
        CustomMinusPlusEditText mpetPdpQuantily;

        @BindView(R.id.radio_group_pdp_color)
        RadioGroup radioGroupPdpColor;

        @BindView(R.id.ratingbar_pdp_top)
        RatingBar ratingBar;

        @BindView(R.id.tv_pdp_top_now_currency)
        CustomBoldTextView tvPdpTopNowCurrency;

        @BindView(R.id.tv_pdp_top_old_currency)
        CustomTextView tvPdpTopOldCurrency;

        @BindView(R.id.tv_pdp_top_percent)
        CustomTextView tvPdpTopPercent;

        @BindView(R.id.tv_pdp_top_rating_counts)
        CustomTextView tvPdpTopRating;

        @BindView(R.id.tv_pdp_top_title)
        CustomBoldTextView tvPdpTopTitle;

        private List<PdpTipVM> tips;

        public TopContentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            colorSelectorHelper = new ColorSelectorHelper();
            childColors = new ArrayList<>();
            tips = new ArrayList<>();
        }

        void bindingData(PdpTopContentVM contentVM) {
            tvPdpTopTitle.setText(contentVM.getTitle());
            tvPdpTopNowCurrency.setText(contentVM.getNowPrice());
            tvPdpTopOldCurrency.setText(contentVM.getOldPrice());
            tvPdpTopOldCurrency.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            tvPdpTopPercent.setText(contentVM.getPercent());
            tvPdpTopRating.setText(contentVM.getCounts());
            ratingBar.setRating(contentVM.getRatingNum());
            mpetPdpQuantily.setText(contentVM.getQuantity());
            childColors.clear();
            childColors = contentVM.getColors();
            colorSelectorHelper.createSelector(radioGroupPdpColor, childColors);
            radioGroupPdpColor.setOnCheckedChangeListener(((group, checkedId) -> {
                switch (checkedId) {
                    //TODO(helen)this part need to decide
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }));

            tips.clear();
            tips = contentVM.getTips();
            LayoutInflater mInflater = LayoutInflater.from(itemView.getContext());
            for (int i = 0; i < tips.size(); i++) {
                CustomTextView tipView = (CustomTextView) mInflater
                    .inflate(R.layout.item_pdp_tips_text,
                        flowLayoutPdpTips, false);
                ColorSelectorHelper
                    .setTipsColor(tipView, tips.get(i).getTextColor(), tips.get(i).getBgColor());
                tipView.setText(tips.get(i).getContent());
                flowLayoutPdpTips.addView(tipView);
            }
        }
    }

    class ExpandTitleViewHolder extends RecyclerView.ViewHolder {

        //Todo(helen)this wait for complete
        @BindView(R.id.iv_item_pdp_expand)
        ImageView ivItemPdpExpand;

        @BindView(R.id.rl_pdp_expand_title)
        RelativeLayout rlPdpExpandTitle;

        @BindView(R.id.tv_item_pdp_expand)
        CustomBoldTextView tvItemPdpExpand;

        public ExpandTitleViewHolder(View itemView) {
            super(itemView);
            //todo(helen) this is wait for complete
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpExpandTitleVM expandTitleVM, int position) {
            //Todo(helen)this wait for complete
            tvItemPdpExpand.setText(expandTitleVM.getTitle());
            if (expandTitleVM.getIcon() == PdpExpandTitleVM.NO_ICON) {
                ivItemPdpExpand.setVisibility(View.GONE);
                rlPdpExpandTitle.setSelected(true);
                rlPdpExpandTitle.setOnClickListener(null);
            } else {
                ivItemPdpExpand.setVisibility(View.VISIBLE);
                ivItemPdpExpand.setSelected(expandTitleVM.isExpand());
                rlPdpExpandTitle.setSelected(expandTitleVM.isExpand());
                rlPdpExpandTitle.setOnClickListener(v -> {
                    expandTitleVM.setExpand(!expandTitleVM.isExpand());
                    ivItemPdpExpand.setSelected(expandTitleVM.isExpand());
                    rlPdpExpandTitle.setSelected(expandTitleVM.isExpand());
                    if (expandTitleVM.isExpand()) {
                        expand(position);
                    } else {
                        closeUp(position);
                    }
                });
            }
        }
    }
}
