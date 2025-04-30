package com.empresa.transporte.transporte;

import com.empresa.transporte.excepciones.*;
import com.empresa.transporte.modelo.Paquete;
import com.empresa.transporte.modelo.Transporte;

public class Bicicleta extends Transporte {
    private static final int MAX_PAQUETES = 2;
    private static final double MAX_VOLUMEN = 0.125; // m3
    private static final double MAX_PESO = 15.0;      // kg

    @Override
    public void ofrecerPaquete(Paquete paquete) throws Exception {
        if (paquetes.size() >= MAX_PAQUETES) {
            throw new TransporteLleno("La bicicleta ya tiene 2 paquetes.");
        }

        if (paquete.calcularVolumen() > MAX_VOLUMEN) {
            throw new CapacidadExcedida("El volumen del paquete excede lo permitido para bicicleta.");
        }

        if (paquete.getPeso() > MAX_PESO) {
            throw new CapacidadExcedida("El peso del paquete excede lo permitido para bicicleta.");
        }

        if (destinos.isEmpty()) {
            destinos.add(paquete.getDestino());
        } else if (!destinos.get(0).equals(paquete.getDestino())) {
            throw new DestinoNoPermitido("La bicicleta solo puede llevar paquetes al mismo destino.");
        }

        paquetes.add(paquete);
    }
}
