package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.adapter.HomeBaseAdapter;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.utils.ServiceData;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;

public class MainHomeActivity extends BaseActivity {

    @BindView(R.id.rv_home)
    RecyclerView rvHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar();
        initRecycler();

    }

    private void initToolBar() {
        getToolbar().setBackgroundColor(getResources().getColor(R.color.colorAccent));

    }

    private void initRecycler() {
        HomeBaseAdapter homeBaseAdapter = new HomeBaseAdapter(ServiceData.getBaseData());
        rvHome.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvHome.setAdapter(homeBaseAdapter);
    }

    @Override
    public int getContentView() {
        return R.layout.layout_home;
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    @Override
    public void inject() {

    }


}
