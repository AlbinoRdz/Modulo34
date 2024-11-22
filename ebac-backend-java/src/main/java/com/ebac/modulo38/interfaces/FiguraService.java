package com.ebac.modulo38.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FiguraService {

    @Autowired
    //@Qualifier("cuadrado")
    Figura cuadrado; // Cuadrado

    @Autowired
    //@Qualifier("triangulo")
    Figura triangulo; // Triangulo

    public void imprimirNombre1() {
        cuadrado.nombre();
    }

    public void imprimirNombre2() {
        triangulo.nombre();
    }
}
