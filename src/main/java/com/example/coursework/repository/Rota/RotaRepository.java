package com.example.coursework.repository.Rota;

import com.example.coursework.model.Rota;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RotaRepository extends MongoRepository<Rota,String> {
}
