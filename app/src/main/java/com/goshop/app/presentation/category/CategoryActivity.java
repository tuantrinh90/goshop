package com.goshop.app.presentation.category;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.model.CategoryLeftMenuVM;
import com.goshop.app.presentation.model.CategoryRightChildVM;
import com.goshop.app.presentation.model.CategoryRightMenuModel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class CategoryActivity extends BaseActivity<CategoryContract.Presenter> implements
    CategoryContract.View, CategoryLeftAdapter.CategoryLeftClickListener, CategoryRightAdapter
    .OnChildItemClickListener {

    @BindView(R.id.recycleview_category_left)
    RecyclerView recycleviewCategoryLeft;

    @BindView(R.id.recycleview_category_right)
    RecyclerView recycleviewCategoryRight;

    private CategoryLeftAdapter leftAdapter;

    private CategoryRightAdapter rightAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getCategoryLeftMenu();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_category;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initPresenter();
        initRecycleview();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.category);
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecycleview() {
        LinearLayoutManager leftManager = new LinearLayoutManager(this);
        leftManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleviewCategoryLeft.setLayoutManager(leftManager);
        leftAdapter = new CategoryLeftAdapter(new ArrayList<>(), this);
        recycleviewCategoryLeft.setAdapter(leftAdapter);
        LinearLayoutManager rightManager = new LinearLayoutManager(this);
        rightManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleviewCategoryRight.setLayoutManager(rightManager);
        rightAdapter = new CategoryRightAdapter(new ArrayList<>(), this);
        recycleviewCategoryRight.setAdapter(rightAdapter);
    }

    @Override
    public void showLeftMenu(List<CategoryLeftMenuVM> leftMenuVMS) {
        leftAdapter.setUpdateLeftCategorys(leftMenuVMS);
        if (leftMenuVMS.size() > 0) {
            leftAdapter.selectPosition(0);
            //TODO(helen) wait for api
            mPresenter.categoryRightMenuRequest(null);
        }
    }

    @Override
    public void showRightMenu(List<CategoryRightMenuModel> rightMenuModels) {
        rightAdapter.setUpdateRightModels(rightMenuModels);
        recycleviewCategoryRight.smoothScrollToPosition(0);
    }

    @Override
    public void onLeftClick(CategoryLeftMenuVM leftMenuVM) {
        //TODO(helen) wait for api
        mPresenter.categoryRightMenuRequest(null);
    }

    @OnClick({R.id.imageview_left_menu})
    public void onCategoryClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }

    @Override
    public void onChildItemClick(CategoryRightChildVM childVM) {
        Intent intent = new Intent(this, CategoryTreeDetailActivity.class);
        intent.putExtra(CategoryTreeDetailActivity.CATEGORY_DETAIL_TITLE, childVM.getTitle());
        startActivity(intent);
    }
}
