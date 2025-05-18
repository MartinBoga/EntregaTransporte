package transporte;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import apps.Paquete;

public class CamionTest {

    private Camion camion;

    @BeforeEach
    public void setUp() {
        camion = new Camion();
    }

    @Test
    public void testPuedeTransportar_PesoLimite() {
        Paquete paquete = new Paquete(2, 2, 2, 16000, "San justo"); // 8m3 y 16000 kg todo ok true
        assertTrue(camion.puedeTransportar(paquete));
    }

    @Test
    public void testPuedeTransportar_ExcedePeso() {
        assertFalse(camion.puedeTransportar(new Paquete(2, 2, 2, 16001, "San justo"))); // sobre el limite
    }

    @Test
    public void testPuedeTransportar_ExcedeVolumen() {
        assertFalse(camion.puedeTransportar(new Paquete(5, 2, 2.01, 1000, "San justo"))); // max 20 m3
        // total 5*2*2.01 = 20.1 > 20 m3 deberia ser false
    }
}
