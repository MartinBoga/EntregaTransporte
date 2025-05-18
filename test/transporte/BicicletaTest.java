package transporte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import apps.Paquete;

public class BicicletaTest {

    private Bicicleta bicicleta;

    @BeforeEach
    public void setUp() {
        bicicleta = new Bicicleta();
    }

    @Test
    public void testPuedeTransportar_PesoMaximo() {
        Paquete paquete = new Paquete(0.5, 0.5, 0.5, 15, "Ramos mejia"); // 15 kg max todo ok
        assertTrue(bicicleta.puedeTransportar(paquete));
    }

    @Test
    public void testPuedeTransportar_VolumenMaximo() {
        Paquete paquete = new Paquete(0.5, 0.5, 0.5, 10, "Ramos mejia"); // volumen = 0.125 todo ok
        assertTrue(bicicleta.puedeTransportar(paquete));
    }

    @Test
    public void testPuedeTransportar_ExcedePeso() {
        Paquete paquete = new Paquete(0.5, 0.5, 0.5, 15.5, "Ramos mejia"); // peso > 15 kg es false
        assertFalse(bicicleta.puedeTransportar(paquete));
    }

    @Test
    public void testPuedeTransportar_ExcedeVolumen() {
        Paquete paquete = new Paquete(1, 1, 0.126, 5, "Ramos mejia"); // volumen = 0.126 > 0.125 es false
        assertFalse(bicicleta.puedeTransportar(paquete));
    }
    
    @Test
    public void testPuedeTransportar_Solo1Ciudad() {
        assertTrue(bicicleta.puedeTransportar(new Paquete(0.124, 1, 1, 5, "Ramos mejia")));
        // false pq se alcanzaron 2 citys distintas, 2da city no deberia poder
        assertFalse(bicicleta.puedeTransportar(new Paquete(0.1, 0.1, 0.1, 10, "Buenos aires")));
    }
    
    @Test
    public void testPuedeTransportar_MismaCiudad() {
        assertTrue(bicicleta.puedeTransportar(new Paquete(0.124, 1, 1, 5, "Ramos mejia")));
        // true pq es la misma city
        assertTrue(bicicleta.puedeTransportar(new Paquete(0.1, 0.1, 0.1, 10, "Ramos mejia")));
    }
    
    @Test
    public void testPuedeTransportar_Maximo2Paquetes() {
        assertTrue(bicicleta.puedeTransportar(new Paquete(0.1, 1, 0.1, 7, "Ramos mejia")));
        assertTrue(bicicleta.puedeTransportar(new Paquete(0.1, 0.1, 1, 7, "Ramos mejia")));
        // ya no se deberia poder un 3er paquete
        assertFalse(bicicleta.puedeTransportar(new Paquete(0.1, 0.1, 0.1, 0.1, "Ramos mejia")));
    }

    
}
