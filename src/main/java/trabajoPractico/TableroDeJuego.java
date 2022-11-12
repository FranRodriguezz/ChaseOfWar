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

    //Pre:
    //Post:
    public boolean hayEspacioIA(){
        boolean hay = false;
        for(int i = 0; i < slotCartas; i++){
            if(this.hayCarta(filaIA, i)){
                hay = true;
            }
        }
        return hay;
    }

    //Pre: La fila y la columna deben ser validos con respecto al tamaño del tablero
    //Post: Devuelve true si hay una carta en el espacio
    public boolean hayCarta(int fila, int col){
        return !(tablero[fila][col].equals(null)); //ver
    }
}
