package com.bonescorp.whatsnext.controllers;

import com.bonescorp.whatsnext.entities.Job;
import com.bonescorp.whatsnext.services.JobService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> getJobs() {
        return jobService.getJobs().getContent();
    }

    public void create(Job job) {
        jobService.insertJob(job);
    }

    public void update(Job job) {
        jobService.updateJob(job);
    }
}
