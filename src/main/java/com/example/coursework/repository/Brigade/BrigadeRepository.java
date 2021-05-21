package com.example.coursework.repository.Brigade;

import com.example.coursework.model.Brigade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrigadeRepository extends MongoRepository<Brigade,String> {
}
