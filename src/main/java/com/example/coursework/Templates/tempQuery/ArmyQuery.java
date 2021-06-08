package com.example.coursework.Templates.tempQuery;

import com.example.coursework.model.Army;
import com.example.coursework.model.Generals;
import com.example.coursework.model.Officers;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operations3")
public class ArmyQuery {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/get/all")
    public List<Army> operation1(){
        return mongoTemplate.find(new Query(), Army.class);
    }

    @GetMapping("/get/all/Army")
    public List<Document> operation2(){
        Query query = new Query();
        query.fields().include("name", "generals");
        return mongoTemplate.find(query, Document.class, "army");
    }
    @GetMapping("/get/all/Army1")
    public List<Document> operation3(){
        Query query = new Query();
        query.fields().include("name", "permanentDislocation");
        return mongoTemplate.find(query, Document.class, "army");
    }

    @GetMapping("/get/all/Army2")
    public List<Document> operation4(){
        Query query = new Query();
        query.fields().include("name", "temporaryDislocation");
        return mongoTemplate.find(query, Document.class, "army");
    }
}
