package com.goshop.app.adapter;

import com.goshop.app.R;
import com.goshop.app.data.model.response.MyOrderDetailReponse;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by img on 2018/1/31.
 */

public class MyOrderDetailAdapter extends RecyclerView.Adapter {

    List<MyOrderDetailReponse.SubordersBean> subordersBeans = new ArrayList<>();

    public MyOrderDetailAdapter(
        List<MyOrderDetailReponse.SubordersBean> subordersBeans) {
        this.subordersBeans = subordersBeans;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_order_list_content, parent, false);
        return new MyOrderListAdapter.BodyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        MyOrderListAdapter.BodyHolder holder = (MyOrderListAdapter.BodyHolder) viewHolder;
        holder.bindingDetail(holder, subordersBeans.get(position));
    }

    @Override
    public int getItemCount() {
        return subordersBeans.size();
    }


}
