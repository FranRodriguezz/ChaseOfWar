package trabajoPractico;

import java.util.ArrayList;

public abstract class Jugador {
    private int vida;
    private MazoDeCartas mazo;
    private ArrayList<Carta> baraja;
    private final int cartasEnMano = 5;

    //Pre:
    //Post: Constructor de un jugador para usar en las clases hijas
    public Jugador() {
        this.vida = 20;
        this.mazo = new MazoDeCartas();
        this.cargarBarajaInicial();
    }

    //Pre: el mazo debe haber sido creado previamente
    //Post: Carga la baraja de 5 cartas inicial
    private void cargarBarajaInicial(){
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
                i = this.baraja.size();
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

}
