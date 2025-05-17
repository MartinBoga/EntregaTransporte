package transporte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import transporte.Bicicleta;
import apps.Paquete;

public class BicicletaTest {

    private Bicicleta bicicleta;

    @BeforeEach
    public void setUp() {
        bicicleta = new Bicicleta();
    }

    @Test
    public void testPuedeTransportar_PesoMaximo() {
        Paquete paquete = new Paquete(0.5, 0.5, 0.5, 15, "San Justo");
        assertTrue(bicicleta.puedeTransportar(paquete));
    }

    @Test
    public void testPuedeTransportar_VolumenMaximo() {
        Paquete paquete = new Paquete(0.5, 0.5, 0.5, 10, "San Justo"); // volumen = 0.125
        assertTrue(bicicleta.puedeTransportar(paquete));
    }

    @Test
    public void testPuedeTransportar_ExcedePeso() {
        Paquete paquete = new Paquete(0.5, 0.5, 0.5, 20, "San Justo");
        assertFalse(bicicleta.puedeTransportar(paquete));
    }

    @Test
    public void testPuedeTransportar_ExcedeVolumen() {
        Paquete paquete = new Paquete(1, 1, 1, 5, "Ciudad A"); // volumen = 1
        assertFalse(bicicleta.puedeTransportar(paquete));
    }
}
