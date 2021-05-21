package com.example.coursework.repository.TransportEquipment;

import com.example.coursework.model.TransportEquipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportEquipmentRepository extends MongoRepository<TransportEquipment,String> {
}
