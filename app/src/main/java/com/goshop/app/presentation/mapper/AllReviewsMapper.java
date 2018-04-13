package com.goshop.app.presentation.mapper;

import com.goshop.app.R;
import com.goshop.app.data.model.response.AllReviewsResponse;
import com.goshop.app.data.model.response.common.ReviewsData;
import com.goshop.app.presentation.model.AllReviewsVM;
import com.goshop.app.presentation.model.widget.ReviewsVM;
import com.goshop.app.utils.DateFormater;

import java.util.ArrayList;
import java.util.List;

public class AllReviewsMapper {

    private static final String AMOUNT_END = " Reviews";

    public static AllReviewsVM transform(AllReviewsResponse response) {
        String amount = response.getTotalReviews() + AMOUNT_END;
        float step = response.getTotalRating();
        String thumb = response.getImage();
        List<ReviewsVM> reviewsVMS = new ArrayList<>();
        List<ReviewsData> reviewsDatas = response.getReviews();
        for(ReviewsData data: reviewsDatas) {
            reviewsVMS.add(
                new ReviewsVM(data.getRating(), data.getTitle(),
                data.getDescription(), data.getName(),
                DateFormater.formaterDDMMYY(data.getDate()))
            );
        }
        return new AllReviewsVM(thumb, R.drawable.ic_bought, step, amount, reviewsVMS);
    }
}
