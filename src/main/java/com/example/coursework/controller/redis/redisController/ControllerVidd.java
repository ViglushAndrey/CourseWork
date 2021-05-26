package com.example.coursework.controller.redis.redisController;

import com.example.coursework.controller.redis.VidRep;
import com.example.coursework.controller.redis.Viddilenia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Viddilenia")
public class ControllerVidd {

    @Autowired
    VidRep vidRep;

    @GetMapping(value = "/get/all")
    public List<Viddilenia> viddilenias(){
        return (List<Viddilenia>) vidRep.findAll();
    }

    @GetMapping(value = "/create/{id}/{name}/{osoboviySklad}")
    public List<Viddilenia> viddileniasCreate1(@PathVariable("id") final String id,
                                               @PathVariable("name") final String name,
                                               @PathVariable("osoboviySklad") final int osoboviySklad){
        Viddilenia viddilenia = new Viddilenia(id,name,osoboviySklad);
        vidRep.save(viddilenia);
        return (List<Viddilenia>) vidRep.findAll();
    }

    @GetMapping(value = "/uppdate/{id}/{name}/{osoboviySklad}")
    public List<Viddilenia> viddileniasUppdate(@PathVariable("id") final String id,
                                               @PathVariable("name") final String name,
                                               @PathVariable("osoboviySklad") final int osoboviySklad){
        Viddilenia viddilenia = vidRep.findById(id).get();
        viddilenia.setName(name);
        viddilenia.setOsoboviySklad(osoboviySklad);
        vidRep.save(viddilenia);
        return (List<Viddilenia>) vidRep.findAll();
    }

    @GetMapping(value = "/delete/{id}")
    public List<Viddilenia> viddileniaDelete(@PathVariable("id") final String id){
        Viddilenia viddilenia = new Viddilenia();
        vidRep.deleteById(id);
        return (List<Viddilenia>) vidRep.findAll();
    }

}
