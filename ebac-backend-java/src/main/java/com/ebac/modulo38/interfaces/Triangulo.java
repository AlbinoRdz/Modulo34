package com.ebac.modulo38.interfaces;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("triangulo")
public class Triangulo implements Figura {

    @Override
    public void nombre() {
        System.out.println("Soy un triangulo");
    }
}
