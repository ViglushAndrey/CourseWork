package com.example.coursework.repository.Vzvods;

import com.example.coursework.model.Vzvods;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VzvodsRepository extends MongoRepository<Vzvods,String> {
}
