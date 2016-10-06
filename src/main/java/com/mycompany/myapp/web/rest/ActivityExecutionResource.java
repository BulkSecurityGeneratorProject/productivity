package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.ActivityExecution;
import com.mycompany.myapp.service.ActivityExecutionService;
import com.mycompany.myapp.service.dto.ActivityExecutionDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/activity-execution")
public class ActivityExecutionResource {

    @Inject
    private ActivityExecutionService activityExecutionService;

    @RequestMapping(value = "date/{executionDate}", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActivityExecution> getActivitiesByDate(@PathVariable("executionDate")
                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate executionDate) {
        return activityExecutionService.findActivitiesByExecutionDate(executionDate);
    }

    @RequestMapping(method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createActivityExecution(@RequestBody ActivityExecutionDTO activityExecutionDTO) {
        activityExecutionService.create(activityExecutionDTO);
    }

    @RequestMapping(value = "{start}:{end}",
        method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActivityExecution> findByRange(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                               @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return activityExecutionService.getByDateRange(start, end);
    }
}
