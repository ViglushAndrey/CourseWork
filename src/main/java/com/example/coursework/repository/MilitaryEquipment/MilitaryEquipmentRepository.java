package com.example.coursework.repository.MilitaryEquipment;

import com.example.coursework.model.MilitaryEquipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilitaryEquipmentRepository extends MongoRepository<MilitaryEquipment,String> {
}
