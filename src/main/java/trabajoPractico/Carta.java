package trabajoPractico;


public class Carta {

    private final TipoDeCarta tipo;//Luchador, Tanque, Hechicero , magia(x def 0atk 0def)


    //Pre: El tipo de la carta debe ser Luchador, Tanque, Hechicero o Magia
    //Post: Crea una carta con su tipo correspondiente
    public Carta(TipoDeCarta tipo){
        this.tipo = tipo;
    }


    //Pre: -
    //Post: Devuelve la defensa de la carta
    public int getDefensa(){
        return this.tipo.getDefensa();
    }

    //Pre: -
    //Post: Devuelve el atk de la carta
    public int getAtk(){
        return this.tipo.getAtaque();
    }


    //Pre: Recibe el danio de la carta que esta atacando a esta
    //Post: Si la carta atacante puede destruirla devuelve true, caso contrario false
    public boolean perdioDuelo(int danio){
        return danio >= this.getDefensa();
    }

    //Pre: La carta debe haber sido creada
    //Post: Devuelve el tipo de carta
    public TipoDeCarta getTipo(){
        return this.tipo;
    }

}
