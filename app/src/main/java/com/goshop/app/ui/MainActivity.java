package com.goshop.app.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.goshop.app.R;
import com.goshop.app.adapter.HomeBaseAdapter;
import com.goshop.app.utils.JToolUtils;
import com.goshop.app.utils.ServiceData;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_home)
    RecyclerView rvHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);
        ButterKnife.bind(this);
        HomeBaseAdapter homeBaseAdapter=new HomeBaseAdapter(ServiceData.getBaseData());
        JToolUtils.printObject(ServiceData.getBaseData());
        rvHome.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvHome.setAdapter(homeBaseAdapter);
    }


}
