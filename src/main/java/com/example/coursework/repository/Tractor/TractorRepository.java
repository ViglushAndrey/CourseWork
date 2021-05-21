package com.example.coursework.repository.Tractor;

import com.example.coursework.model.Tractor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TractorRepository extends MongoRepository<Tractor,String> {
}
