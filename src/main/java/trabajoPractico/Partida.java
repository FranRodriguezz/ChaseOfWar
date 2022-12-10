package trabajoPractico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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


    //Pre: La fila y la columna deben ser acordes al tamaño del tablero
    //Post: Selecciona una carta del tablero
    public Carta seleccionarCarta(int fila, int col){
        return this.tablero.getTablero(fila,col);
    }


    //Post: Se realizan los turnos hasta que un jugador pierda sus puntos de vida
    public void jugar(int turno) throws IOException {
        if (turno == 0) {
            turnoJugador();
        } else {
            turnoMaquina();
        }
    }


    //Post: Realiza las acciones correspondientes del turno del jugador
    public void turnoJugador() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        this.jugadores[1].robarCarta();
        colocarCartaJugador(reader);
        //ataqueJugador(reader); resolver como jugar con la ui
        reader.close();
    }

    //Post: coloca la carta del jugador en el tablero
    public void colocarCartaJugador(BufferedReader reader) throws IOException {
        if(this.getTablero().hayEspacioJugador()){
            System.out.println("Ingrese la carta que quiere jugar, del 1 al " + (this.jugadores[1].getBaraja().size() - 1));
            int carta = Integer.parseInt(reader.readLine());
            System.out.println("Ingrese la posicion (1, 2 o 3)");
            int pos = Integer.parseInt(reader.readLine());
            this.getTablero().insertarCarta(1, pos - 1, this.jugadores[1].getBaraja().get(carta - 1));
        }
    }

    /*
    //Post: Realiza el ataque del jugador, correspondientemente a la carta o a la vida de la ia
    public void ataqueJugador(BufferedReader reader) throws IOException {
        String rta = "no";
        int veces;
        if(this.jugadores[1].hayCartaMagiaEnBaraja()){
            System.out.println("Desea jugar carta magia? (si/no)");
            rta = reader.readLine();
            this.jugadores[1].jugarCartaMagia();
        }
        if(rta.equals("si")){
            veces = 2;
        }
        else{
            veces = 1;
        }
        while (veces > 0){
            System.out.println("Con que carta atacas? (1, 2 o 3)");
            int carta = Integer.parseInt(reader.readLine());
            if(this.tablero.hayCartaMaquina()){
                System.out.println("A que carta atacas? (1, 2 o 3)");
                int objetivo = Integer.parseInt(reader.readLine());
                this.jugadores[1].atacarCarta(this, carta - 1, objetivo - 1);
            }
            else{
                this.jugadores[1].atacarVida(this, carta - 1);
            }
            veces--;
        }
    }*/


    //Post: realiza las acciones correspondientes al turno de la IA
    public void turnoMaquina() {
        this.jugadores[0].robarCarta();
        this.jugadores[0].colocarCartaIA(this);
        this.jugadores[0].ejecutarAtaqueIA(this);
    }

}
