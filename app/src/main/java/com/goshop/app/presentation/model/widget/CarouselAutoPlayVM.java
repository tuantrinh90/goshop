package com.goshop.app.presentation.model.widget;

/**
 * Created by helen on 2018/2/12.
 */

public class CarouselAutoPlayVM {

    private String direction;

    private long duration;

    /**
     * enabled : true
     * duration : 500
     * loop : 8
     * direction : right
     */

    private boolean enabled;

    private String loop;

    public CarouselAutoPlayVM(int duration, boolean enabled) {
        this.duration = duration;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getLoop() {
        return loop;
    }

    public void setLoop(String loop) {
        this.loop = loop;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
