package com.goshop.app.presentation.search;

import com.goshop.app.base.RxPresenter;

/**
 * Created by helen on 2018/1/18.
 */

public class SearchPresenter extends RxPresenter<SearchContract.View> implements SearchContract
    .Presenter {

    @Override
    public void searchFilter(String keyWords) {
//        List<BcaRecipientVM> filterData = new ArrayList<>();
//        for (BcaRecipientVM bcaRecipientVM : bcaRecipientCache) {
//            if (bcaRecipientVM.getAccountName().toLowerCase()
//                .contains(keyword.toLowerCase()) || bcaRecipientVM
//                .getAccountNumber().toLowerCase().contains(keyword.toLowerCase())) {
//                filterData.add(bcaRecipientVM);
//            }
//        }

//        if (filterData.isEmpty()) {
//            mView.showNoDataLayout();
//        } else {
//            mView.hideNoDataLayout();
//            mView.showFilterResult("");
//        }
    }
}
