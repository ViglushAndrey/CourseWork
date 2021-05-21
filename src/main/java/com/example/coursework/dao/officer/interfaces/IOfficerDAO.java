package com.example.coursework.dao.officer.interfaces;

import com.example.coursework.model.Officers;


import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * course.IOfficerDAO
 *
 * @Autor: Andrey
 * @DateTime: 8.03.2021|13:57
 * @Version: IOfficerDAO: 1.0
 */
public interface IOfficerDAO {

    //CRUD
    Officers getById(String id);
    Officers create(Officers officers);
    Officers update(Officers officers);
    Officers delete(String id);
    List<Officers> getAll();


}
