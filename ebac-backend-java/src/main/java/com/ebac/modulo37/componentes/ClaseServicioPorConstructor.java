package com.ebac.modulo37.componentes;

public class ClaseServicioPorConstructor {
    private final ClaseModelo claseModelo;

    public ClaseServicioPorConstructor(ClaseModelo claseModelo) {
        this.claseModelo = claseModelo;
    }

    public void ejecucionTarea() {
        String elementoPorId = claseModelo.getElementoPorId(1);
        System.out.println("Elemento recibido: " + elementoPorId);
    }
}
