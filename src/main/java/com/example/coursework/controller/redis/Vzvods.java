package com.example.coursework.controller.redis;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Vzvods")
public class Vzvods {

    private String id;
    private String name;
    private int osoboviySklad;
    private Viddilenia viddilenia;

    public Vzvods() {
    }

    public Vzvods(String id, String name, int osoboviySklad, Viddilenia viddilenia) {
        this.id = id;
        this.name = name;
        this.osoboviySklad = osoboviySklad;
        this.viddilenia = viddilenia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOsoboviySklad() {
        return osoboviySklad;
    }

    public void setOsoboviySklad(int osoboviySklad) {
        this.osoboviySklad = osoboviySklad;
    }

    public Viddilenia getViddilenia() {
        return viddilenia;
    }

    public void setViddilenia(Viddilenia viddilenia) {
        this.viddilenia = viddilenia;
    }

    @Override
    public String toString() {
        return "Vzvods{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", osoboviySklad=" + osoboviySklad +
                ", viddilenia=" + viddilenia +
                '}';
    }
}
