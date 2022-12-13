package trabajoPractico;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartaTest {

    @Test
    public void getDefensaTanque() {
        var carta = new Carta(TipoDeCarta.TANQUE);
        int defensa = carta.getDefensa();
        assertEquals(defensa, 6);
    }

    @Test
    public void getDefensaLuchador() {
        var carta = new Carta(TipoDeCarta.LUCHADOR);
        int defensa = carta.getDefensa();
        assertEquals(defensa, 3);
    }

    @Test
    public void getDefensaHechicero() {
        var carta = new Carta(TipoDeCarta.HECHICERO);
        int defensa = carta.getDefensa();
        assertEquals(defensa, 1);
    }

    @Test
    public void getAtkTanque() {
        var carta = new Carta(TipoDeCarta.TANQUE);
        int atk = carta.getAtk();
        assertEquals(atk, 1);
    }

    @Test
    public void getAtkLuchador() {
        var carta = new Carta(TipoDeCarta.LUCHADOR);
        int atk = carta.getAtk();
        assertEquals(atk, 4);
    }

    @Test
    public void getAtkHechicero() {
        var carta = new Carta(TipoDeCarta.HECHICERO);
        int atk = carta.getAtk();
        assertEquals(atk, 6);
    }
}