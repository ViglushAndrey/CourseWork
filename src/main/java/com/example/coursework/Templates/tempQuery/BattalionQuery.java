package com.example.coursework.Templates.tempQuery;

import com.example.coursework.model.Army;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operations4")
public class BattalionQuery {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/get/all")
    public List<Army> operation1(){
        return mongoTemplate.find(new Query(), Army.class);
    }

    @GetMapping("/get/all/Battalion")
    public List<Document> operation2(){
        Query query = new Query();
        query.fields().include("name", "generals");
        return mongoTemplate.find(query, Document.class, "battalion");
    }

}
