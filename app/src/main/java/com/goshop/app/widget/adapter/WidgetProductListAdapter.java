//package com.goshop.app.widget.adapter;
//
//import com.goshop.app.R;
//import com.goshop.app.presentation.model.widget.ProductListModel;
//import com.goshop.app.presentation.model.widget.ProductsVM;
//import com.goshop.app.widget.viewholder.VideoProductItemViewHolder;
//
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import java.util.List;
//
//public class WidgetProductListAdapter extends RecyclerView.Adapter {
//
//    private List<ProductListModel> productListModels;
//
//    private List<ProductsVM> productsVMS;
//
//    public WidgetProductListAdapter(
//        List<ProductListModel> productListModels) {
//        this.productListModels = productListModels;
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        RecyclerView.ViewHolder viewHolder = null;
//        switch (viewType) {
//            case ProductListModel.PRODUCT_LIST_BUY_NOW:
//                View videoProductView = LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.item_videoplayer_product, parent, false);
//                viewHolder = new VideoProductItemViewHolder(videoProductView);
//                break;
//        }
//
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//
//        if (holder instanceof VideoProductItemViewHolder) {
//        }
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        return productListModels.get(position).getViewType();
//    }
//
//    @Override
//    public int getItemCount() {
//        return productListModels.size();
//    }
//}
