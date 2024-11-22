package com.ebac.modulo37.componentes;

import org.springframework.beans.factory.annotation.Autowired;

public class ClaseServicioPorAnotacion {

    @Autowired
    ClaseModelo claseModelo;

    public void ejecucionTarea() {
        String elementoPorId = claseModelo.getElementoPorId(1);
        System.out.println("Autowired: " + elementoPorId);
    }
}
