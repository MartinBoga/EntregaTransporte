package transporte;

import apps.Paquete;

public class Bicicleta extends Transporte {

    private String ciudadPermitida = null;
    private int paquetesTransportados = 0;

    public Bicicleta() {
        super(0.125, 15, 1, 2); // 0.125 m3, 15 kg, solo 1 city, max 2 paquetes
    }

    @Override
    public boolean puedeTransportar(Paquete paquete) {
        if (ciudadPermitida == null) {
            ciudadPermitida = paquete.getDestino();
        }

        if (!paquete.getDestino().equals(ciudadPermitida)) {
            return false;
        }

        if (paquete.getPeso() > PESO_MAXIMO) {
            return false;
        }

        if (paquete.calcularVolumen() > VOLUMEN_MAXIMO) {
            return false;
        }

        if (paquetesTransportados >= MAX_PAQUETES) {
            return false;
        }

        paquetesTransportados++;
        return true;
    }
}
