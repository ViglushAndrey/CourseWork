package com.example.coursework.repository.Army;

import com.example.coursework.model.Army;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmyRepository extends MongoRepository<Army, String> {
}
