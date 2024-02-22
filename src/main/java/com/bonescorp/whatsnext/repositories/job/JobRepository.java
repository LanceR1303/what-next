package com.bonescorp.whatsnext.repositories.job;

import com.bonescorp.whatsnext.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
}
