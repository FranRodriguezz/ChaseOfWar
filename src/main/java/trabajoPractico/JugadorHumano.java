package trabajoPractico;

public class JugadorHumano extends Jugador{

    //Post: Crea una instancia de jugador humano
    public JugadorHumano() {
        super();
    }

    //Post: Juega una carta magia de la mano
    public void jugarCartaMagia(){

        this.removerCartaMagia();
    }

}
