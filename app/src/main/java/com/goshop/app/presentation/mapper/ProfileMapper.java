package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.ProfileResponse;
import com.goshop.app.presentation.model.ProfileVM;

public class ProfileMapper {

    public static ProfileVM transform(ProfileResponse response) {
        ProfileVM profileVM = new ProfileVM();
        profileVM.setEmail(response.getData().getCustomer().getEmail());
        profileVM.setFirstName(response.getData().getCustomer().getName());
        //todo need decide
        profileVM.setLastName(response.getData().getCustomer().getName());
//        profileVM.setGender();
        profileVM.setBirth(response.getData().getCustomer().getDob());
//        profileVM.setTitle();
        profileVM.setMobile(response.getData().getCustomer().getMobile_number());
//        profileVM.setLanguage();
//        profileVM.setRace();
        return profileVM;
    }

}
