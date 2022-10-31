package trabajoPractico;

public class Carta {
    private String tipoDeCarta;//Luchador, Tanque, Hechicero , magia(x def 0atk 0def)
    private int ataque;
    private int defensa;

    //Pre: El tipo de la carta debe ser Luchador, Tanque, Hechicero o Magia
    //Post: Crea una carta con su tipo correspondiente
    public Carta(String tipo){
        if(esUnidadValida(tipo)){
            loadAtkAndDef(tipo);
            this.tipoDeCarta = tipo;
        }
        else{
            throw new RuntimeException("Tipo de carta invalido");
        }
    }

    //Pre: El tipo de carta debe ser valido
    //Post: Carga el ataque y la defensa de la carta
    private void loadAtkAndDef(String tipo){
        switch (tipo) {
            case "Luchador" -> {
                this.ataque = 4;
                this.defensa = 3;
            }
            case "Tanque" -> {
                this.ataque = 1;
                this.defensa = 6;
            }
            case "Hechicero" -> {
                this.ataque = 6;
                this.defensa = 1;
            }
            default -> { //caso carta magia
                this.ataque = 0;
                this.defensa = 0;
            }
        }
    }

    //Pre: -
    //Post: Devuelve true en caso de ser un tipo de carta valido.
    private boolean esUnidadValida(String tipo){
        return (tipo.equals("Luchador") || tipo.equals("Tanque") ||tipo.equals("Hechicero") ||tipo.equals("Magia"));
    }

}
