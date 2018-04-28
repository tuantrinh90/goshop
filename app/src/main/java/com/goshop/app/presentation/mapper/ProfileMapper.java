package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.ProfileResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.common.LanguageData;
import com.goshop.app.data.model.response.common.RaceData;
import com.goshop.app.presentation.model.ProfileMetaVM;
import com.goshop.app.presentation.model.ProfileVM;
import com.goshop.app.utils.DateFormater;

import java.util.ArrayList;
import java.util.List;

public class ProfileMapper {

    public static ProfileVM transform(Response<ProfileResponse> response) {
        ProfileVM profileVM = new ProfileVM();
        profileVM.setEmail(response.getData().getCustomer().getEmail());
        profileVM.setName(response.getData().getCustomer().getName());
        profileVM.setBirth(DateFormater.getAbbreviationDate(response.getData().getCustomer().getDob()));
        profileVM.setMobile(response.getData().getCustomer().getMobileNumber());
        profileVM.setCartCount(response.getData().getCustomer().getCartItemsCount());

        List<ProfileMetaVM> languages = new ArrayList<>();
        LanguageData languageData = response.getData().getCustomer().getLanguage();
        languages.add(new ProfileMetaVM(languageData.getId() + "", languageData.getName()));
        profileVM.setLanguage(languages);

        List<ProfileMetaVM> races = new ArrayList<>();
        RaceData raceData = response.getData().getCustomer().getRace();
        races.add(new ProfileMetaVM(raceData.getId() + "", raceData.getName()));
        profileVM.setRace(races);

        List<ProfileMetaVM> titles = new ArrayList<>();
        String titleData = response.getData().getCustomer().getTitle();
        titles.add(new ProfileMetaVM(titleData, titleData));
        profileVM.setTitle(titles);

        return profileVM;
    }

}
