package com.example.coursework.repository.Pistols;

import com.example.coursework.model.Pistols;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PistolsRepository extends MongoRepository<Pistols,String> {
}
