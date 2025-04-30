package com.empresa.transporte;

import com.empresa.transporte.modelo.Paquete;
import com.empresa.transporte.transporte.Bicicleta;

public class Main {
    public static void main(String[] args) {
        Paquete paquete1 = new Paquete(0.3, 0.5, 0.8, 10, "Ciudad A");
        Paquete paquete2 = new Paquete(0.25, 0.2, 0.9, 12, "Ciudad A");

        Bicicleta bici = new Bicicleta();

        try {
            bici.ofrecerPaquete(paquete1);
            bici.ofrecerPaquete(paquete2);
            // Esto debería fallar porque ya lleva 2 paquetes
            bici.ofrecerPaquete(new Paquete(0.2, 0.2, 0.2, 5, "Ciudad A"));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
