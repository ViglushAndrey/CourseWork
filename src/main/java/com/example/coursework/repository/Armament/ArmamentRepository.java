package com.example.coursework.repository.Armament;

import com.example.coursework.model.Armament;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmamentRepository extends MongoRepository<Armament, String> {
}
