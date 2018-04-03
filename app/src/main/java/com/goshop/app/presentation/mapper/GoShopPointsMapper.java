package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.MyPointsResponse;
import com.goshop.app.presentation.model.PointsDetailVM;
import com.goshop.app.presentation.model.PointsModel;
import com.goshop.app.presentation.model.PointsTotalVM;
import com.goshop.app.utils.NumberFormater;

import java.util.ArrayList;
import java.util.List;

public class GoShopPointsMapper {

    public static List<PointsModel> transform(MyPointsResponse response) {
        List<PointsModel> pointsModels = new ArrayList<>();
        List<MyPointsResponse.Datas.GoShopPointsData> goShopPointsDatas = response.getData()
            .getGoShopPoints();
        List<PointsDetailVM> detailVMS = new ArrayList<>();
        PointsDetailVM detailVM;
        int total = 0;
        for (MyPointsResponse.Datas.GoShopPointsData goShopPointsData : goShopPointsDatas) {
            detailVM = new PointsDetailVM(goShopPointsData.getDetail(),
                NumberFormater
                    .formaterPoints(goShopPointsData.getPoints(), goShopPointsData.getType()),
                goShopPointsData.getType(),
                goShopPointsData.getValidUntil(),
                NumberFormater.formaterPointOrderNo(goShopPointsData.getOrderNo()));
            detailVMS.add(detailVM);
            total = goShopPointsData.getType() == 1 ? total + goShopPointsData
                .getPoints() : total - goShopPointsData.getPoints();
        }
        pointsModels.add(new PointsTotalVM(String.valueOf(total)));
        pointsModels.add(new PointsModel(PointsModel.VIEW_TYPE_TRANSACTIONS_TITLE));
        pointsModels.addAll(detailVMS);
        return pointsModels;
    }

}
