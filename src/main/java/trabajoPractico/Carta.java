package trabajoPractico;


public class Carta {

    private tipoDeCarta tipo;//Luchador, Tanque, Hechicero , magia(x def 0atk 0def)
    private int ataque;
    private int defensa;

    //Pre: El tipo de la carta debe ser Luchador, Tanque, Hechicero o Magia
    //Post: Crea una carta con su tipo correspondiente
    public Carta(tipoDeCarta tipo){
        if(esUnidadValida(tipo)){
            this.tipo = tipo;
            cargarAtkYDef();
        }
        else{
            throw new RuntimeException("Tipo de carta invalido");
        }
    }


    //Pre: -
    //Post: Devuelve la defensa de la carta
    public int getDefensa(){
        return this.defensa;
    }

    //Pre: -
    //Post: Devuelve el atk de la carta
    public int getAtk(){
        return this.ataque;
    }


    //Pre: -
    //Post: Baja la defensa de la carta, si queda en 0 o menor la carta se destruye
    public void bajarDefensa(int danio){
        this.defensa = this.defensa - danio;
    }

    //Pre: La carta debe haber sido creada
    //Post: Devuelve el tipo de carta
    public tipoDeCarta getTipo(){
        return this.tipo;
    }

    //Pre: El tipo de carta debe ser valido
    //Post: Carga el ataque y la defensa de la carta
    private void cargarAtkYDef(){
        switch (this.tipo) {
            case Luchador -> {
                this.ataque = 4;
                this.defensa = 3;
            }
            case Tanque -> {
                this.ataque = 1;
                this.defensa = 6;
            }
            case Hechicero -> {
                this.ataque = 6;
                this.defensa = 1;
            }
            case Magia -> {
                this.ataque = 0;
                this.defensa = 0;
            }
            default -> {
                throw new RuntimeException("Tipo de carta invalido");
            }
        }
    }

    //Pre: -
    //Post: Devuelve true en caso de ser un tipo de carta valido.
    private boolean esUnidadValida(tipoDeCarta tipo){
        return (tipo.toString().equals("Luchador") || tipo.toString().equals("Tanque") ||
                tipo.toString().equals("Hechicero") || tipo.toString().equals("Magia"));
    }

}
