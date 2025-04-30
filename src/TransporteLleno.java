package com.empresa.transporte.excepciones;

public class TransporteLleno extends Exception {
    public TransporteLleno(String mensaje) {
        super(mensaje);
    }
}
