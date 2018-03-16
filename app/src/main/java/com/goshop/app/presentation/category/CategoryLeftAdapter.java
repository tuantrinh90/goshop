package com.goshop.app.presentation.category;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.CategoryLeftMenuVM;

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

    private CategoryLeftClickListener leftClickListener;

    private List<CategoryLeftMenuVM> leftMenuVMS;

    public CategoryLeftAdapter(
        List<CategoryLeftMenuVM> leftMenuVMS, CategoryLeftClickListener leftClickListener) {
        this.leftMenuVMS = leftMenuVMS;
        this.leftClickListener = leftClickListener;
    }

    public void setUpdateLeftCategorys(List<CategoryLeftMenuVM> leftMenuVMS) {
        this.leftMenuVMS.clear();
        this.leftMenuVMS = leftMenuVMS;
        notifyDataSetChanged();
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
            for (CategoryLeftMenuVM leftMenuVM : leftMenuVMS) {
                leftMenuVM.setSelect(false);
            }
            leftMenuVMS.get(position).setSelect(true);
            notifyDataSetChanged();
        }
    }

    public interface CategoryLeftClickListener {

        void onLeftClick(CategoryLeftMenuVM leftMenuVM);
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

        void bindingData(CategoryLeftMenuVM leftMenuVM, int position) {
            Glide.with(itemView.getContext()).load(leftMenuVM.getIconUrl()).asBitmap()
                .error(leftMenuVM.getDefaultIcon())
                .into(ivCategoryLeftMenu);
            tvCategoryLeftMenu.setText(leftMenuVM.getTitle());

            tvCategoryLeftMenu.setSelected(leftMenuVM.isSelect());
            ivCategoryLeftMenu.setSelected(leftMenuVM.isSelect());

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
