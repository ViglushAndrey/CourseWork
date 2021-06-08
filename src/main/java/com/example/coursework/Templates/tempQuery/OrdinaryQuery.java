package com.example.coursework.Templates.tempQuery;

import com.example.coursework.model.Officers;
import com.example.coursework.model.Ordinarys;
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
@RequestMapping("/operations2")
public class OrdinaryQuery {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/get/all")
    public List<Ordinarys> operation1(){
        return mongoTemplate.find(new Query(), Ordinarys.class);
    }

    @GetMapping("/get/all/ordinaryrank")
    public List<Document> operation2(){
        Query query = new Query();
        query.addCriteria(Criteria.where("ordinaryRanks").is("СтаршийСолдат"));
        query.fields().include("name", "ordinaryRanks");
        return mongoTemplate.find(query, Document.class, "ordinarys");
    }

}
