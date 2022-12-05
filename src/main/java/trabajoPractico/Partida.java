package trabajoPractico;

public class Partida {
    private TableroDeJuego tablero;
    private JugadorIA maquina;
    private JugadorHumano jugador;

    //Pre:
    //Post: Crea la partida
    public Partida(){
        this.tablero = new TableroDeJuego();
        this.maquina = new JugadorIA();
        this.jugador = new JugadorHumano();
    }


    //Post: Devuelve true si la partida finalizo
    public boolean finalizada(){
        return (this.jugador.getVida() <= 0 || this.maquina.getVida() <= 0);
    }

    //Post: Devuelve el tablero
    public TableroDeJuego getTablero(){
        return this.tablero;
    }


    //Post: Devuelve el jugador humano
    public JugadorHumano getJugadorHumano(){
        return this.jugador;
    }


    //Post: Devuelve el jugador ia
    public JugadorIA getJugadorIA(){
        return this.maquina;
    }


    //Pre: La fila y la columna deben ser acordes al tamaño del tablero
    //Post: Selecciona una carta del tablero
    public Carta seleccionarCarta(int fila, int col){
        return this.tablero.getTablero(fila,col);
    }
}
