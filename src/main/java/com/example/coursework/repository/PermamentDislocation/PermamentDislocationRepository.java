package com.example.coursework.repository.PermamentDislocation;

import com.example.coursework.model.PermanentDislocation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermamentDislocationRepository extends MongoRepository<PermanentDislocation, String> {
}
