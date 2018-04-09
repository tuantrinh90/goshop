package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.MyPointsResponse;
import com.goshop.app.data.model.response.common.TransactionsData;
import com.goshop.app.presentation.model.PointsDetailVM;
import com.goshop.app.presentation.model.PointsModel;
import com.goshop.app.presentation.model.PointsTotalVM;
import com.goshop.app.utils.NumberFormater;

import java.util.ArrayList;
import java.util.List;

public class GoShopPointsMapper {

    public static List<PointsModel> transform(MyPointsResponse response) {

        List<PointsModel> pointsModels = new ArrayList<>();
        pointsModels.add(new PointsTotalVM(response.getData().getGoshop_points().getTotal()));

        List<TransactionsData> transactions = response
            .getData().getGoshop_points().getTransactions();
        List<PointsDetailVM> detailVMS = new ArrayList<>();

        if (transactions.size() > 0) {
            pointsModels.add(new PointsModel(PointsModel.VIEW_TYPE_TRANSACTIONS_TITLE));
            PointsDetailVM detailVM;
            for (TransactionsData transactionsData :
                transactions) {
                detailVM = new PointsDetailVM(transactionsData.getDetail(),
                    NumberFormater
                        .formaterPoints(Integer.parseInt(transactionsData.getPoints()),
                            transactionsData.getType()),
                    transactionsData.getType(),
                    transactionsData.getValidUntil(),
                    NumberFormater.formaterPointOrderNo(transactionsData.getOrderNumber()),
                    transactionsData.getDate());
                detailVMS.add(detailVM);
            }
            pointsModels.addAll(detailVMS);
        } else {
            pointsModels.add(new PointsModel(PointsModel.VIEW_TYPE_TRANSACTIONS_NODATA));
        }
        return pointsModels;
    }

}
