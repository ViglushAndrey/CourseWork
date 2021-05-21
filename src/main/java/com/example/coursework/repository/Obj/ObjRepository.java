package com.example.coursework.repository.Obj;

import com.example.coursework.model.Obj;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjRepository extends MongoRepository<Obj,String> {
}
