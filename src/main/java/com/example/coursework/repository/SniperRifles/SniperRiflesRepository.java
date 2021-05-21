package com.example.coursework.repository.SniperRifles;

import com.example.coursework.model.SniperRifles;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SniperRiflesRepository extends MongoRepository<SniperRifles,String> {
}
