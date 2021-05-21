package com.example.coursework.repository.BTR;

import com.example.coursework.model.BTR;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BTRRepository extends MongoRepository<BTR,String> {
}
