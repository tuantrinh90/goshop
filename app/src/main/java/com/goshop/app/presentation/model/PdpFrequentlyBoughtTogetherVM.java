package com.goshop.app.presentation.model;

import java.util.List;

/**
 * Created by helen on 2018/1/12.
 */

public class PdpFrequentlyBoughtTogetherVM extends ProductDetailModel {

    List<PdpFrequentlyDataVM> dataVMS;

    public PdpFrequentlyBoughtTogetherVM(
        List<PdpFrequentlyDataVM> dataVMS) {
        super(ProductDetailModel.DETAIL_FREQUENTLY_BOUGHT_TOGETHER);
        this.dataVMS = dataVMS;
    }

    public PdpFrequentlyBoughtTogetherVM() {
        super(ProductDetailModel.DETAIL_FREQUENTLY_BOUGHT_TOGETHER);
    }

    public List<PdpFrequentlyDataVM> getDataVMS() {
        return dataVMS;
    }

    public void setDataVMS(List<PdpFrequentlyDataVM> dataVMS) {
        this.dataVMS = dataVMS;
    }
}
