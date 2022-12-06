package trabajoPractico;

public class TableroDeJuego {
    private Carta [][] tablero;
    private final int filaIA = 0;
    private final int filaHumano = 1;
    private final int slotCartas = 3;


    //Pre:
    //Post:
    public TableroDeJuego(){
        this.tablero = new Carta[2][3];
    }

    //Post: Devuelve true si hay espacio para que la IA coloque una carta
    public boolean hayEspacioIA(){
        boolean hay = false;
        for(int i = 0; i < slotCartas; i++){
            if(!this.hayCarta(filaIA, i)){
                hay = true;
            }
        }
        return hay;
    }

    //Pre: La fila y la columna deben ser validos con respecto al tamaño del tablero
    //Post: Devuelve true si hay una carta en el espacio
    public boolean hayCarta(int fila, int col){

        return tablero[fila][col] != null;
    }

    //Pre: La fila y la columna deben ser validas
    //Post: Coloca una carta en el tablero de juego
    public void insertarCarta(int fila, int col, Carta carta){
        this.tablero[fila][col] = carta;
    }

    //Post: Devuelve true si el jugador humano tiene una carta en juego
    public boolean hayCartaJugador(){
        boolean hay = false;
        for(int i = 0; i < slotCartas; i++){
            if(this.hayCarta(filaHumano, i)){
                hay = true;
            }
        }
        return hay;
    }

    //Post: Devuelve true si el jugador IA tiene una carta en juego
    public boolean hayCartaMaquina(){
        boolean hay = false;
        for(int i = 0; i < slotCartas; i++){
            if(this.hayCarta(filaIA, i)){
                hay = true;
            }
        }
        return hay;
    }

    //Post: Devuelve true si hay espacio para que el jugador coloque una carta
    public boolean hayEspacioJugador(){
        int cantCartas = 0;
        for(int i = 0; i < slotCartas; i++){
            if(this.hayCarta(filaHumano, i)){
                cantCartas++;
            }
        }
        return cantCartas < 3;
    }

    //Post: Devuelve la carta que hay en el tablero si la hay
    public Carta getTablero(int fila, int col){
        return this.tablero[fila][col];
    }

    //
    public void eliminarCarta(int fila, int col){
        if (this.tablero[fila][col].getDefensa() <= 0){
            this.tablero[fila][col] = null;
        }
    }
}
