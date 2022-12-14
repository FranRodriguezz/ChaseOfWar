package trabajoPractico;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartidaTest {

    @Test
    public void finalizada() {
        var partida = new Partida();
        partida.getJugadorHumano().bajarVida(20);
        assertTrue(partida.finalizada());
    }

    @Test
    public void noFinalizada() {
        var partida = new Partida();
        partida.getJugadorHumano().bajarVida(10);
        assertFalse(partida.finalizada());
    }

}