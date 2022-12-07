package trabajoPractico;

import org.junit.Test;

import static org.junit.Assert.*;

public class JugadorHumanoTest {

    @Test
    public void jugarCartaAtk() {
    }

    @Test
    public void vidaJugador() {
        var jugador = new JugadorHumano();
        assertEquals(jugador.getVida(), 20);
    }

    @Test
    public void jugarCartaMagia() {
    }

    @Test
    public void atacarCarta() {
    }

    @Test
    public void atacarVida() {
    }
}