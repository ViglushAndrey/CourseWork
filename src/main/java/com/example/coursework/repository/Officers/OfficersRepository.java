package com.example.coursework.repository.Officers;

import com.example.coursework.model.Officers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficersRepository extends MongoRepository<Officers,String> {
}
