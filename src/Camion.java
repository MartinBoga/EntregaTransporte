package com.empresa.transporte.transporte;

import com.empresa.transporte.excepciones.CapacidadExcedida;
import com.empresa.transporte.modelo.Paquete;
import com.empresa.transporte.modelo.Transporte;

public class Camion extends Transporte {
    private static final double MAX_VOLUMEN = 20.0;    // m3
    private static final double MAX_PESO = 16000.0;    // kg (16 toneladas)

    @Override
    public void ofrecerPaquete(Paquete paquete) throws Exception {
        double nuevoVolumen = getVolumenTotal() + paquete.calcularVolumen();
        double nuevoPeso = getPesoTotal() + paquete.getPeso();

        if (nuevoVolumen > MAX_VOLUMEN) {
            throw new CapacidadExcedida("El volumen total excede lo permitido para el camión.");
        }

        if (nuevoPeso > MAX_PESO) {
            throw new CapacidadExcedida("El peso total excede lo permitido para el camión.");
        }

        if (!destinos.contains(paquete.getDestino())) {
            destinos.add(paquete.getDestino());
        }

        paquetes.add(paquete);
    }
}
