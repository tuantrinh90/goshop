package com.goshop.app.presentation.myorder;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.adapter.MyOrderListAdapter;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.data.model.response.MyOrderDetailReponse;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.utils.JToolUtils;
import com.goshop.app.utils.ScreenHelper;
import com.goshop.app.utils.ViewUtils;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class MyOrderListActivity extends BaseActivity<MyOrderContract.Presenter> implements
    MyOrderContract.View, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.imageview_left_menu)
    ImageView imageviewLeftMenu;

    @BindView(R.id.rv_order_list)
    RecyclerView rvOrderList;

    @BindView(R.id.swipe_layout_myorder_list)
    SwipeRefreshLayout swipeLayoutMyorderList;

    private boolean isFront;

    @Override
    public void showOrderList(MyOrderListResponse response) {
        JToolUtils.printObject(response);
        initRecycler(response);
    }

    @Override
    public void showNetwordErrorMessage() {
        Toast.makeText(this, R.string.app_network_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFaildMessage(String errorMessage) {
        Toast.makeText(this, R.string.app_network_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSwipeLayout() {
        if (swipeLayoutMyorderList != null) {
            swipeLayoutMyorderList.setRefreshing(true);
        }
    }

    @Override
    public void closeSwipeLayout() {
        if (swipeLayoutMyorderList != null) {
            swipeLayoutMyorderList.setRefreshing(false);
        }
    }

    @Override
    public void showOrderDetail(MyOrderDetailReponse reponse) {
        //TODO joyson this is empty response ,no need write code
    }

    private void initRecycler(MyOrderListResponse response) {
        List<MyOrderListResponse.ResultsBean> results = response.getResults();
        rvOrderList.setLayoutManager(new LinearLayoutManager(this));
        rvOrderList.setAdapter(new MyOrderListAdapter(results));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getOrderList(new HashMap<>());
        ViewUtils.setBg(imageviewLeftMenu, R.drawable.ic_icon_back);
        swipeLayoutMyorderList.setOnRefreshListener(this);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_myorder_list;
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public String getScreenTitle() {
        return ScreenHelper.getString(R.string.my_orders_title);
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
    }

    @OnClick({R.id.imageview_left_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }

    @Override
    public void onRefresh() {
        if (isFront) {
            mPresenter.getOrderList(new HashMap<>());
        }
    }
}
