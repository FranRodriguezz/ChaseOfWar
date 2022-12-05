package trabajoPractico;

public class JugadorHumano extends Jugador{

    //Post: Crea una instancia de jugador humano
    public JugadorHumano() {
        super();
    }


    //pre: La partida debe ser creada previamente y la columna debe ser valida (0 a 2)
    //Post: Juega una carta ataque de la mano y la coloca en el tablero
    public void jugarCartaAtk(Partida partida, TipoDeCarta tipo, int col){
        var carta = new Carta(tipo);
        this.removerCartaAtk(tipo);
        partida.getTablero().insertarCarta(1, col, carta); //fila 1 corresponde a fila del user del tablero
    }

    //Post: Juega una carta magia de la mano
    public void jugarCartaMagia(){
        this.removerCartaMagia();
    }

    //Pre: la columna debe ser de 0 a 2
    //Post:
    public void atacar(Partida partida, int colCarta, int colEnemiga){
        int danio = partida.getTablero().getTablero(1,colCarta).getAtk();
        partida.getTablero().getTablero(0,colEnemiga).bajarDefensa(danio);
    }
}
