package transporte;

import apps.Paquete;

public class Camion extends Transporte {
    private static final double VOLUMEN_MAXIMO = 20; // en m3
    private static final double PESO_MAXIMO = 16000; // en kg (16 ton = 16000 kg)

    @Override
    public boolean puedeTransportar(Paquete paquete) {
        if (paquete.getPeso() > PESO_MAXIMO) {
            return false;
        }

        if (paquete.calcularVolumen() > VOLUMEN_MAXIMO) {
            return false;
        }

        return true;
    }
}