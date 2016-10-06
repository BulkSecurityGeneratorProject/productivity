package com.mycompany.myapp.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ActivityExecution {

    @Id
    @GeneratedValue
    Long id;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    Activity activity;

    LocalDate executionDate;

    public ActivityExecution() {
    }

    public ActivityExecution(Activity activity) {
        this.activity = activity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }
}
