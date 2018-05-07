package com.goshop.app.presentation.category;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.Typefaces;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.CategoriesParentVM;
import com.goshop.app.utils.GlideUtils;
import com.goshop.app.widget.listener.OnCategoryItemClickListener;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryLeftAdapter extends RecyclerView.Adapter {

    private OnCategoryItemClickListener leftClickListener;

    private List<CategoriesParentVM> leftMenuVMS;

    public CategoryLeftAdapter(
        List<CategoriesParentVM> leftMenuVMS, OnCategoryItemClickListener leftClickListener) {
        this.leftMenuVMS = leftMenuVMS;
        this.leftClickListener = leftClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View leftView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_category_left_menu, parent, false);

        return new CategoryLeftViewHolder(leftView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CategoryLeftViewHolder) holder).bindingData(leftMenuVMS.get(position), position);
    }

    @Override
    public int getItemCount() {
        return leftMenuVMS.size();
    }

    public void selectPosition(int position) {
        if (!leftMenuVMS.get(position).isSelect()) {
            for (CategoriesParentVM leftMenuVM : leftMenuVMS) {
                leftMenuVM.setSelect(false);
            }
            leftMenuVMS.get(position).setSelect(true);
            notifyDataSetChanged();
        }
    }


    class CategoryLeftViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_category_left_menu)
        ImageView ivCategoryLeftMenu;

        @BindView(R.id.rl_item_category_left)
        RelativeLayout rlLayoutCategoryLeft;

        @BindView(R.id.tv_category_left_menu)
        RobotoRegularTextView tvCategoryLeftMenu;

        public CategoryLeftViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(CategoriesParentVM leftMenuVM, int position) {
            // TODO: 2018/4/25 mockIcon need change
            GlideUtils.loadImageError(
                itemView.getContext(),
                leftMenuVM.getMockIcon(),
                ivCategoryLeftMenu,
                R.drawable.ic_image_404_big);
            tvCategoryLeftMenu.setText(leftMenuVM.getName());
            tvCategoryLeftMenu.setSelected(leftMenuVM.isSelect());
            ivCategoryLeftMenu.setSelected(leftMenuVM.isSelect());
            Typeface typeface = Typefaces.get(itemView.getContext(), leftMenuVM
                .isSelect() ? Typefaces.PATH_FONT_ROBOTO_REGULAR : Typefaces
                .PATH_FONT_ROBOTO_LIGHT);
            tvCategoryLeftMenu.setTypeface(typeface);
            ivCategoryLeftMenu.setColorFilter(
                itemView.getContext().getResources()
                    .getColor(ivCategoryLeftMenu
                        .isSelected() ? R.color.color_main_pink : R.color.color_img_grey));

            rlLayoutCategoryLeft.setSelected(leftMenuVM.isSelect());

            itemView.setOnClickListener(v -> {
                selectPosition(position);
                leftClickListener.onLeftClick(leftMenuVM);
            });

        }
    }
}
