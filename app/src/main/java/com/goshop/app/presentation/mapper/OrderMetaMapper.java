package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.OrderMetadataResponse;
import com.goshop.app.data.model.response.common.OrderCancelData;
import com.goshop.app.data.model.response.common.OrderReturnData;
import com.goshop.app.data.model.response.common.ProductResolutionData;
import com.goshop.app.data.model.response.common.ReasonData;
import com.goshop.app.presentation.model.ProfileMetaVM;

import java.util.ArrayList;
import java.util.List;

public class OrderMetaMapper {

    public static List<ProfileMetaVM> transformReturnReason(OrderMetadataResponse response) {
        OrderReturnData orderReturnData = response.getOrder().getReturnX();
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        List<ReasonData> reasons = orderReturnData.getReason();
        for (ReasonData reasonData : reasons) {
            profileMetaVMS.add(new ProfileMetaVM(reasonData.getId(), reasonData.getValue()));
        }
        return profileMetaVMS;
    }

    public static List<ProfileMetaVM> transformReturnProductResolution(
        OrderMetadataResponse response) {
        OrderReturnData orderReturnData = response.getOrder().getReturnX();
        List<ProductResolutionData> productResolutions = orderReturnData.getProductResolution();
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        for (ProductResolutionData resolutionData : productResolutions) {
            profileMetaVMS.add(new ProfileMetaVM(resolutionData.getId(), resolutionData.getValue()));
        }
        return profileMetaVMS;
    }

    public static List<ProfileMetaVM> transformCancelReason(OrderMetadataResponse response) {
        OrderCancelData orderCancelData = response.getOrder().getCancel();
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        List<ReasonData> reasons = orderCancelData.getReason();
        for (ReasonData reasonData : reasons) {
            profileMetaVMS.add(new ProfileMetaVM(reasonData.getId(), reasonData.getValue()));
        }
        return profileMetaVMS;
    }

    public static List<ProfileMetaVM> transformCancelProductResolution(
        OrderMetadataResponse response) {
        OrderCancelData orderCancelData = response.getOrder().getCancel();
        List<ProductResolutionData> productResolutions = orderCancelData.getProductResolution();
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        for (ProductResolutionData resolutionData : productResolutions) {
            profileMetaVMS.add(new ProfileMetaVM(resolutionData.getId(), resolutionData.getValue()));
        }
        return profileMetaVMS;
    }

}
