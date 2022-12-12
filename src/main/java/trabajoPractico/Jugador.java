package trabajoPractico;

import java.util.ArrayList;

public abstract class Jugador {
    private int vida;
    private MazoDeCartas mazo;
    private ArrayList<Carta> baraja;

    //Pre:
    //Post: Constructor de un jugador para usar en las clases hijas
    public Jugador() {
        this.vida = 20;
        this.mazo = new MazoDeCartas();
        this.baraja = new ArrayList<>();
        this.cargarBarajaInicial();
    }

    //Pre: el mazo debe haber sido creado previamente
    //Post: Carga la baraja de 5 cartas inicial
    private void cargarBarajaInicial(){
        int cartasEnMano = 5;
        for(int i = 0; i < cartasEnMano; i++){
            this.baraja.add(this.mazo.mazo.pop());
        }
    }

    //Post: Devuelve la vida del jugador
    public int getVida(){
        return this.vida;
    }

    //Pre: el mazo debe haber sido creado previamente
    //Post: roba una carta del mazo y la añade a la baraja
    public void robarCarta(){
        this.baraja.add(this.mazo.mazo.pop());
    }

    //Pre: La instancia jugador debe ser creada previamente
    //Post: Devuelve la baraja del jugador
    public ArrayList<Carta> getBaraja(){
        return this.baraja;
    }

    //Pre: La baraja debe haber sido creada
    //Post: Devuelve true si hay alguna carta para atacar en la baraja
    public boolean hayCartaAtkEnBaraja(){
        boolean hay = false;
        for(int i = 0; i < this.baraja.size(); i++){
            if(this.baraja.get(i).getTipo().esAtaque()){
                hay = true;
                i = this.baraja.size();
            }
        }
        return hay;
    }


    //Pre: La baraja debe haber sido creada
    //Post: Devuelve true si hay alguna carta magia en la baraja
    public boolean hayCartaMagiaEnBaraja(){
        boolean hay = false;
        for(int i = 0; i < this.baraja.size(); i++){
            if (!this.baraja.get(i).getTipo().esAtaque()) {
                hay = true;
                break;
            }
        }
        return hay;
    }

    //Post: Remueve una carta Magia de la baraja
    public void removerCartaMagia(){
        for(int i = 0; i < this.baraja.size(); i++){
            if(this.baraja.get(i).getTipo() == TipoDeCarta.MAGIA){
                this.baraja.remove(i);
                break;
            }
        }
    }

    //Post: Remueve una carta atk de la baraja
    public void removerCartaAtk(TipoDeCarta tipo){
        for(int i = 0; i < this.baraja.size(); i++){
            if(this.baraja.get(i).getTipo() == tipo){
                this.baraja.remove(i);
                i = this.baraja.size();
            }
        }
    }

    //Post: Baja la vida del jugador directamente
    public void bajarVida(int danio){
        this.vida = this.vida - danio;
    }

    public void jugarCartaMagia() {
        this.removerCartaMagia();
    }

    public void colocarCartaIA(Partida partida) {
        for (int i = 0; i < 3; i++) {
            if (!partida.getTablero().hayCarta(0, i)) {
                partida.getTablero().insertarCarta(0, i, this.elegirCartaAtkIA());
                var carta = this.elegirCartaAtkIA();
                this.removerCartaAtk(carta.getTipo());
                break;
            }
        }
    }

    public Carta elegirCartaAtkIA() {
        if (this.hayCartaAtkEnBaraja()) {
            for (int i = 0; i < this.getBaraja().size(); i++) {
                if (this.getBaraja().get(i).getTipo() == TipoDeCarta.LUCHADOR) {
                    return this.getBaraja().get(i);
                } else if (this.getBaraja().get(i).getTipo() == TipoDeCarta.TANQUE) {
                    return this.getBaraja().get(i);
                } else if (this.getBaraja().get(i).getTipo() == TipoDeCarta.HECHICERO) {
                    return this.getBaraja().get(i);
                }
            }
        }
        return null;
    }

    public void ejecutarAtaqueIA(Partida partida) {
        var cartaActual = elegirCartaAtkIA();
        if (this.hayCartaMagiaEnBaraja()) {
            this.removerCartaMagia();
            this.atacarIA(partida, cartaActual);
            this.atacarIA(partida, cartaActual);
        } else {
            this.atacarIA(partida, cartaActual);
        }
    }

    public void atacarIA(Partida partida, Carta cartaActual) {
        if (partida.getTablero().hayCartaJugador()) {
            atacarCartaIA(partida, cartaActual);
        } else {
            atacarDirectoIA(partida, cartaActual);
        }
    }

    private void atacarCartaIA(Partida partida, Carta cartaActual) {
        int nroCartaAAtacar = 0;
        while (nroCartaAAtacar < 2) {
            if (partida.getTablero().hayCarta(1, nroCartaAAtacar)) {
                //var carta = partida.getTablero().getTablero(1, nroCartaAAtacar);
                if(partida.getTablero().getTablero(1, nroCartaAAtacar).perdioDuelo(hacerDanioIA(cartaActual.getTipo()))){
                    partida.getTablero().eliminarCarta(1, nroCartaAAtacar);
                    nroCartaAAtacar = 2;
                }
            } else {
                nroCartaAAtacar++;
            }
        }
    }

    //Post: Devuelve el daño en funcion de la carta
    public int hacerDanioIA(TipoDeCarta tipo) {
        if (tipo == TipoDeCarta.LUCHADOR) {
            return 4;
        } else if (tipo == TipoDeCarta.TANQUE) {
            return 1;
        } else if (tipo == TipoDeCarta.HECHICERO) {
            return 6;
        }
        throw new RuntimeException("Error al hacer danio");
    }

    //Post: Ataca directo al jugador humano
    public void atacarDirectoIA(Partida partida, Carta cartaActual) {
        partida.getJugadorHumano().bajarVida(hacerDanioIA(cartaActual.getTipo()));
    }


    //Pre: la columna debe ser de 0 a 2
    //Post: baja la vida si se ataca directo
    public void atacarVida(Partida partida, int colCarta){
        int danio = partida.getTablero().getTablero(1,colCarta).getAtk();
        partida.getJugadorIA().bajarVida(danio);
    }

}
