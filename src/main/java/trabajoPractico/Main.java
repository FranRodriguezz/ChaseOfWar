package trabajoPractico;

public class Main {
    public static void main(String[] args) {

        MazoDeCartas mazo = new MazoDeCartas();
        Carta carta = mazo.mazo.pop();
        System.out.println(carta.getTipo().toString());
    }
}