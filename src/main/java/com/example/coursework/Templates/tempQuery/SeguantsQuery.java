package com.example.coursework.Templates.tempQuery;


import com.example.coursework.model.Officers;
import com.example.coursework.model.Serguants;
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
@RequestMapping("/operations1")
public class SeguantsQuery {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/get/all")
    public List<Serguants> operation1(){
        return mongoTemplate.find(new Query(), Serguants.class);
    }

    @GetMapping("/get/all/serguantrank")
    public List<Document> operation2(){
        Query query = new Query();
        query.addCriteria(Criteria.where("serguantsRanks").is("СтаршийСержант"));
        query.fields().include("name", "serguantsRanks");
        return mongoTemplate.find(query, Document.class, "serguants");
    }

}
