package com.example.coursework.controller.redis;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Viddilenia")
public class Viddilenia {

    private String id;
    private String name;
    private int osoboviySklad;

    public Viddilenia() {
    }

    public Viddilenia(String id, String name, int osoboviySklad) {
        this.id = id;
        this.name = name;
        this.osoboviySklad = osoboviySklad;
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

    @Override
    public String toString() {
        return "Viddilenia{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", osoboviySklad=" + osoboviySklad +
                '}';
    }
}
