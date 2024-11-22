package com.ebac.modulo38.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Service {

    @Autowired
    DataBase dataBase;

    public String getById(int id) {
        if (id < 10) {
            return "El id no puede ser menor a 10";
        }
        return dataBase.getById(id);
    }
}
