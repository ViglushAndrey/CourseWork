package com.example.coursework.repository.Departament;

import com.example.coursework.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentRepository extends MongoRepository<Department,String> {
}
