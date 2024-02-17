package com.bonescorp.whatsnext.services;

import com.bonescorp.whatsnext.entities.Job;
import com.bonescorp.whatsnext.repositories.JobRepository;
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
import static org.mockito.Mockito.when;

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

    private Job createDefaultJob() {
        return Job.builder().description("My Test Job").build();
    }
}
