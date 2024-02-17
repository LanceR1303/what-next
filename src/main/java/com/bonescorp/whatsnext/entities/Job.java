package com.bonescorp.whatsnext.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("jobs-raw")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private ObjectId objectid;
    private String description;
}
