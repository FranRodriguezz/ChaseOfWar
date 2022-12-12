package trabajoPractico;

public enum TipoDeCarta {
    LUCHADOR(4,3),
    TANQUE(1,6),
    HECHICERO(6,1),
    MAGIA(0,0);

    private final int ataque;

    private final int defensa;

    //Pre:
    //Post: Crea un tipo de carta con sus datos de atk y def
    TipoDeCarta(int ataque, int defensa){
        this.ataque = ataque;
        this.defensa = defensa;
    }

    //Post: Devuelve la defensa de la carta
    public int getDefensa(){
        return this.defensa;
    }

    //Post: devuelve el ataque de la carta
    public int getAtaque(){
        return this.ataque;
    }

    //Post: devuelve true si la carta es de ataque
    public boolean esAtaque(){
        return this == TANQUE || this == LUCHADOR || this == HECHICERO;
    }

}
