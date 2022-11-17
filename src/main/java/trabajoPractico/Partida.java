package trabajoPractico;

public class Partida {
    private TableroDeJuego tablero;
    private JugadorIA maquina;
    public JugadorHumano jugador; //de momento queda publico, para la fase 3 cambiaria

    //Pre:
    //Post: Crea la partida
    public Partida(){
        this.tablero = new TableroDeJuego();
        this.maquina = new JugadorIA();
        //this.jugador = new JugadorHumano();
    }


    //Pre:
    //Post: Devuelve el tablero
    public TableroDeJuego getTablero(){
        return this.tablero;
    }

    //Pre: La fila y la columna deben ser acordes al tamaño del tablero
    //Post: Selecciona una carta del tablero
    public Carta seleccionarCarta(int fila, int col){
        return this.tablero.getTablero(fila,col);
    }
}
