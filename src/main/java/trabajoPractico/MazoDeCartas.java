package trabajoPractico;

import java.util.Stack;


public class MazoDeCartas {

    private final int cantidadCartas = 40;
    private final int cantidadCartasPorTipo = 10;
    public Stack<Carta> mazo = new Stack<>();

    public MazoDeCartas(){
        this.cargarUnidades();
    }

    private void cargarUnidades(){
        for(int i = 0; i < cantidadCartasPorTipo; i++){
            mazo.push(new Carta("Luchador"));
            mazo.push(new Carta("Tanque"));
            mazo.push(new Carta("Hechicero"));
            mazo.push(new Carta("Juga2"));
        }
    }



}
