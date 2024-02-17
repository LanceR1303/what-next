package com.bonescorp.whatsnext.services;

import com.bonescorp.whatsnext.entities.Job;
import com.bonescorp.whatsnext.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobsRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    @Override
    public Page<Job> getJobs() {
        return jobsRepository.findAll(Pageable.ofSize(10));
    }
}
