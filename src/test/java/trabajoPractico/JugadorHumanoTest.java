package trabajoPractico;

import org.junit.Test;

import static org.junit.Assert.*;

public class JugadorHumanoTest {

    @Test
    public void vidaJugador() {
        var jugador = new JugadorHumano();
        assertEquals(jugador.getVida(), 20);
    }

    @Test
    public void jugarCartaMagia() {
        var jugador = new JugadorHumano();
        int cartas = jugador.getBaraja().size();
        jugador.jugarCartaMagia();
        assertEquals(cartas - 1, jugador.getBaraja().size());
    }

    @Test
    public void atacarVida() {
        var partida = new Partida();
        var carta = new Carta(TipoDeCarta.LUCHADOR);
        partida.getTablero().insertarCarta(1, 0, carta);
        partida.getJugadorHumano().atacarVida(partida, 0);
        assertEquals(partida.getJugadorIA().getVida(), 20 - carta.getAtk());
    }

    @Test
    public void hayCartaMagia() {
        var jugador = new JugadorHumano();
        jugador.getBaraja().add(new Carta(TipoDeCarta.MAGIA));
        assertTrue(jugador.hayCartaMagiaEnBaraja());
    }

}