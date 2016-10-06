package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Activity;
import com.mycompany.myapp.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    @Inject
    private ActivityRepository activityRepository;

    public Collection<String> getActivitiesNames() {
        List<String> names = activityRepository.findAll().stream().map(Activity::getName).collect(Collectors.toList());
        return names;
    }

    public Activity createActivity(Activity activity) {
        Activity newActivity = activityRepository.save(activity);
        return newActivity;
    }



}
