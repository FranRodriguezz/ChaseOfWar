package trabajoPractico;


public class Carta {

    private TipoDeCarta tipo;//Luchador, Tanque, Hechicero , magia(x def 0atk 0def)


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


    //Pre: -
    //Post: Baja la defensa de la carta, si queda en 0 o menor la carta se destruye
    public void bajarDefensa(int danio){
        this.tipo.bajarDefensa(danio);
    }

    //Pre: La carta debe haber sido creada
    //Post: Devuelve el tipo de carta
    public TipoDeCarta getTipo(){
        return this.tipo;
    }

}
