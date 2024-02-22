package com.bonescorp.whatsnext.services;

import com.bonescorp.whatsnext.entities.Job;
import com.bonescorp.whatsnext.repositories.job.JobRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public Page<Job> getJobs() {

        return jobRepository.findAll(Pageable.ofSize(10));
    }

    @Override
    public void insertJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public void updateJob(Job job) {
        jobRepository.save(job);
    }
}
