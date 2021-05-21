package com.example.coursework.repository.Viddilenia;

import com.example.coursework.model.Viddilenia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViddileniaRepository extends MongoRepository<Viddilenia,String> {
}
