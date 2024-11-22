package com.ebac.modulo37;

import com.ebac.modulo37.componentes.ClaseServicio;
import com.ebac.modulo37.componentes.ClaseServicioPorAnotacion;
import com.ebac.modulo37.componentes.ClaseServicioPorConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Contexto {

    public static void main(String[] args) {
        // Cargar el archivo applicationContext.xml para inicializar el ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Obtener el bean configurado a través del ApplicationContext
        //ClaseServicio miBean = (ClaseServicio) context.getBean("claseServicioBean");
        //ClaseServicioPorConstructor miBeanPorConstructor = (ClaseServicioPorConstructor) context.getBean("claseServicioBeanPorConstructor");
        ClaseServicioPorAnotacion miBeanPorAnotacion = (ClaseServicioPorAnotacion) context.getBean("claseServicioBeanPorAnotacion");

        // Usar el bean y realizar operaciones
        miBeanPorAnotacion.ejecucionTarea();
    }
}
