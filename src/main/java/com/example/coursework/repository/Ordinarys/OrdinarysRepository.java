package com.example.coursework.repository.Ordinarys;

import com.example.coursework.model.Ordinarys;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdinarysRepository extends MongoRepository<Ordinarys,String> {
}
