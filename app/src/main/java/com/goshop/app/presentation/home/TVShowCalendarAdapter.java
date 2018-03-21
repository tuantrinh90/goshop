package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.TVShowVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TVShowCalendarAdapter extends RecyclerView.Adapter {

    private List<TVShowVM> displayDatas;

    private OnCalendarItemClickListener onCalendarItemClickListener;

    private List<TVShowVM> tvShowVMS;

    public TVShowCalendarAdapter(List<TVShowVM> tvShowVMS, String currentDay) {
        displayDatas = new ArrayList<>();
        this.tvShowVMS = tvShowVMS;
        upDateDisplayDatas(currentDay);
    }

    //todo this is mock decide
    private void upDateDisplayDatas(String currentDay) {
        displayDatas = tvShowVMS;
        for (int i = 0; i < displayDatas.size(); i++) {
            displayDatas.get(i).setCurrent(displayDatas.get(i).getDay().equals(currentDay));
            for (int j = displayDatas.size() - 1; j > i; j--) {
                if (displayDatas.get(i).getMouth()
                    .equals(displayDatas.get(j).getMouth()) && displayDatas
                    .get(i).getDay().equals(displayDatas.get(j).getDay())) {
                    displayDatas.remove(j);
                }
            }
        }
    }

    public void setUpdateDatas(List<TVShowVM> tvShowVMS, String currentDay) {
        this.tvShowVMS.clear();
        this.displayDatas.clear();
        this.tvShowVMS = tvShowVMS;
        upDateDisplayDatas(currentDay);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.item_calendar, viewGroup, false);
        return new CalenderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((CalenderViewHolder) viewHolder).bindingData(displayDatas.get(i), i);
    }

    @Override
    public int getItemCount() {
        return displayDatas.size();
    }

    public void setOnCalendarItemClickListener(
        OnCalendarItemClickListener onCalendarItemClickListener) {
        this.onCalendarItemClickListener = onCalendarItemClickListener;
    }

    public void updateSelectCalendar(int position) {
        for (int i = 0; i < displayDatas.size(); i++) {
            displayDatas.get(i).setCurrent(position == i);
        }
        notifyDataSetChanged();
    }

    interface OnCalendarItemClickListener {

        void onCalendarItemClick(int position);
    }

    class CalenderViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ll_tvshow_calendar)
        LinearLayout llTvShowCalendar;

        @BindView(R.id.tv_tv_show_day)
        RobotoMediumTextView tvTvShowDay;

        @BindView(R.id.tv_tv_show_week)
        RobotoLightTextView tvTvShowWeek;

        public CalenderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(TVShowVM tvShowVM, int position) {
            tvTvShowDay.setText(tvShowVM.getDay());
            tvTvShowWeek.setText(tvShowVM.getWeek());
            tvTvShowDay.setSelected(tvShowVM.isCurrent());
            tvTvShowWeek.setSelected(tvShowVM.isCurrent());
            llTvShowCalendar.setOnClickListener(v -> {
                //todo wait for api
//                onCalendarItemClickListener.onCalendarItemClick(getPositionInTotal(tvShowVM));
                updateSelectCalendar(position);
            });
        }
    }

}
