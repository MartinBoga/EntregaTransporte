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
