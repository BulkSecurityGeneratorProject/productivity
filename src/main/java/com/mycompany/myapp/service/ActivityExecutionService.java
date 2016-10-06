package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Activity;
import com.mycompany.myapp.domain.ActivityExecution;
import com.mycompany.myapp.repository.ActivityExecutionRepository;
import com.mycompany.myapp.repository.ActivityRepository;
import com.mycompany.myapp.service.dto.ActivityExecutionDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityExecutionService {

    @Inject
    private ActivityExecutionRepository repository;

    @Inject
    private ActivityRepository activityRepository;

    // TODO refactor
    public List<ActivityExecution> findActivitiesByExecutionDate(LocalDate executionDate) {
        List<ActivityExecution> activityExecutions = repository.findByExecutionDate(executionDate);

        List<Long> ids = activityExecutions.stream().map(ActivityExecution::getActivity).map(Activity::getId)
            .collect(Collectors.toList());

        List<Activity> activities;

        if (ids.isEmpty()) {
            activities = activityRepository.findAll();
        } else {
            activities = activityRepository.findAllByIdNotIn(ids);
        }

        List<ActivityExecution> collect = activities.stream().map(ActivityExecution::new).collect(Collectors.toList());
        activityExecutions.addAll(collect);

        return activityExecutions;
    }

    public ActivityExecution create(ActivityExecutionDTO activityExecutionDTO) {
        ActivityExecution activityExecution = new ActivityExecution();
        activityExecution.setExecutionDate(activityExecutionDTO.getExecutionDate());

        Activity activity = activityRepository.findOne(activityExecutionDTO.getActivityId());
        activityExecution.setActivity(activity);

        return repository.save(activityExecution);
    }

    public List<ActivityExecution> getByDateRange(LocalDate start, LocalDate end) {
        List<ActivityExecution> activityExecutions = repository.findByExecutionDateBetween(start, end);
        return activityExecutions;
    }
}
