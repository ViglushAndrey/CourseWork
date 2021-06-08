package com.example.coursework.Templates.tempQuery;

import com.example.coursework.model.Army;
import com.example.coursework.model.PermanentDislocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operations6")
public class PermDisQuery {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/get/all")
    public List<PermanentDislocation> operation1(){
        return mongoTemplate.find(new Query(), PermanentDislocation.class);
    }

}
