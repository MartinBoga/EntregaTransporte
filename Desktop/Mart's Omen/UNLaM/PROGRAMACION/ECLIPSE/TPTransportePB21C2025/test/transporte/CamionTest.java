package transporte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import transporte.Camion;
import apps.Paquete;

public class CamionTest {

    private Camion camion;

    @BeforeEach
    public void setUp() {
        camion = new Camion();
    }

    @Test
    public void testPuedeTransportar_PesoLimite() {
        Paquete paquete = new Paquete(2, 2, 2, 16000, "Ciudad X"); // 8 m³
        assertTrue(camion.puedeTransportar(paquete));
    }

    @Test
    public void testPuedeTransportar_ExcedePeso() {
        Paquete paquete = new Paquete(2, 2, 2, 17000, "Ciudad X");
        assertFalse(camion.puedeTransportar(paquete));
    }

    @Test
    public void testPuedeTransportar_ExcedeVolumen() {
        Paquete paquete = new Paquete(10, 2, 1.5, 1000, "Ciudad X"); // volumen = 30
        assertFalse(camion.puedeTransportar(paquete));
    }
}
