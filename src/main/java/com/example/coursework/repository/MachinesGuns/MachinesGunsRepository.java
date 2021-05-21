package com.example.coursework.repository.MachinesGuns;

import com.example.coursework.model.MachinesGuns;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachinesGunsRepository extends MongoRepository<MachinesGuns,String> {
}
