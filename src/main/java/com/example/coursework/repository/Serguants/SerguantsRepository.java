package com.example.coursework.repository.Serguants;

import com.example.coursework.model.Serguants;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerguantsRepository extends MongoRepository<Serguants,String> {
}
