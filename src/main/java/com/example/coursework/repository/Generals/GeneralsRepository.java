package com.example.coursework.repository.Generals;

import com.example.coursework.model.Generals;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralsRepository extends MongoRepository<Generals,String> {
}
