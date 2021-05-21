package com.example.coursework.service.BMP.Interfaces;

import com.example.coursework.model.BMP;
import com.example.coursework.model.Battalion;

import java.util.List;

public interface BMPService {
    BMP getById(String id);
    BMP create(BMP bmp);
    BMP update(BMP bmp);
    BMP delete(String id);
    List<BMP> getAll();
}
