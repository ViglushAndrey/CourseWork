package com.example.coursework.MSSQL.ms_sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ViddileniaSql")
public class ViddileniaControllerSQL {

    @Autowired
    ViddileniaRepSQL repSQL;

    @GetMapping(value = "/get/all")
    public List<ViddileniaSQL> getViddilenia(){
        return (List<ViddileniaSQL>) repSQL.findAll();
    }

    @GetMapping(value = "/delete/{id}")
    public List<ViddileniaSQL> deleteById(@PathVariable("id") final Long id){
        ViddileniaSQL viddileniaSQL = new ViddileniaSQL();
        repSQL.deleteById(id);
        return (List<ViddileniaSQL>) repSQL.findAll();
    }

    @GetMapping(value = "/create/{id}/{name}/{people_Sklad}")
    public List<ViddileniaSQL> create(@PathVariable("id") final Long id,
                                @PathVariable("name") final String name,
                                @PathVariable("people_Sklad") final Long people_Sklad){

        ViddileniaSQL viddileniaSQL = new ViddileniaSQL(id,name,people_Sklad);
        repSQL.save(viddileniaSQL);
        return (List<ViddileniaSQL>) repSQL.findAll();
    }

    @GetMapping(value = "/uppdate/{id}/{name}/{people_Sklad}")
    public List<ViddileniaSQL> update(@PathVariable("id") final Long id,
                                @PathVariable("name") final String name,
                                @PathVariable("people_Sklad") final Long people_Sklad){
        ViddileniaSQL viddileniaSQL = repSQL.findById(id).get();
        viddileniaSQL.setName(name);
        viddileniaSQL.setPeople_Sklad(people_Sklad);
        return (List<ViddileniaSQL>) repSQL.findAll();
    }

}
