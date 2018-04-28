package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.ProfileMetadataResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.presentation.model.ProfileMetaVM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ProfileMetaMapper {

    public static List<ProfileMetaVM> transformGender(Response<ProfileMetadataResponse> response) {
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        Map<String, String> gender = response.getData().getCustomer().getGender();
        for (Map.Entry<String, String> entry : gender.entrySet()) {
            profileMetaVMS.add(new ProfileMetaVM(entry.getKey(), entry.getValue()));
        }
        return profileMetaVMS;
    }

    public static List<ProfileMetaVM> transformLanguage(
        Response<ProfileMetadataResponse> response) {
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        Map<String, String> language = response.getData().getCustomer().getLanguage();
        for (Map.Entry<String, String> entry : language.entrySet()) {
            profileMetaVMS.add(new ProfileMetaVM(entry.getKey(), entry.getValue()));
        }
        return profileMetaVMS;
    }

    public static List<ProfileMetaVM> transformRace(Response<ProfileMetadataResponse> response) {
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        Map<String, String> race = response.getData().getCustomer().getRace();
        for (Map.Entry<String, String> entry : race.entrySet()) {
            profileMetaVMS.add(new ProfileMetaVM(entry.getKey(), entry.getValue()));
        }
        return profileMetaVMS;
    }

}
