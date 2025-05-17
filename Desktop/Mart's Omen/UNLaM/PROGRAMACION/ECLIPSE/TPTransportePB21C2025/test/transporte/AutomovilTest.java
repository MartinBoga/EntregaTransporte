package transporte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import transporte.Automovil;
import apps.Paquete;

public class AutomovilTest {

    private Automovil auto;

    @BeforeEach
    public void setUp() {
        auto = new Automovil();
    }

    @Test
    public void testPuedeTransportar_DestinoUnico() {
        Paquete paquete = new Paquete(1, 1, 1, 100, "Ciudad A");
        assertTrue(auto.puedeTransportar(paquete));
    }

    @Test
    public void testPuedeTransportar_DestinosNoRepetidos() {
        auto.puedeTransportar(new Paquete(1, 1, 1, 100, "Ciudad A"));
        auto.puedeTransportar(new Paquete(1, 1, 1, 100, "Ciudad B"));
        auto.puedeTransportar(new Paquete(1, 1, 1, 100, "Ciudad C"));
        // Este debería fallar porque ya tiene 3 destinos distintos
        assertFalse(auto.puedeTransportar(new Paquete(1, 1, 1, 100, "Ciudad D")));
    }

    @Test
    public void testPuedeTransportar_ExcedeVolumen() {
        Paquete paquete = new Paquete(2, 1, 1, 200, "Ciudad A"); // volumen = 2
        auto.puedeTransportar(paquete);
        // siguiente paquete excede 2m³
        assertFalse(auto.puedeTransportar(new Paquete(1, 1, 1, 100, "Ciudad A")));
    }

    @Test
    public void testPuedeTransportar_ExcedePeso() {
        Paquete paquete = new Paquete(1, 1, 1, 450, "Ciudad A");
        auto.puedeTransportar(paquete);
        // siguiente paquete excede 500 kg
        assertFalse(auto.puedeTransportar(new Paquete(1, 1, 1, 100, "Ciudad A")));
    }
}
