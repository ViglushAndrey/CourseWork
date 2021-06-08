package com.example.coursework.Templates.tempQuery;

import com.example.coursework.model.Officers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.bson.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/operations")
public class OfficersQuery {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/get/all")
    public List<Officers> operation1(){
        return mongoTemplate.find(new Query(), Officers.class);
    }

    @GetMapping("/get/all/officerrank")
    public List<Document> operation2(){
        Query query = new Query();
        query.addCriteria(Criteria.where("officersRanks").is("Майор"));
        query.fields().include("name", "officersRanks");
        return mongoTemplate.find(query, Document.class, "officers");
    }

}
