package transporte;

import apps.Paquete;

public class Automovil extends Transporte {

    private static final double VOLUMEN_MAXIMO = 2; // en m3
    private static final double PESO_MAXIMO = 500; // en kg
    private static final int MAX_CIUDADES = 3; // max 3 ciudades

    private int ciudadesCubiertas = 0; // Nro de ciudades cubiertas por el auto

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

        // Verificar si el automóvil ya cubrió las 3 ciudades
        if (ciudadesCubiertas >= MAX_CIUDADES) {
            return false;
        }

        // Si todo es válido, incrementamos el número de ciudades cubiertas
        ciudadesCubiertas++;
        return true;
    }
}
