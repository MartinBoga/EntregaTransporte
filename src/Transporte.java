package com.empresa.transporte.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Transporte {
    protected List<Paquete> paquetes = new ArrayList<>();
    protected List<String> destinos = new ArrayList<>();

    public abstract void ofrecerPaquete(Paquete paquete) throws Exception;

    protected double getVolumenTotal() {
        return paquetes.stream().mapToDouble(Paquete::calcularVolumen).sum();
    }

    protected double getPesoTotal() {
        return paquetes.stream().mapToDouble(Paquete::getPeso).sum();
    }
}
