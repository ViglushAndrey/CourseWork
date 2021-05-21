package com.example.coursework.repository.BMP;

import com.example.coursework.model.BMP;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BMPRepository extends MongoRepository<BMP,String> {
}
