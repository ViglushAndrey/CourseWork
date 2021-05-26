package com.example.coursework.controller.redis.redisController;

import com.example.coursework.controller.redis.VidRep;
import com.example.coursework.controller.redis.Viddilenia;
import com.example.coursework.controller.redis.VzvodRep;
import com.example.coursework.controller.redis.Vzvods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Vzvod")
public class ControllerVzvod {

    @Autowired
    VzvodRep vzvodRep;

    @Autowired
    VidRep vidRep;

    @GetMapping(value = "/get/all")
    public List<Vzvods> vzvods() {
        return (List<Vzvods>) vzvodRep.findAll();
    }

    @GetMapping(value = "create/{id}/{name}/{osoboviySklad}/{viddilenia}")
    public List<Vzvods> vzvodsCreate(@PathVariable("id") final String id,
                                     @PathVariable("name") final String name,
                                     @PathVariable("osoboviySklad") final int osoboviySklad,
                                     @PathVariable("viddilenia") final String idVid) {
        Vzvods vzvods = new Vzvods(id, name, osoboviySklad, vidRep.findById(idVid).get());
        vzvodRep.save(vzvods);
        return (List<Vzvods>) vzvodRep.findAll();
    }

    @GetMapping(value = "/uppdate/{id}/{name}/{osoboviySklad}/{viddilenia}")
    public List<Vzvods> vzvodsUppdate(@PathVariable("id") final String id,
                                      @PathVariable("name") final String name,
                                      @PathVariable("osoboviySklad") final int osoboviySklad,
                                      @PathVariable("viddilenia") final Viddilenia idVid) {
        Vzvods vzvods = vzvodRep.findById(id).get();
        vzvods.setName(name);
        vzvods.setOsoboviySklad(osoboviySklad);
        vzvods.setViddilenia(idVid);
        vzvodRep.save(vzvods);
        return (List<Vzvods>) vzvodRep.findAll();
    }

    @GetMapping(value = "/delete/{id}")
    public List<Vzvods> vzvodsDelete(@PathVariable("id") final String id) {
        Vzvods vzvods = new Vzvods();
        vidRep.deleteById(id);
        return (List<Vzvods>) vzvodRep.findAll();
    }
}
