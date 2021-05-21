package com.example.coursework.repository.Automats;

import com.example.coursework.model.Automats;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomatsRepository extends MongoRepository<Automats,String> {
}
