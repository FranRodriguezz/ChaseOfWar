package trabajoPractico;

import java.util.Stack;
import java.util.Collections;

public class MazoDeCartas {

    private final int cantidadCartasPorTipo = 10;
    public Stack<Carta> mazo = new Stack<>();

    //Pre: -
    //Post: Crea el mazo con sus unidades correspondientes, ya mezclado el mismo.
    public MazoDeCartas(){
        this.cargarUnidades();
        this.shuffleDeck();
    }

    //Pre: -
    //Post: Carga las unidades en el mazo, 10 cartas por unidad
    private void cargarUnidades(){
        for(int i = 0; i < cantidadCartasPorTipo; i++){
            this.mazo.push(new Carta("Luchador"));
            this.mazo.push(new Carta("Tanque"));
            this.mazo.push(new Carta("Hechicero"));
            this.mazo.push(new Carta("Juga2"));
        }
    }

    //Pre: -
    //Post: Mezcla el mazo
    private void shuffleDeck(){
        Collections.shuffle(this.mazo);
    }
}
