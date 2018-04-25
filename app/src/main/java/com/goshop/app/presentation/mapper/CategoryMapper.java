package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.CategoriesChild;
import com.goshop.app.data.model.response.CategoriesParent;
import com.goshop.app.data.model.response.CategoryResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.presentation.model.CategoriesChildVM;
import com.goshop.app.presentation.model.CategoriesParentVM;
import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    public static List<CategoriesParentVM> transform(
        Response<CategoryResponse> categoryMenuResponse) {
        List<CategoriesParentVM> categories = new ArrayList<>();
        if (categoryMenuResponse != null && categoryMenuResponse
            .getData() != null && categoryMenuResponse.getData()
            .getCategories() != null && categoryMenuResponse.getData().getCategories().size() > 0) {
            for (CategoriesParent categoriesParent : categoryMenuResponse.getData()
                .getCategories()) {
                CategoriesParentVM categoriesParentVM = new CategoriesParentVM();
                categoriesParentVM.setId(categoriesParent.getId());
                categoriesParentVM.setName(categoriesParent.getName());
                categoriesParentVM.setIcon(categoriesParent.getIcon());
                categoriesParentVM.setLink(categoriesParent.getLink());
                if (categoriesParent.getChild() != null) {
                    categoriesParentVM.setChild(transformChild(categoriesParent.getChild()));
                }
                categories.add(categoriesParentVM);
            }
        }
        return categories;

    }

    private static List<CategoriesChildVM> transformChild(List<CategoriesChild> child) {
        ArrayList<CategoriesChildVM> categoriesChildVMs = new ArrayList<>();
        if (child.size() > 0) {
            for (CategoriesChild categoriesChild : child) {
                CategoriesChildVM categoriesChildVM = new CategoriesChildVM();
                categoriesChildVM.setId(categoriesChild.getId());
                categoriesChildVM.setLink(categoriesChild.getLink());
                categoriesChildVM.setIcon(categoriesChild.getIcon());
                categoriesChildVM.setName(categoriesChild.getName());
                categoriesChildVM.setParent(categoriesChild.getParent());
                if (categoriesChild.getChild() != null) {
                    categoriesChildVM.setChild(transformChild(categoriesChild.getChild()));
                }
                categoriesChildVMs.add(categoriesChildVM);
            }

        }
        return categoriesChildVMs;
    }
}
