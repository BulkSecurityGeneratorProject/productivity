package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.Activity;
import com.mycompany.myapp.domain.ActivityExecution;
import com.mycompany.myapp.service.ActivityExecutionService;
import com.mycompany.myapp.service.ActivityService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/activity")
public class ActivityResource {

    @Inject
    private ActivityService activityService;

    @RequestMapping(method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<String> getActivitiesNames() {
        return activityService.getActivitiesNames();
    }

    @RequestMapping(method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void createActivity(@RequestBody Activity activity) {
        activityService.createActivity(activity);
    }
}
