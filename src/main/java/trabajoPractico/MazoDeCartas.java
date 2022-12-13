package trabajoPractico;

import java.util.Stack;
import java.util.Collections;

public class MazoDeCartas {

    public Stack<Carta> mazo = new Stack<>();

    //Pre: -
    //Post: Crea el mazo con sus unidades correspondientes, ya mezclado el mismo.
    public MazoDeCartas(){
        this.cargarUnidades();
        this.mezclarMazo();
    }

    //Pre: -
    //Post: Carga las unidades en el mazo, 10 cartas por unidad
    private void cargarUnidades(){
        int cantidadCartasPorTipo = 10;
        for(int i = 0; i < cantidadCartasPorTipo; i++){
            this.mazo.push(new Carta(TipoDeCarta.LUCHADOR));
            this.mazo.push(new Carta(TipoDeCarta.TANQUE));
            this.mazo.push(new Carta(TipoDeCarta.HECHICERO));
            this.mazo.push(new Carta(TipoDeCarta.MAGIA));
        }
    }

    //Pre: -
    //Post: Mezcla el mazo
    private void mezclarMazo(){
        Collections.shuffle(this.mazo);
    }
}
