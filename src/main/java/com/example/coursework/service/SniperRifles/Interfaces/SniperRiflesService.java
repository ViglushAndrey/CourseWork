package com.example.coursework.service.SniperRifles.Interfaces;

import com.example.coursework.model.Serguants;
import com.example.coursework.model.SniperRifles;

import java.util.List;

public interface SniperRiflesService {
    SniperRifles getById(String id);
    SniperRifles create(SniperRifles sniperRifles);
    SniperRifles update(SniperRifles sniperRifles);
    SniperRifles delete(String id);
    List<SniperRifles> getAll();
}
