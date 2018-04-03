package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.AddressResponse;
import com.goshop.app.presentation.model.AddressVM;
import com.goshop.app.utils.NumberFormater;

import java.util.ArrayList;
import java.util.List;

public class AddressMapper {

    public static List<AddressVM> transform(AddressResponse response) {
        List<AddressVM> addressVMS = new ArrayList<>();
        List<AddressResponse.Datas.CustomerData.AddressesData> addressesDatas = response.getData()
            .getCustomer().getAddresses();

        AddressVM addressVM;
        for (AddressResponse.Datas.CustomerData.AddressesData addressesData : addressesDatas) {
            addressVM = new AddressVM();
            addressVM.setName(addressesData.getName());
            addressVM.setAddress(addressesData.getAddress1());
            addressVM.setAddressSecond(addressesData.getAddress2());
            addressVM.setCountry(addressesData.getCountry());
            //todo all "" need decide when api ensure
            addressVM.setId("" + addressesData.getId());
            addressVM.setState("" + addressesData.getState());
            addressVM.setCity("" + addressesData.getCity());
            addressVM.setCode("" + addressesData.getZipcode());
            addressVM.setTel(NumberFormater.formaterTelNo(addressesData.getPhone_number()));
            addressVM.setShippingDefault(addressesData.isDefault_shipping_address());
            addressVM.setBillingDefault(addressesData.isDefault_billing_address());
            addressVMS.add(addressVM);
        }

        return addressVMS;
    }

}
