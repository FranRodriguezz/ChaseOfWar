package trabajoPractico;

import org.junit.Test;

import static org.junit.Assert.*;

public class TableroDeJuegoTest {

    @Test
    public void hayEspacioIA() {
        var tablero = new TableroDeJuego();
        boolean hay = tablero.hayEspacioIA();
        assertTrue(hay);
    }

    @Test
    public void hayCarta() {
        var tablero = new TableroDeJuego();
        boolean hay = tablero.hayCarta(1,2);
        assertFalse(hay);
    }

    @Test
    public void hayCartaJugador() {
        var tablero = new TableroDeJuego();
        boolean hay = tablero.hayCartaJugador();
        assertFalse(hay);
        var carta = new Carta(TipoDeCarta.HECHICERO);
        tablero.insertarCarta(1,2,carta);
        hay = tablero.hayCartaJugador();
        assertTrue(hay);
    }

}