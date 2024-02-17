package com.bonescorp.whatsnext.services;

import com.bonescorp.whatsnext.entities.Job;
import com.bonescorp.whatsnext.repositories.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobsRepository;

    @Override
    public Page<Job> getJobs() {
        return jobsRepository.findAll(Pageable.ofSize(10));
    }

    @Override
    public void insertJob(Job job) {
        jobsRepository.insert(job);
    }

    @Override
    public void updateJob(Job job) {
        jobsRepository.save(job);
    }
}
