package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.MyPointsResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.common.TransactionsData;
import com.goshop.app.presentation.model.PointsDetailVM;
import com.goshop.app.presentation.model.PointsModel;
import com.goshop.app.presentation.model.PointsTotalVM;
import com.goshop.app.utils.DateFormater;
import com.goshop.app.utils.NumberFormater;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class GoShopPointsMapper {

    public static List<PointsModel> transform(Response<MyPointsResponse> response, int page) {

        List<PointsModel> pointsModels = new ArrayList<>();

        if (page == 1)
            pointsModels.add(new PointsTotalVM(response.getData().getGoshopPoints().getTotal()));

        List<TransactionsData> transactions = response
            .getData().getGoshopPoints().getTransactions();
        List<PointsDetailVM> detailVMS = new ArrayList<>();
        if (transactions.size() > 0) {
            if (page == 1)
                pointsModels.add(new PointsModel(PointsModel.VIEW_TYPE_TRANSACTIONS_TITLE));
            PointsDetailVM detailVM;
            for (TransactionsData transactionsData :
                transactions) {
                detailVM = new PointsDetailVM(transactionsData.getDetail(),
                    NumberFormater
                        .formaterPoints(transactionsData.getPoints(),
                            transactionsData.getType()),
                    transactionsData.getType(),
                    transactionsData.getValidUntil(),
                    NumberFormater.formaterPointOrderNo(transactionsData.getOrderNumber()),
                    DateFormater.formaterISODateLower(transactionsData.getDate()));
                detailVMS.add(detailVM);
            }
            pointsModels.addAll(detailVMS);
        } else {
            pointsModels.add(new PointsModel(PointsModel.VIEW_TYPE_TRANSACTIONS_NODATA));
        }
        return pointsModels;
    }

}
