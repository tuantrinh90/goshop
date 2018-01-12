package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.PdpAdditionalInformationVM;
import com.goshop.app.presentation.model.PdpBannerVM;
import com.goshop.app.presentation.model.PdpDeliveryInfoVM;
import com.goshop.app.presentation.model.PdpDetailsContentVM;
import com.goshop.app.presentation.model.PdpExpandTitleVM;
import com.goshop.app.presentation.model.PdpFrequentlyBoughtTogetherVM;
import com.goshop.app.presentation.model.PdpProductSummaryVM;
import com.goshop.app.presentation.model.PdpQAContentVM;
import com.goshop.app.presentation.model.PdpReviewsContentVM;
import com.goshop.app.presentation.model.PdpTopContentVM;
import com.goshop.app.presentation.model.ProductDetailModel;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by helen on 2018/1/11.
 */

public class ProductDetailAdapter extends RecyclerView.Adapter {

    private List<ProductDetailModel> detailModels;

    public ProductDetailAdapter(
        List<ProductDetailModel> detailModels) {
        this.detailModels = detailModels;
    }

    public void updateDatas(List<ProductDetailModel> detailModels) {
        this.detailModels.clear();
        this.detailModels.addAll(detailModels);
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
            case ProductDetailModel.DETAIL_PRODUCT_SUMMARY:
                View summaryView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pdp_product_summary, parent, false);
                viewHolder = new SummaryViewHolder(summaryView);
                break;
            case ProductDetailModel.DETAIL_DELIVERY_INFO:
                View deliveryView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pdp_delivery_info, parent, false);
                viewHolder = new DeliveryViewHolder(deliveryView);
                break;
            case ProductDetailModel.DETAIL_EXPAND_TITLE:
                View expandView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pdp_expand_title, parent, false);
                viewHolder = new ExpandTitleViewHolder(expandView);
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
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TopBannerViewHolder) {
            PdpBannerVM bannerVM = (PdpBannerVM) detailModels.get(position);
            ((TopBannerViewHolder) holder).bindingData(bannerVM);
        } else if (holder instanceof TopContentViewHolder) {
            PdpTopContentVM topContentVM = (PdpTopContentVM) detailModels.get(position);
            ((TopContentViewHolder) holder).bindingData(topContentVM);
        } else if (holder instanceof ExpandTitleViewHolder) {
            PdpExpandTitleVM expandTitleVM = (PdpExpandTitleVM) detailModels.get(position);
            ((ExpandTitleViewHolder) holder).bindingData(expandTitleVM);
        } else if (holder instanceof SummaryViewHolder) {
            PdpProductSummaryVM summaryVM = (PdpProductSummaryVM) detailModels.get(position);
            ((SummaryViewHolder) holder).bindingData(summaryVM);
        } else if (holder instanceof DeliveryViewHolder) {
            PdpDeliveryInfoVM deliveryInfoVM = (PdpDeliveryInfoVM) detailModels.get(position);
            ((DeliveryViewHolder) holder).bindingData(deliveryInfoVM);
        } else if (holder instanceof DetailsContentViewHolder) {
            //Todo(helen) this is need decide
            PdpDetailsContentVM detailsContentVM = (PdpDetailsContentVM) detailModels.get(position);
            ((DetailsContentViewHolder) holder).bindingData(detailsContentVM);
        } else if (holder instanceof QAViewHolder) {
            PdpQAContentVM qaContentVM = (PdpQAContentVM) detailModels.get(position);
            ((QAViewHolder) holder).bindingData(qaContentVM);
        } else if (holder instanceof ReviewsViewHolder) {
            PdpReviewsContentVM reviewsContentVM = (PdpReviewsContentVM) detailModels.get(position);
            ((ReviewsViewHolder) holder).bindingData(reviewsContentVM);
        } else if (holder instanceof AdditionalInfoViewHolder) {
            PdpAdditionalInformationVM additionalInformationVM = (PdpAdditionalInformationVM)
                detailModels
                    .get(position);
            ((AdditionalInfoViewHolder) holder).bindingData(additionalInformationVM);
        } else if (holder instanceof BoughtTogetherViewHolder) {
            PdpFrequentlyBoughtTogetherVM togetherVM = (PdpFrequentlyBoughtTogetherVM) detailModels
                .get(position);
            ((BoughtTogetherViewHolder) holder).bindingData(togetherVM);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return detailModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return detailModels.size();
    }

    class TopBannerViewHolder extends RecyclerView.ViewHolder {

        public TopBannerViewHolder(View itemView) {
            super(itemView);
            //todo(helen) this is wait for complete
//            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpBannerVM bannerVM) {
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

        public DetailsContentViewHolder(View itemView) {
            super(itemView);
            //todo(helen) this is wait for complete
//            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpDetailsContentVM detailsContentVM) {
        }
    }

    class BoughtTogetherViewHolder extends RecyclerView.ViewHolder {

        public BoughtTogetherViewHolder(View itemView) {
            super(itemView);
            //todo(helen) this is wait for complete
//            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpFrequentlyBoughtTogetherVM boughtTogetherVM) {
        }
    }

    class QAViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_pdp_qa_question)
        CustomTextView tvPdpQaQuestion;
        @BindView(R.id.tv_pdp_qa_questioner_detail)
        CustomTextView tvPdpQaQuestionerDetail;
        @BindView(R.id.tv_pdp_qa_answer)
        CustomTextView tvPdpQaAnswer;
        @BindView(R.id.tv_pdp_qa_answer_detail)
        CustomTextView tvPdpQaAnswerDetail;

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

    class ReviewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ratingbar_pdp_review_content)
        RatingBar ratingBar;
        @BindView(R.id.tv_pdp_review_review)
        CustomBoldTextView tvPdpReviewReview;
        @BindView(R.id.tv_pdp_review_info)
        CustomTextView tvPdpReviewInfo;
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

        public TopContentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpTopContentVM contentVM) {
            tvPdpTopTitle.setText(contentVM.getTitle());
            tvPdpTopNowCurrency.setText(contentVM.getNowPrice());
            tvPdpTopOldCurrency.setText(contentVM.getOldPrice());
            tvPdpTopOldCurrency.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            tvPdpTopPercent.setText(contentVM.getPercent());
            tvPdpTopRating.setText(contentVM.getCounts());
            ratingBar.setRating(contentVM.getRatingNum());
        }
    }

    class ExpandTitleViewHolder extends RecyclerView.ViewHolder {

        //Todo(helen)this wait for complete
        @BindView(R.id.iv_item_pdp_expand)
        ImageView ivItemPdpExpand;

        @BindView(R.id.tv_item_pdp_expand)
        CustomTextView tvItemPdpExpand;

        public ExpandTitleViewHolder(View itemView) {
            super(itemView);
            //todo(helen) this is wait for complete
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpExpandTitleVM expandTitleVM) {
            //Todo(helen)this wait for complete
            tvItemPdpExpand.setText(expandTitleVM.getTitle());
            if (expandTitleVM.getIcon() == PdpExpandTitleVM.NO_ICON) {
                ivItemPdpExpand.setVisibility(View.GONE);
                itemView.setSelected(true);
            } else {
                ivItemPdpExpand.setVisibility(View.VISIBLE);
                ivItemPdpExpand.setSelected(expandTitleVM.isExpand());
                itemView.setSelected(expandTitleVM.isExpand());
                itemView.setOnClickListener(v -> {
                    expandTitleVM.setExpand(!expandTitleVM.isExpand());
                    ivItemPdpExpand.setSelected(expandTitleVM.isExpand());
                    itemView.setSelected(expandTitleVM.isExpand());
                });
            }
        }
    }
}
