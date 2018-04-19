package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.AddressResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.common.AddressesData;
import com.goshop.app.presentation.model.AddressVM;
import com.goshop.app.utils.NumberFormater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddressMapper {

    public static List<AddressVM> transform(Response<AddressResponse> response) {
        List<AddressVM> addressVMS = new ArrayList<>();
        List<AddressesData> addressesDatas = response.getData()
            .getCustomer().getAddresses();

        AddressVM addressVM;
        for (AddressesData addressesData : addressesDatas) {
            addressVM = new AddressVM();
            addressVM.setName(addressesData.getFirstName());
            Map<String, Object> street = addressesData.getStreet();
            for (Map.Entry<String, Object> entry : street.entrySet()) {
                addressVM.setAddress((String) entry.getValue());
            }
            addressVM.setCountry(addressesData.getCountryId());
            //todo all "" need decide when api ensure
            addressVM.setId("" + addressesData.getId());
            addressVM.setCity("" + addressesData.getCity());
            addressVM.setCode("" + addressesData.getPostCode());
            addressVM.setTel(NumberFormater.formaterTelNo(addressesData.getTelephone()));
            addressVM.setShippingDefault(addressesData.isDefaultShipping());
            addressVM.setBillingDefault(addressesData.isDefaultBilling());
            addressVMS.add(addressVM);
        }

        return addressVMS;
    }

}
