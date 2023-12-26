/**
 * 
 */
package com.soa.business;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 *  Capa de negocio de suma de n numeros.
 */
@Component
public class SumaBusiness {

public double suma(List<Double> sumaNumeros) {
        
        double suma = 0.0;
        
        for (Double numero : sumaNumeros) {
            suma += numero;
        }
        return suma;
    }
}
