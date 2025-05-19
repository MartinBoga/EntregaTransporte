package transporte;

import apps.Paquete;
import java.util.HashSet;
import java.util.Set;

public class Automovil extends Transporte {

    private double pesoActual = 0;
    private double volumenActual = 0;
    private Set<String> destinos = new HashSet<>();

    public Automovil() {
        super(2, 500, 3, Integer.MAX_VALUE); // 2 m3, 500 kg, 3 citys, sin limite paquetes
    }

    @Override
    public boolean puedeTransportar(Paquete paquete) {
        double nuevoPeso = pesoActual + paquete.getPeso();
        double nuevoVolumen = volumenActual + paquete.calcularVolumen();
        String destino = paquete.getDestino();

        if (nuevoPeso > PESO_MAXIMO || nuevoVolumen > VOLUMEN_MAXIMO) {
            return false;
        }

        if (!destinos.contains(destino) && destinos.size() >= MAX_CIUDADES) {
            return false;
        }

        // Todo ok: se actualizan los acumuladores y destinos
        pesoActual = nuevoPeso;
        volumenActual = nuevoVolumen;
        destinos.add(destino);
        return true;
    }
}
