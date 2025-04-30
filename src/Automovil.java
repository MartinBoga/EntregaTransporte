package com.empresa.transporte.transporte;

import com.empresa.transporte.excepciones.*;
import com.empresa.transporte.modelo.Paquete;
import com.empresa.transporte.modelo.Transporte;

public class Automovil extends Transporte {
    private static final double MAX_VOLUMEN = 2.0;    // m3
    private static final double MAX_PESO = 500.0;     // kg
    private static final int MAX_CIUDADES = 3;

    @Override
    public void ofrecerPaquete(Paquete paquete) throws Exception {
        double nuevoVolumen = getVolumenTotal() + paquete.calcularVolumen();
        double nuevoPeso = getPesoTotal() + paquete.getPeso();

        if (nuevoVolumen > MAX_VOLUMEN) {
            throw new CapacidadExcedida("El volumen total excede lo permitido para el automovil.");
        }

        if (nuevoPeso > MAX_PESO) {
            throw new CapacidadExcedida("El peso total excede lo permitido para el automovil.");
        }

        if (!destinos.contains(paquete.getDestino())) {
            if (destinos.size() >= MAX_CIUDADES) {
                throw new DestinoNoPermitido("No se puede agregar un nuevo destino. Limite de 3 ciudades.");
            }
            destinos.add(paquete.getDestino());
        }

        paquetes.add(paquete);
    }
}
