package com.example.coursework.repository.Grenades;

import com.example.coursework.model.Grenades;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrenadesRepository extends MongoRepository<Grenades,String> {
}
