package com.bonescorp.whatsnext.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="JOB")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    private String id;
    private String description;
}
