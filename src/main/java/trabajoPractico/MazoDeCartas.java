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
        this.mezclarMazo();
    }

    //Pre: -
    //Post: Carga las unidades en el mazo, 10 cartas por unidad
    private void cargarUnidades(){
        for(int i = 0; i < cantidadCartasPorTipo; i++){
            this.mazo.push(new Carta(tipoDeCarta.Luchador));
            this.mazo.push(new Carta(tipoDeCarta.Tanque));
            this.mazo.push(new Carta(tipoDeCarta.Hechicero));
            this.mazo.push(new Carta(tipoDeCarta.Magia));
        }
    }

    //Pre: -
    //Post: Mezcla el mazo
    private void mezclarMazo(){
        Collections.shuffle(this.mazo);
    }
}
