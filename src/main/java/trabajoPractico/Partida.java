package trabajoPractico;

public class Partida {
    private TableroDeJuego tablero;

    private Jugador[] jugadores;

    //Pre:
    //Post: Crea la partida
    public Partida(){
        this.tablero = new TableroDeJuego();
        this.jugadores = new Jugador[2];
        this.jugadores[0] = new JugadorIA();
        this.jugadores[1] = new JugadorHumano();
    }

    //Post: Devuelve true si la partida finalizo
    public boolean finalizada(){
        return (this.jugadores[0].getVida() <= 0 || this.jugadores[1].getVida() <= 0);
    }

    //Post: Devuelve el tablero
    public TableroDeJuego getTablero(){
        return this.tablero;
    }

    //Post: Devuelve el jugador humano
    public Jugador getJugadorHumano(){
        return this.jugadores[1];
    }

    //Post: Devuelve el jugador ia
    public Jugador getJugadorIA(){
        return this.jugadores[0];
    }

    public String ganador(){
        if(this.getJugadorIA().getVida() <= 0){
            return "GANASTE :)";
        }
        else if(this.getJugadorHumano().getVida() <= 0){
            return "PERDISTE :(";
        }
        return null;
    }
}
