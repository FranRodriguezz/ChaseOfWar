package trabajoPractico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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


    //Post: nos devuelve un string segun quien gano la partida.
    public String ganador(){
        if(this.jugador.getVida() <= 0)
            return "Gano la maquina";
        else
            return "Ganaste";
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


    //Post: Se realizan los turnos hasta que un jugador pierda sus puntos de vida
    public String jugar() throws IOException {
        int turno = 0;
        while(!finalizada()){
            if(turno == 0){
                turnoJugador();
                turno = 1;
            }
            else{
                turnoMaquina();
                turno = 0;
            }
        }
        return ganador();
    }

    //Post: Realiza las acciones correspondientes del turno del jugador
    public void turnoJugador() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        this.jugador.robarCarta();
        colocarCartaJugador(reader);
        ataqueJugador(reader);
    }

    //Post: coloca la carta del jugador en el tablero
    public void colocarCartaJugador(BufferedReader reader) throws IOException {
        if(this.getTablero().hayEspacioJugador()){
            System.out.println("Ingrese la carta que quiere jugar, del 1 al " + this.jugador.getBaraja().size());
            int carta = Integer.parseInt(reader.readLine());
            System.out.println("Ingrese la posicion (1, 2 o 3)");
            int pos = Integer.parseInt(reader.readLine());
            this.getTablero().insertarCarta(1, pos - 1, this.jugador.getBaraja().get(carta - 1));
        }
    }

    //Post: Realiza el ataque del jugador, correspondientemente a la carta o a la vida de la ia
    public void ataqueJugador(BufferedReader reader) throws IOException {
        String rta = "no";
        int veces;
        if(this.jugador.hayCartaMagiaEnBaraja()){
            System.out.println("Desea jugar carta magia? (si/no)");
            rta = reader.readLine();
            this.jugador.jugarCartaMagia();
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
                this.jugador.atacarCarta(this, carta - 1, objetivo - 1);
                veces--;
            }
            else{
                this.jugador.atacarVida(this, carta - 1);
            }
        }
    }


    //Post: realiza las acciones correspondientes al turno de la IA
    public void turnoMaquina() {
        this.maquina.robarCarta();
        this.maquina.colocarCarta(this);
        this.maquina.ejecutarAtaque(this);
    }

}
