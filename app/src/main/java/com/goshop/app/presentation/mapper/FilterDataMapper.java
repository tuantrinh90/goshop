package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.FilterCategoryResponse;
import com.goshop.app.data.model.response.FilterStatusResponse;
import com.goshop.app.data.model.response.common.FilterCategorieData;
import com.goshop.app.data.model.response.common.FilterStatusData;
import com.goshop.app.presentation.model.FilterFlowVM;
import com.goshop.app.presentation.model.FilterMenuExpandVM;
import com.goshop.app.presentation.model.FilterMenuFlowButtonVM;
import com.goshop.app.presentation.model.FilterMenuModel;

import java.util.ArrayList;
import java.util.List;

public class FilterDataMapper {

    private static final String CATEGORY = "Category";

    private static final String STATUS = "Status";

    public static List<FilterMenuModel> transformDealCategory(FilterCategoryResponse response) {
        List<FilterMenuModel> filterMenuModels = new ArrayList<>();
        filterMenuModels.add(new FilterMenuExpandVM(CATEGORY, false));

        List<FilterCategorieData> categorieDatas = response.getCategories();
        List<FilterFlowVM> filterFlowVMS = new ArrayList<>();
        for (FilterCategorieData data: categorieDatas) {
            filterFlowVMS.add(new FilterFlowVM(data.getCategoryId(), data.getCategoryName()));
        }
        filterMenuModels.add(new FilterMenuFlowButtonVM(filterFlowVMS));
        return filterMenuModels;
    }

    public static List<FilterMenuModel> transformDealStatus(FilterStatusResponse response) {
        List<FilterMenuModel> filterMenuModels = new ArrayList<>();
        filterMenuModels.add(new FilterMenuExpandVM(STATUS, false));
        List<FilterStatusData> statusDatas = response.getStatus();
        List<FilterFlowVM> filterFlowVMS = new ArrayList<>();
        for (FilterStatusData data: statusDatas) {
            filterFlowVMS.add(new FilterFlowVM(data.getStatusId(), data.getStatusName()));
        }
        filterMenuModels.add(new FilterMenuFlowButtonVM(filterFlowVMS));
        return filterMenuModels;
    }

}
