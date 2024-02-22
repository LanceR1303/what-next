package com.bonescorp.whatsnext.services;

import com.bonescorp.whatsnext.entities.Job;
import com.bonescorp.whatsnext.repositories.job.JobRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JobServiceTest {

    @Mock
    private JobRepository jobRepository;

    @InjectMocks
    private JobServiceImpl jobService;

    @Test
    public void givenJobs_whenGetJobs_returnAllJobs() {
        Page<Job> jobsMock = new PageImpl<>(List.of(createDefaultJob()));
        when(jobRepository.findAll(any(Pageable.class))).thenReturn(jobsMock);
        assertEquals("My Test Job" ,jobService.getJobs().get().findFirst().get().getDescription());
    }

    @Test
    public void givenNewJob_saveJob() {
        Job jobMock = Job.builder().build();
        jobService.insertJob(jobMock);
        verify(jobRepository).save(jobMock);
    }

    @Test
    public void givenExistingJob_updateJob() {
        Job jobMock = Job.builder().build();
        jobService.updateJob(jobMock);
        verify(jobRepository).save(jobMock);
    }

    private Job createDefaultJob() {
        return Job.builder().description("My Test Job").build();
    }
}
