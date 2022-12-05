package trabajoPractico;

public class JugadorIA extends Jugador {

    //Post: Crea una instancia de jugador IA
    public JugadorIA() {
        super();
    }


    //Post: Si hay carta magia la usa y ejecuta dos ataques, si no uno solo
    public void ejecutarAtaque(Partida partida) {
        var cartaActual = elegirCartaAtk();
        if (this.hayCartaMagiaEnBaraja()) {
            this.removerCartaMagia();
            this.atacar(partida, cartaActual);
            this.atacar(partida, cartaActual);
        } else {
            this.atacar(partida, cartaActual);
        }
    }

    //Post: Coloca una carta atk en el tablero
    public void colocarCarta(Partida partida) {
        for (int i = 0; i < 3; i++) {
            if (!partida.getTablero().hayCarta(0, i)) {
                partida.getTablero().insertarCarta(0, i, this.elegirCartaAtk());
                var carta = this.elegirCartaAtk();
                this.removerCartaAtk(carta.getTipo());
            }
        }
    }

    //Post: Elige una carta de ataque para jugar
    public Carta elegirCartaAtk() {
        if (this.hayCartaAtkEnBaraja()) {
            for (int i = 0; i < this.getBaraja().size(); i++) {
                if (this.getBaraja().get(i).getTipo() == TipoDeCarta.LUCHADOR) {
                    return this.getBaraja().get(i);
                } else if (this.getBaraja().get(i).getTipo() == TipoDeCarta.TANQUE) {
                    return this.getBaraja().get(i);
                } else if (this.getBaraja().get(i).getTipo() == TipoDeCarta.HECHICERO) {
                    return this.getBaraja().get(i);
                }
            }
        }
        throw new RuntimeException("Error al elegir carta atk");
    }

    //Post: Cumple funciones de atacar, a una carta o directo
    public void atacar(Partida partida, Carta cartaActual) {
        if (partida.getTablero().hayCartaJugador()) {
            atacarCarta(partida, cartaActual);
        } else {
            atacarDirecto(partida, cartaActual);
        }
    }

    //Post: Ataca la primer carta que el otro jugador tenga en tablero
    private void atacarCarta(Partida partida, Carta cartaActual) {
        int nroCartaAAtacar = 0;
        while (nroCartaAAtacar < 2) {
            if (partida.getTablero().hayCarta(1, nroCartaAAtacar)) {
                //var carta = partida.getTablero().getTablero(1, nroCartaAAtacar);
                partida.getTablero().getTablero(1, nroCartaAAtacar).bajarDefensa(hacerDanio(cartaActual.getTipo()));
            } else {
                nroCartaAAtacar++;
            }
        }
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

    //Post: Ataca directo al jugador humano
    public void atacarDirecto(Partida partida, Carta cartaActual) {
        partida.getJugadorHumano().bajarVida(hacerDanio(cartaActual.getTipo()));
    }
}
