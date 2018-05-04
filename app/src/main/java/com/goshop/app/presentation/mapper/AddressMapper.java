package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.AddressResponse;
import com.goshop.app.data.model.response.CityResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.StatesResponse;
import com.goshop.app.data.model.response.ZipCodeResponse;
import com.goshop.app.data.model.response.common.AddressesData;
import com.goshop.app.data.model.response.common.CityData;
import com.goshop.app.data.model.response.common.StatesData;
import com.goshop.app.presentation.model.AddressVM;
import com.goshop.app.presentation.model.ProfileMetaVM;
import com.goshop.app.utils.NumberFormater;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddressMapper {

    private static final String COMMA = ", ";

    public static List<AddressVM> transform(Response<AddressResponse> response) {
        List<AddressVM> addressVMS = new ArrayList<>();
        List<AddressesData> addressesDatas = response.getData()
            .getCustomer().getAddresses();

        AddressVM addressVM;
        for (AddressesData addressesData : addressesDatas) {
            addressVM = new AddressVM();
            addressVM.setName(addressesData.getFirstName());
            Map<String, Object> street = addressesData.getStreet();
            String address = "";
            for (Map.Entry<String, Object> entry : street.entrySet()) {
                if (TextUtils.isEmpty(address)) {
                    address = (String) entry.getValue();
                } else {
                    address = address + COMMA + (String) entry.getValue();
                }
            }
            addressVM.setAddress(address);
            addressVM.setCountry(addressesData.getCountryId());
            addressVM.setId(addressesData.getId());
            addressVM.setCity(addressesData.getCity());
            addressVM.setCode(addressesData.getPostCode());
            addressVM.setState(addressesData.getRegionId());
            addressVM.setTel(NumberFormater.formaterTelNo(addressesData.getTelephone()));
            addressVM.setShippingDefault(addressesData.isDefaultShipping());
            addressVM.setBillingDefault(addressesData.isDefaultBilling());
            addressVMS.add(addressVM);
        }

        return addressVMS;
    }

    public static List<ProfileMetaVM> transformStates(Response<StatesResponse> response) {
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        for (StatesData statesData : response.getData().getStates()) {
            profileMetaVMS.add(new ProfileMetaVM(statesData.getId(), statesData.getName()));
        }
        return profileMetaVMS;
    }

    public static List<ProfileMetaVM> transformZipCode(Response<ZipCodeResponse> response) {
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        for (String zipCode : response.getData().getZipcode()) {
            profileMetaVMS.add(new ProfileMetaVM(zipCode));
        }
        return profileMetaVMS;
    }

    public static List<ProfileMetaVM> transformCitys(Response<CityResponse> response) {
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        for (CityData cityData : response.getData().getCity()) {
            profileMetaVMS.add(new ProfileMetaVM(cityData.getCode(), cityData.getName()));
        }
        return profileMetaVMS;
    }
}
