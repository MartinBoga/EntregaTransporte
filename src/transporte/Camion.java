package transporte;

import apps.Paquete;

public class Camion extends Transporte {
    public Camion() {
        super(20, 16000, -1, -1); // 20 m3, 16000 kg, -1 pq no hay limites para citys ni paquetes
    }

    @Override
    public boolean puedeTransportar(Paquete paquete) {
        return paquete.getPeso() <= this.PESO_MAXIMO && paquete.calcularVolumen() <= this.VOLUMEN_MAXIMO;
    }
}

/*package transporte;

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
}*/