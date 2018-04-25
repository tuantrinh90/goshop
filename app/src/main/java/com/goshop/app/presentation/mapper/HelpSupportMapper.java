package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.HelpSupportActionResponse;
import com.goshop.app.data.model.response.HelpSupportResponse;
import com.goshop.app.data.model.response.HelpSupportSectionResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.presentation.model.HelpSupportActionVM;
import com.goshop.app.presentation.model.HelpSupportSectionVM;

import java.util.ArrayList;

public class HelpSupportMapper {

    public static ArrayList<HelpSupportSectionVM> transform(
        Response<HelpSupportResponse> helpSupportResponse) {
        ArrayList<HelpSupportSectionVM> helpSupportSectionVMs = new ArrayList<>();
        if (helpSupportResponse != null && helpSupportResponse
            .getData() != null && helpSupportResponse.getData()
            .getSection() != null && !helpSupportResponse.getData().getSection().isEmpty()) {
            for (HelpSupportSectionResponse helpSupportSectionResponse : helpSupportResponse
                .getData().getSection()) {
                HelpSupportSectionVM helpSupportSectionVM = new HelpSupportSectionVM();
                helpSupportSectionVM.setSectionTitle(helpSupportSectionResponse.getSectionTitle());
                ArrayList<HelpSupportActionVM> helpSupportActionVMs = new ArrayList<>();
                if (helpSupportSectionResponse.getActions() != null && !helpSupportSectionResponse
                    .getActions().isEmpty()) {
                    for (HelpSupportActionResponse helpSupportActionResponse :
                        helpSupportSectionResponse
                            .getActions()) {
                        HelpSupportActionVM helpSupportActionVM = new HelpSupportActionVM();
                        helpSupportActionVM.setTitle(helpSupportActionResponse.getTitle());
                        helpSupportActionVM.setLink(helpSupportActionResponse.getLink());
                        helpSupportActionVMs.add(helpSupportActionVM);
                    }
                    helpSupportSectionVM.setActions(helpSupportActionVMs);
                }
                helpSupportSectionVMs.add(helpSupportSectionVM);
            }
        }
        return helpSupportSectionVMs;
    }
}
