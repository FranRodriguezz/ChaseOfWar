package trabajoPractico;

import java.util.ArrayList;

public abstract class Jugador {
    private int vida;
    private MazoDeCartas mazo;
    private ArrayList<Carta> baraja;
    private final int cartasEnMano = 5;

    //Pre:
    //Post: Constructor de un jugador para usar en las clases hijas
    public Jugador() {
        this.vida = 20;
        this.mazo = new MazoDeCartas();
        this.cargarBarajaInicial();
    }

    //Pre: el mazo debe haber sido creado previamente
    //Post: Carga la baraja de 5 cartas inicial
    private void cargarBarajaInicial(){
        for(int i = 0; i < cartasEnMano; i++){
            this.baraja.add(this.mazo.mazo.pop());
        }
    }

    //Pre:el mazo debe haber sido creado previamente
    //Post: roba una carta del mazo y la añade a la baraja
    public void robarCarta(){
        this.baraja.add(this.mazo.mazo.pop());
    }
}
