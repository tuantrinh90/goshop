package com.goshop.app.presentation.category;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.CategoryMenuResponse;
import com.goshop.app.domian.ProductRepository;
import com.goshop.app.presentation.model.CategoryLeftMenuVM;
import com.goshop.app.presentation.model.CategoryRightChildVM;
import com.goshop.app.presentation.model.CategoryRightMenuModel;
import com.goshop.app.presentation.model.CategoryRightParentVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class CategoryPresenter extends RxPresenter<CategoryContract.View> implements
    CategoryContract.Presenter {

    private ProductRepository repository;

    public CategoryPresenter(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getCategoryLeftMenu() {

        mView.showLoadingBar();
        addSubscrebe(repository.getCategoryLeftMenu().subscribeWith(
            new DisposableObserver<CategoryMenuResponse>() {
                @Override
                public void onNext(CategoryMenuResponse categoryMenuResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.showLeftMenu(getMockLeftMenu());
                }

                @Override
                public void onComplete() {

                }
            }));

    }

    @Override
    public void categoryRightMenuRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(repository.categoryRightMenuRequest(params).subscribeWith(
            new DisposableObserver<CategoryMenuResponse>() {
                @Override
                public void onNext(CategoryMenuResponse categoryMenuResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.showRightMenu(getMockRightMenu());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //TODO this is mock data
    private List<CategoryRightMenuModel> getMockRightMenu() {
        List<CategoryRightMenuModel> rightMenuModels = new ArrayList<>();
        rightMenuModels.add(new CategoryRightParentVM("Beauty 1"));
        rightMenuModels.add(new CategoryRightChildVM("All"));
        rightMenuModels.add(new CategoryRightChildVM("Beauty 11"));
        rightMenuModels.add(new CategoryRightChildVM("Beauty 12"));
        rightMenuModels.add(new CategoryRightParentVM("Beauty 2"));
        rightMenuModels.add(new CategoryRightChildVM("All"));
        rightMenuModels.add(new CategoryRightChildVM("Beauty 21"));
        rightMenuModels.add(new CategoryRightChildVM("Beauty 22"));
        rightMenuModels.add(new CategoryRightParentVM("Beauty 3"));
        rightMenuModels.add(new CategoryRightChildVM("All"));
        rightMenuModels.add(new CategoryRightChildVM("Beauty 31"));
        rightMenuModels.add(new CategoryRightChildVM("Beauty 32"));
        rightMenuModels.add(new CategoryRightParentVM("Beauty 4"));
        rightMenuModels.add(new CategoryRightChildVM("All"));
        rightMenuModels.add(new CategoryRightChildVM("Beauty 41"));
        rightMenuModels.add(new CategoryRightChildVM("Beauty 42"));
        rightMenuModels.add(new CategoryRightParentVM("Beauty 5"));
        rightMenuModels.add(new CategoryRightChildVM("All"));
        rightMenuModels.add(new CategoryRightChildVM("Beauty 51"));
        rightMenuModels.add(new CategoryRightChildVM("Beauty 52"));
        rightMenuModels.add(new CategoryRightParentVM("Beauty 6"));
        rightMenuModels.add(new CategoryRightChildVM("All"));
        rightMenuModels.add(new CategoryRightChildVM("Beauty 61"));
        rightMenuModels.add(new CategoryRightChildVM("Beauty 62"));
        rightMenuModels.add(new CategoryRightParentVM("Beauty 6"));

        return rightMenuModels;
    }

    //TODO this is mock data
    private List<CategoryLeftMenuVM> getMockLeftMenu() {
        List<CategoryLeftMenuVM> leftMenuVMS = new ArrayList<>();
        leftMenuVMS.add(new CategoryLeftMenuVM(R.drawable.ic_icon_beauty, "", "Beauty"));
        leftMenuVMS.add(new CategoryLeftMenuVM(R.drawable.ic_icon_digital, "", "Digital Electronics"));
        leftMenuVMS.add(new CategoryLeftMenuVM(R.drawable.ic_icon_appliances, "", "Home Appliances"));
        leftMenuVMS.add(new CategoryLeftMenuVM(R.drawable.ic_icon_mom_baby, "", "Mom and Babies"));
        leftMenuVMS.add(new CategoryLeftMenuVM(R.drawable.ic_icon_sports, "", "Sports and Leisure"));
        leftMenuVMS.add(new CategoryLeftMenuVM(R.drawable.ic_icon_diy, "", "DIY Tools"));
        leftMenuVMS.add(new CategoryLeftMenuVM(R.drawable.ic_icon_spa, "", "Spa and Wellbeing"));
        leftMenuVMS.add(new CategoryLeftMenuVM(R.drawable.ic_icon_grocery, "", "Grocery"));
        return leftMenuVMS;
    }
}
