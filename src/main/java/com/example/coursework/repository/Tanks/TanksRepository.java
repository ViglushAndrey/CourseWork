package com.example.coursework.repository.Tanks;

import com.example.coursework.model.Tanks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TanksRepository extends MongoRepository<Tanks,String> {
}
