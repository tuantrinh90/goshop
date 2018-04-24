package com.goshop.app.presentation.category;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.common.view.expandablerecyclerview.bean.GroupItem;
import com.goshop.app.common.view.expandablerecyclerview.bean.RecyclerViewData;
import com.goshop.app.common.view.expandablerecyclerview.listener.OnRecyclerViewListener;
import com.goshop.app.presentation.model.CategoriesChildVM;
import com.goshop.app.presentation.model.CategoriesParentVM;
import com.goshop.app.presentation.model.CategoryRightChildVM;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.widget.listener.OnCategoryItemClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class CategoryActivity extends BaseDrawerActivity<CategoryContract.Presenter> implements
    CategoryContract.View, OnCategoryItemClickListener, OnRecyclerViewListener
    .OnItemClickListener {

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.recycleview_category_left)
    RecyclerView recycleviewCategoryLeft;

    @BindView(R.id.recycleview_category_right)
    RecyclerView recycleviewCategoryRight;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private CategoryLeftAdapter leftAdapter;

    private CategoryChildAdapter categoryChildAdapter;

    private List<CategoriesParentVM> categoryResponse;

    private List<RecyclerViewData> categoryChildList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentMenuType(MenuUtil.MENU_TYPE_CATEGORY);
        setContentView(getContentView());
        initToolbar();
        initRecyclerView();
        mPresenter.getCategory();
    }

    private void initToolbar() {
        hideRightMenu();
        imageViewLeftMenu.setImageResource(R.drawable.ic_menu);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_category;
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerView() {
        categoryChildList = new ArrayList<>();
        categoryResponse = new ArrayList<>();
        categoryChildAdapter = new CategoryChildAdapter(this, categoryChildList);
        categoryChildAdapter.setOnItemClickListener(this);
        recycleviewCategoryLeft.setLayoutManager(new LinearLayoutManager(this));
        leftAdapter = new CategoryLeftAdapter(categoryResponse, this);
        recycleviewCategoryLeft.setAdapter(leftAdapter);
        recycleviewCategoryRight.setLayoutManager(new LinearLayoutManager(this));
        recycleviewCategoryRight.setAdapter(categoryChildAdapter);
    }

    @Override
    public void onCategoryRequestSuccess(List<CategoriesParentVM> categoryResponse) {
        this.categoryResponse.addAll(categoryResponse);
        if (this.categoryResponse.size() > 0) {
            leftAdapter.selectPosition(0);
        }

        if (categoryResponse.get(0) != null && categoryResponse.get(0)
            .getChild() != null && categoryResponse.get(0).getChild().size() > 0) {
            updateChildList(categoryResponse.get(0));
        }
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.category);
    }

    @Override
    public void showServiceErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(recycleviewCategoryLeft, errorMessage);
    }

    @Override
    public void showNetworkErrorMessage(String message) {
        PopWindowUtil.showRequestMessagePop(recycleviewCategoryLeft, message);
    }

    @Override
    public void onLeftClick(CategoriesParentVM leftMenuVM) {
        updateChildList(leftMenuVM);
    }

    private void updateChildList(CategoriesParentVM leftMenuVM) {
        categoryChildList.clear();
        if (!leftMenuVM.getChild().isEmpty()) {
            for (int i = 0; i < leftMenuVM.getChild().size(); i++) {
                if (i == 0) {
                    categoryChildList
                        .add(new RecyclerViewData(leftMenuVM.getChild().get(i).getName(),
                            leftMenuVM.getChild().get(i).getChild(), true));
                } else {
                    categoryChildList
                        .add(new RecyclerViewData(leftMenuVM.getChild().get(i).getName(),
                            leftMenuVM.getChild().get(i).getChild(), false));
                }
            }
        }
        categoryChildAdapter.notifyRecyclerViewData();
    }

    @OnClick({R.id.imageview_left_menu})
    public void onCategoryClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                openDrawerLayout();
                break;
        }
    }

    @Override
    public void onChildItemClick(CategoryRightChildVM childVM) {
        Intent intent = new Intent(this, CategoryTreeDetailActivity.class);
        intent.putExtra(CategoryTreeDetailActivity.CATEGORY_DETAIL_TITLE, childVM.getTitle());
        startActivity(intent);
    }

    @Override
    public void onGroupItemClick(int position, int groupPosition, View view, GroupItem item) {
        view.findViewById(R.id.iv_item_category_expand).setSelected(item.isExpand());
    }

    @Override
    public void onChildItemClick(int position, int groupPosition, int childPosition, View view,
        Object item) {
        if (item instanceof CategoriesChildVM) {
            CategoriesChildVM categoriesChildVM = ((CategoriesChildVM) item);
            Intent intent = new Intent(this, CategoryTreeDetailActivity.class);
            intent.putExtra(CategoryTreeDetailActivity.CATEGORY_DETAIL_TITLE,
                categoriesChildVM.getName());
            startActivity(intent);
        }

    }
}
