package com.bonescorp.whatsnext.services;

import com.bonescorp.whatsnext.entities.Job;
import org.springframework.data.domain.Page;

public interface JobService {
     Page<Job> getJobs();

     void insertJob(Job job);

     void updateJob(Job job);
}
