package com.example.coursework.Templates.tempQuery;

import com.example.coursework.model.PermanentDislocation;
import com.example.coursework.model.TemporaryDislocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operations7")
public class TempDislQuery {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/get/all")
    public List<TemporaryDislocation> operation1(){
        return mongoTemplate.find(new Query(), TemporaryDislocation.class);
    }

}
