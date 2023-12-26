/**
 * 
 */
package com.soa.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.google.gson.Gson;
import com.soa.SumaResponse;
import com.soa.SumaRequest;
import com.soa.business.SumaBusiness;

/**
 * Clase que publica un servicio web tipo SOAP. Capa Boundary
 */
@Endpoint
public class SumaEndpoint {
    /** Objeto inyectado de la capa de negocio. */
    @Autowired
    private SumaBusiness business;

    private static final String NAMESPACE_URI = "http://soa.com";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SumaRequest")
    @ResponsePayload
    public SumaResponse sumaOperation(@RequestPayload SumaRequest request) {

        SumaResponse out = new SumaResponse();

        List<Double> sumaNumeros = request.getNumero();
        
        Double sumatoria = business.suma(sumaNumeros);

        out.setSuma(sumatoria);

        return out;
    }
}