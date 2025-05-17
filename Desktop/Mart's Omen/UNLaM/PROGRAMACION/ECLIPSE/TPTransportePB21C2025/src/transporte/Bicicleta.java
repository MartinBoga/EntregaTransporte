package transporte;

import apps.Paquete;

public class Bicicleta extends Transporte {

    private static final double VOLUMEN_MAXIMO = 0.125; // en m3 por paquete, max 2 paquetes
    private static final double PESO_MAXIMO = 15; // en kg

    private int paquetesTransportados = 0; // nro de paquetes transportados

    @Override
    public boolean puedeTransportar(Paquete paquete) {
        // Verificar si el paquete no excede el peso máximo
        if (paquete.getPeso() > PESO_MAXIMO) {
            return false;
        }

        // Verificar si el paquete no excede el volumen máximo
        if (paquete.calcularVolumen() > VOLUMEN_MAXIMO) {
            return false;
        }

        // Verificar si ya lleva 2 paquetes
        if (paquetesTransportados >= 2) {
            return false;
        }

        // Si todo es válido, incrementamos el número de paquetes transportados
        paquetesTransportados++;
        return true;
    }
}
