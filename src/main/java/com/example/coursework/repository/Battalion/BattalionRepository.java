package com.example.coursework.repository.Battalion;

import com.example.coursework.model.Battalion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattalionRepository extends MongoRepository<Battalion,String> {
}
