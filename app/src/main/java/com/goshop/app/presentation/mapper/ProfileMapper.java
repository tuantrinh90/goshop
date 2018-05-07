package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.LoginResponse;
import com.goshop.app.data.model.response.ProfileResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.common.LanguageData;
import com.goshop.app.data.model.response.common.RaceData;
import com.goshop.app.data.model.response.common.TokenData;
import com.goshop.app.data.model.response.common.UserData;
import com.goshop.app.presentation.model.LanguageVM;
import com.goshop.app.presentation.model.ProfileMetaVM;
import com.goshop.app.presentation.model.ProfileVM;
import com.goshop.app.presentation.model.RaceVM;
import com.goshop.app.presentation.model.TokenVM;
import com.goshop.app.presentation.model.UserDataVM;
import com.goshop.app.utils.DateFormater;

import java.util.ArrayList;
import java.util.List;

public class ProfileMapper {

    public static ProfileVM transform(Response<ProfileResponse> response) {
        ProfileVM profileVM = new ProfileVM();
        profileVM.setEmail(response.getData().getCustomer().getEmail());
        profileVM.setName(response.getData().getCustomer().getName());
        profileVM
            .setBirth(DateFormater.getAbbreviationDate(response.getData().getCustomer().getDob()));
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

    public static UserDataVM transformCustomer(UserData customer) {
        UserDataVM userDataVM = new UserDataVM();
        userDataVM.setAvailableGoshopPoints(customer.getAvailableGoshopPoints());
        userDataVM.setCartItemsCount(customer.getCartItemsCount());
        userDataVM.setWishlistTemsCount(customer.getWishlistTemsCount());
        userDataVM.setMaxFailedLogin(customer.getMaxFailedLogin());
        userDataVM.setDob(customer.getDob());
        userDataVM.setEmail(customer.getEmail());
        userDataVM.setId(customer.getId());
        userDataVM.setEmailSubscribe(customer.isEmailSubscribe());
        userDataVM.setSmsSubscribe(customer.isSmsSubscribe());
        userDataVM.setTitle(customer.getTitle());
        userDataVM.setMobileNumber(customer.getMobileNumber());
        userDataVM.setName(customer.getName());
        if (customer.getLanguage() != null) {
            LanguageVM languageVM = new LanguageVM();
            languageVM.setName(customer.getLanguage().getName());
            languageVM.setId(customer.getLanguage().getId());
            userDataVM.setLanguage(languageVM);
        }
        if (customer.getRace() != null) {
            RaceVM raceVM = new RaceVM();
            raceVM.setId(customer.getRace().getId());
            raceVM.setName(customer.getRace().getName());
            userDataVM.setRace(raceVM);
        }
        if (customer.getToken() != null) {
            TokenVM tokenVM = new TokenVM();
            tokenVM.setExpiration(customer.getToken().getExpiration());
            tokenVM.setToken(customer.getToken().getToken());
            userDataVM.setToken(tokenVM);

        }
        return userDataVM;
    }

    public static UserDataVM updateUserInfo(UserDataVM oldUserDataVM, UserDataVM newUserDataVM) {
        oldUserDataVM.setId(newUserDataVM.getId());
        oldUserDataVM.setName(newUserDataVM.getName());
        oldUserDataVM.setEmail(newUserDataVM.getEmail());
        oldUserDataVM.setMobileNumber(newUserDataVM.getMobileNumber());
        oldUserDataVM.setAvailableGoshopPoints(newUserDataVM.getAvailableGoshopPoints());
        oldUserDataVM.setCartItemsCount(newUserDataVM.getCartItemsCount());
        oldUserDataVM.setDob(newUserDataVM.getDob());
        oldUserDataVM.setEmailSubscribe(newUserDataVM.isEmailSubscribe());
        oldUserDataVM.setSmsSubscribe(newUserDataVM.isSmsSubscribe());
        oldUserDataVM.setMaxFailedLogin(newUserDataVM.getMaxFailedLogin());
        oldUserDataVM.setTitle(newUserDataVM.getTitle());
        oldUserDataVM.setWishlistTemsCount(newUserDataVM.getWishlistTemsCount());
        if (newUserDataVM.getLanguage() != null) {
            oldUserDataVM.getLanguage().setId(newUserDataVM.getLanguage().getId());
            oldUserDataVM.getLanguage().setName(newUserDataVM.getLanguage().getName());
        }
        if (newUserDataVM.getRace() != null) {
            oldUserDataVM.getRace().setId(newUserDataVM.getRace().getId());
            oldUserDataVM.getRace().setName(newUserDataVM.getRace().getName());
        }
        if (newUserDataVM.getToken() != null) {
            oldUserDataVM.getToken().setToken(newUserDataVM.getToken().getToken());
            oldUserDataVM.getToken().setExpiration(newUserDataVM.getToken().getExpiration());
        }
        return oldUserDataVM;
    }
}
