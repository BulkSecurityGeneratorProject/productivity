package com.mycompany.myapp.service.dto;

import java.time.LocalDate;

/**
 * Created by vagrant on 9/22/16.
 */
public class ActivityExecutionDTO {
    private Long activityId;
    private LocalDate executionDate;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }
}
