package com.example.coursework.service.BTR.Interfaces;

import com.example.coursework.model.BTR;
import com.example.coursework.model.Brigade;

import java.util.List;

public interface BTRService {
    BTR getById(String id);
    BTR create(BTR btr);
    BTR update(BTR btr);
    BTR delete(String id);
    List<BTR> getAll();
}
