package com.ebac.modulo37.componentes;

public class ClaseServicio {

    private ClaseModelo claseModelo;

    public void ejecucionTarea() {
        String elementoPorId = claseModelo.getElementoPorId(1);
        System.out.println("Elemento recibido: " + elementoPorId);
    }

    public void setClaseModelo(ClaseModelo claseModelo) {
        this.claseModelo = claseModelo;
    }
}
