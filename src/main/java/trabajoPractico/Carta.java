package trabajoPractico;

public class Carta {
    private String tipoDeCarta;//Luchador, Tanque, Hechicero , magia(x def 0atk 0def)
    private int ataque;
    private int defensa;


    public Carta(String tipo){
        loadAtkAndDef(tipo);
        this.tipoDeCarta = tipo;
    }

    private void loadAtkAndDef(String tipo){
        switch (tipo){
            case "Luchador":
                this.ataque = 3;
                this.defensa = 3;
                break;
            case "Tanque":
                this.ataque = 0;
                this.defensa = 6;
                break;
            case "Hechicero":
                this.ataque = 6;
                this.defensa = 0;
                break;
            default: //caso carta magia
                this.ataque = 0;
                this.defensa = 0;
        }
    }



}
