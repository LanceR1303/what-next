package com.bonescorp.whatsnext.repositories;

import com.bonescorp.whatsnext.entities.Job;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job, ObjectId> {

}
