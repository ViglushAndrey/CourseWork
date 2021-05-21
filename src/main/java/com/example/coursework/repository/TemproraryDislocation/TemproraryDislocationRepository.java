package com.example.coursework.repository.TemproraryDislocation;

import com.example.coursework.model.TemporaryDislocation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemproraryDislocationRepository extends MongoRepository<TemporaryDislocation, String> {
}
