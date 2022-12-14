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

    @Test
    public void insertarCarta() {
        var tablero = new TableroDeJuego();
        tablero.insertarCarta(0,0, new Carta(TipoDeCarta.LUCHADOR));
        assertEquals(tablero.getTablero(0,0).getTipo(), TipoDeCarta.LUCHADOR);
    }

    @Test
    public void eliminarCarta() {
        var tablero = new TableroDeJuego();
        tablero.insertarCarta(0,0, new Carta(TipoDeCarta.LUCHADOR));
        tablero.eliminarCarta(0,0);
        assertNull(tablero.getTablero(0, 0));
    }
}