package transporte;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import apps.Paquete;

public class AutomovilTest {

    private Automovil auto;

    @BeforeEach
    public void setUp() {
        auto = new Automovil();
    }


    @Test
    public void testPuedeTransportar_ExcedeVolumen() {
        assertTrue(auto.puedeTransportar(new Paquete(1, 1, 1, 200, "Ramos mejia"))); // 1 m3, peso ok
        assertTrue(auto.puedeTransportar(new Paquete(1, 1, 1, 200, "Ramos mejia"))); // 2 m3 acumulado
        // sgte excede 2.01m3 acumulados
        assertFalse(auto.puedeTransportar(new Paquete(0.1, 1, 1, 200, "Ramos mejia")));
    }

    @Test
    public void testPuedeTransportar_ExcedePeso() {
        assertTrue(auto.puedeTransportar(new Paquete(0.5, 1, 1, 250, "Ramos mejia"))); // 0.5 m3, 250 kg
        assertTrue(auto.puedeTransportar(new Paquete(0.5, 1, 1, 200, "Ramos mejia"))); // 1 m3, 450kg total
        // sgte 2 m3 pero el peso excede los 500kg
        assertFalse(auto.puedeTransportar(new Paquete(1, 1, 1, 50.1, "Ramos mejia")));
    }

    @Test
    public void testPuedeTransportar_Maximo3Ciudades() {
        assertTrue(auto.puedeTransportar(new Paquete(0.1, 1, 1, 100, "Ramos mejia")));
        assertTrue(auto.puedeTransportar(new Paquete(0.5, 1, 1, 100, "La plata")));
        assertTrue(auto.puedeTransportar(new Paquete(1, 1, 1, 100, "Rosario")));
        // false pq se alcanzaron 3 destinos distintos, 4ta city no deberia poder
        assertFalse(auto.puedeTransportar(new Paquete(0.1, 1, 1, 100, "Buenos aires")));
    }
    
	@Test
	public void testPuedeTransportar_DestinoRepetido() {
		assertTrue(auto.puedeTransportar(new Paquete(0.1, 1, 1, 100, "Ramos mejia")));
		assertTrue(auto.puedeTransportar(new Paquete(1, 0.5, 1, 200, "Ramos mejia"))); // repetida 1
		assertTrue(auto.puedeTransportar(new Paquete(1, 1, 1, 200, "Ramos mejia"))); // repetida 2
	}
}
