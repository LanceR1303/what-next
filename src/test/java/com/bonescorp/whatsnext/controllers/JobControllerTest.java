package com.bonescorp.whatsnext.controllers;

import com.bonescorp.whatsnext.entities.Job;
import com.bonescorp.whatsnext.services.JobServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JobControllerTest {

    @InjectMocks
    private JobController jobController;

    @Mock
    private JobServiceImpl jobService;

    @Test
    public void whenJobsExist_andGetJobs_returnAllJobs() {
        Page<Job> jobsMock = new PageImpl<>(List.of(createDefaultJob()));
        when(jobService.getJobs()).thenReturn(jobsMock);
        assertEquals("My Test Job" , jobController.getJobs().stream().findFirst().get().getDescription());
    }

    @Test
    public void whenNewJob_verifyJobSaved() {
        Job jobMock = Job.builder().build();
        jobController.create(jobMock);
        verify(jobService).insertJob(jobMock);
    }

    @Test
    public void whenNewJob_verifyJobUpdated() {
        Job jobMock = Job.builder().build();
        jobController.update(jobMock);
        verify(jobService).updateJob(jobMock);
    }

    private Job createDefaultJob() {
        return Job.builder().description("My Test Job").build();
    }
}
