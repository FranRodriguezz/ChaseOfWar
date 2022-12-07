package trabajoPractico;

public enum TipoDeCarta {
    LUCHADOR(4,3),
    TANQUE(1,6),
    HECHICERO(6,1),
    MAGIA(0,0);

    private int ataque;

    private int defensa;

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

    //Post:
    public void setDefensa(int nuevaDef){
        this.defensa = nuevaDef;
    }

    //Post: devuelve true si la carta es de ataque
    public boolean esAtaque(){
        boolean es = false;
        if(this == TANQUE || this == LUCHADOR || this == HECHICERO)
            es = true;
        return es;
    }

}
