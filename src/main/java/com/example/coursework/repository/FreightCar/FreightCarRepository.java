package com.example.coursework.repository.FreightCar;

import com.example.coursework.model.FreightCar;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreightCarRepository extends MongoRepository<FreightCar,String> {
}
