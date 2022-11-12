package trabajoPractico;

public class JugadorIA extends Jugador{

    //Pre;
    //Post: Crea una instancia de jugador IA
    public JugadorIA(){
        super();
    }

    //Pre:
    //Post:
    public boolean ejecutarAtaque(){
        if(this.hayCartaMagiaEnBaraja()){
            this.removerCartaMagia();
            this.atacar();
            this.atacar();
        }
        else{
            this.atacar();
        }
    }


    //Pre:
    //Post:
    public void atacar(){

    }
}
