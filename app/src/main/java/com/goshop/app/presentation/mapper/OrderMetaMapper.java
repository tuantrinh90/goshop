package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.OrderMetadataResponse;
import com.goshop.app.data.model.response.common.ReasonData;
import com.goshop.app.presentation.model.ProfileMetaVM;

import java.util.ArrayList;
import java.util.List;

public class OrderMetaMapper {

    public static List<ProfileMetaVM> transformReturnReason(OrderMetadataResponse response) {
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        List<ReasonData> reasons = response.getReturnX().getReason();
        for (ReasonData reasonData : reasons) {
            profileMetaVMS.add(new ProfileMetaVM(reasonData.getId(), reasonData.getValue()));
        }
        return profileMetaVMS;
    }

    public static List<ProfileMetaVM> transformCancelReason(OrderMetadataResponse response) {
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        List<ReasonData> reasons = response.getCancel().getReason();
        for (ReasonData reasonData : reasons) {
            profileMetaVMS.add(new ProfileMetaVM(reasonData.getId(), reasonData.getValue()));
        }
        return profileMetaVMS;
    }

}
