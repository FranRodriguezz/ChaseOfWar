package trabajoPractico;

public class JugadorIA extends Jugador {

    //Post: Crea una instancia de jugador IA
    public JugadorIA() {
        super();
    }

    //Post: Devuelve el daño en funcion de la carta
    public int hacerDanio(TipoDeCarta tipo) {
        if (tipo == TipoDeCarta.LUCHADOR) {
            return 4;
        } else if (tipo == TipoDeCarta.TANQUE) {
            return 1;
        } else if (tipo == TipoDeCarta.HECHICERO) {
            return 6;
        }
        throw new RuntimeException("Error al hacer danio");
    }

}
