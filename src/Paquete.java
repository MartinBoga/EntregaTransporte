package com.empresa.transporte.modelo;

public class Paquete {
    private double alto;
    private double ancho;
    private double profundo;
    private double peso;
    private String destino;

    public Paquete(double alto, double ancho, double profundo, double peso, String destino) {
        this.alto = alto;
        this.ancho = ancho;
        this.profundo = profundo;
        this.peso = peso;
        this.destino = destino;
    }

    public double calcularVolumen() {
        return alto * ancho * profundo;
    }

    public double getPeso() { return peso; }
    public String getDestino() { return destino; }
}
