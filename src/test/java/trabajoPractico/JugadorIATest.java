package trabajoPractico;

import org.junit.Test;

import static org.junit.Assert.*;

public class JugadorIATest {

    @Test
    public void vidaJugador() {
        var jugador = new JugadorIA();
        assertEquals(jugador.getVida(), 20);
    }

    @Test
    public void colocarCartaIA() {
        var partida = new Partida();
        partida.getJugadorIA().colocarCartaIA(partida);
        //Segun la IA deberia colocar la carta en la primer col libre (0)
        assertNotNull(partida.getTablero().getTablero(0,0));
    }

    @Test
    public void colocarCartaIA2() {
        var partida = new Partida();
        partida.getTablero().insertarCarta(0,0, new Carta(TipoDeCarta.HECHICERO));
        partida.getJugadorIA().colocarCartaIA(partida);
        //Deberia colocar en la columna 1
        assertNotNull(partida.getTablero().getTablero(0,1));
    }

    @Test
    public void elegirCartaAtkIA() {
        var partida = new Partida();
        partida.getJugadorIA().getBaraja().add(new Carta(TipoDeCarta.LUCHADOR)); //aseguro que haya una al menos
        assertNotNull(partida.getJugadorIA().elegirCartaAtkIA());
    }

    @Test
    public void atacarIADirecto() {
        var partida = new Partida();
        partida.getJugadorIA().atacarIA(partida, new Carta(TipoDeCarta.HECHICERO));
        assertEquals(14, partida.getJugadorHumano().getVida()); //20 de vida - 6 del hechicero
    }

    @Test
    public void atacarIACarta() {
        var partida = new Partida();
        partida.getTablero().insertarCarta(1,0, new Carta(TipoDeCarta.HECHICERO));
        partida.getJugadorIA().atacarIA(partida, new Carta(TipoDeCarta.LUCHADOR));
        assertNull(partida.getTablero().getTablero(1,0));
    }

}