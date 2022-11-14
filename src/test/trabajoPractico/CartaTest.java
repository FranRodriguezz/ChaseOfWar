package trabajoPractico;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartaTest {

    @Test
    public void getDefensaTanque() {
        var carta = new Carta(tipoDeCarta.Tanque);
        int defensa = carta.getDefensa();
        assertEquals(defensa, 6);
    }

    @Test
    public void getDefensaLuchador() {
        var carta = new Carta(tipoDeCarta.Luchador);
        int defensa = carta.getDefensa();
        assertEquals(defensa, 3);
    }

    @Test
    public void getDefensaHechicero() {
        var carta = new Carta(tipoDeCarta.Hechicero);
        int defensa = carta.getDefensa();
        assertEquals(defensa, 1);
    }

    @Test
    public void bajarDefensaLuchador() {
        var carta = new Carta(tipoDeCarta.Luchador);
        carta.bajarDefensa(1);
        assertEquals(carta.getDefensa(), 2);
    }

    @Test
    public void bajarDefensaTanque() {
        var carta = new Carta(tipoDeCarta.Tanque);
        carta.bajarDefensa(1);
        assertEquals(carta.getDefensa(), 5);
    }

    @Test
    public void bajarDefensaHechicero() {
        var carta = new Carta(tipoDeCarta.Hechicero);
        carta.bajarDefensa(1);
        assertEquals(carta.getDefensa(), 0);
    }
}