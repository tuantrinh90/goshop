package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.ProfileResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.presentation.model.ProfileVM;
import com.goshop.app.utils.DateFormater;

public class ProfileMapper {

    public static ProfileVM transform(Response<ProfileResponse> response) {
        ProfileVM profileVM = new ProfileVM();
        profileVM.setEmail(response.getData().getCustomer().getEmail());
        profileVM.setName(response.getData().getCustomer().getName());
        profileVM.setBirth(DateFormater.getAbbreviationDate(response.getData().getCustomer().getDob()));
        profileVM.setMobile(response.getData().getCustomer().getMobileNumber());
        return profileVM;
    }

}
