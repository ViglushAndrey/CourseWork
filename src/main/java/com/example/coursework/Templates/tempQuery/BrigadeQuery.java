package com.example.coursework.Templates.tempQuery;

import com.example.coursework.model.Army;
import com.example.coursework.model.Brigade;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operations5")
public class BrigadeQuery {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/get/all")
    public List<Brigade> operation1(){
        return mongoTemplate.find(new Query(), Brigade.class);
    }

    @GetMapping("/get/all/Brigade")
    public List<Document> operation2(){
        Query query = new Query();
        query.fields().include("name", "officers");
        return mongoTemplate.find(query, Document.class, "brigade");
    }


}
