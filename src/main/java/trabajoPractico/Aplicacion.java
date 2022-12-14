package trabajoPractico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Chase of war");
        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        Partida partida = new Partida();
        crearUI(partida, vbox);
        Scene scene = new Scene(vbox, 1300, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Crea la UI completa del juego y funciones de los botones de ataque
    private void crearUI(Partida partida, VBox vbox) throws FileNotFoundException {

        if(partida.finalizada()){
            var msjFinal = new Label(partida.ganador());
            vbox.getChildren().clear();
            vbox.getChildren().add(msjFinal);
            return;
        }

        //Boton atacar vida, y vida enemiga:
        HBox vidaIA = new HBox(2);
        Label barraVidaIA = new Label("Vida IA: " + partida.getJugadorIA().getVida());
        Button btnAtk = new Button("Atacar");
        vidaIA.setAlignment(Pos.CENTER);
        vidaIA.setSpacing(50);
        vidaIA.getChildren().addAll(barraVidaIA, btnAtk);
        vbox.getChildren().add(vidaIA);

        UIenemiga(partida, vbox);

        //Botones atk:
        HBox botonesAtk = new HBox(3);
        botonesAtk.setAlignment(Pos.CENTER);
        botonesAtk.setSpacing(115);
        Button btnAtk1 = new Button("Atacar");
        Button btnAtk2 = new Button("Atacar");
        Button btnAtk3 = new Button("Atacar");
        botonesAtk.getChildren().add(btnAtk1);
        botonesAtk.getChildren().add(btnAtk2);
        botonesAtk.getChildren().add(btnAtk3);
        vbox.getChildren().add(botonesAtk);
        final int[] danio = new int[1];

        UIusuario(partida, vbox, danio);

        btnAtk1.setOnAction(actionEvent -> {
            if(partida.getTablero().getTablero(0, 0).perdioDuelo(danio[0])){
                partida.getTablero().eliminarCarta(0,0);
                vbox.getChildren().clear();
                try {
                    crearUI(partida, vbox);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnAtk2.setOnAction(actionEvent -> {
            if(partida.getTablero().getTablero(0, 1).perdioDuelo(danio[0])){
                partida.getTablero().eliminarCarta(0,1);
                vbox.getChildren().clear();
                try {
                    crearUI(partida, vbox);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnAtk3.setOnAction(actionEvent -> {
            if(partida.getTablero().getTablero(0, 2).perdioDuelo(danio[0])){
                partida.getTablero().eliminarCarta(0,2);
                vbox.getChildren().clear();
                try {
                    crearUI(partida, vbox);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnAtk.setOnAction(actionEvent -> {
            partida.getJugadorIA().bajarVida(danio[0]);
            vbox.getChildren().clear();
            try {
                crearUI(partida, vbox);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    //Crea la UI del usuario completa y le da funcionalidad a los botones de colocar cartas y de Cambiar turno
    private void UIusuario(Partida partida, VBox vbox, int[] danio) throws FileNotFoundException {

        //tablero user:
        HBox tableroUsuario = new HBox(3);
        colocarTablero(partida, tableroUsuario, 1, danio);
        vbox.getChildren().add(tableroUsuario);

        //botones ubicacion:
        HBox botonesUbicacion = new HBox(3);
        botonesUbicacion.setAlignment(Pos.CENTER);
        botonesUbicacion.setSpacing(125);
        Button btnCol1 = new Button("Col1");
        Button btnCol2 = new Button("Col2");
        Button btnCol3 = new Button("Col3");
        botonesUbicacion.getChildren().add(btnCol1);
        botonesUbicacion.getChildren().add(btnCol2);
        botonesUbicacion.getChildren().add(btnCol3);
        vbox.getChildren().add(botonesUbicacion);

        //cartas usuario:
        HBox hboxJugador = new HBox(partida.getJugadorHumano().getBaraja().size());
        colocarCartasUsuario(partida, hboxJugador);
        vbox.getChildren().add(hboxJugador);

        //botones cartas:
        HBox botonesCartas = new HBox(partida.getJugadorHumano().getBaraja().size());
        botonesCartas.setAlignment(Pos.CENTER);
        botonesCartas.setSpacing(60);
        vbox.getChildren().add(botonesCartas);

        //Boton sig turno y vida usuario:
        HBox vida = new HBox(2);
        Label barraVida = new Label("Vida Jugador: " + partida.getJugadorHumano().getVida());
        Button btnTurno = new Button("Sig Turno");
        vida.setAlignment(Pos.CENTER);
        vida.setSpacing(50);
        vida.getChildren().addAll(barraVida, btnTurno);
        vbox.getChildren().add(vida);

        final Carta[] carta = new Carta[1];
        colocarBotonesCartas(partida, botonesCartas, carta);

        //acciones botones colocar:
        btnCol1.setOnAction(actionEvent -> {
            partida.getTablero().insertarCarta(1, 0, carta[0]);
            vbox.getChildren().clear();
            try {
                crearUI(partida, vbox);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        btnCol2.setOnAction(actionEvent -> {
            partida.getTablero().insertarCarta(1, 1, carta[0]);
            vbox.getChildren().clear();
            try {
                crearUI(partida, vbox);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        btnCol3.setOnAction(actionEvent -> {
            partida.getTablero().insertarCarta(1, 2, carta[0]);
            vbox.getChildren().clear();
            try {
                crearUI(partida, vbox);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        btnTurno.setOnAction(actionEvent -> {
            partida.getJugadorIA().robarCarta();
            partida.getJugadorIA().colocarCartaIA(partida);
            partida.getJugadorIA().ejecutarAtaqueIA(partida);
            partida.getJugadorHumano().robarCarta();
            vbox.getChildren().clear();
            try {
                crearUI(partida, vbox);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    //Coloca los botones de las cartas y les da uso
    private void colocarBotonesCartas(Partida partida, HBox botonesCartas, Carta[] carta){
        for(int i = 0; i < partida.getJugadorHumano().getBaraja().size(); i++){
            Button btn = new Button(partida.getJugadorHumano().getBaraja().get(i).getTipo().toString());
            botonesCartas.getChildren().add(btn);
            int finalI = i;
            btn.setOnAction(actionEvent -> {
                if(partida.getJugadorHumano().getBaraja().get(finalI).getTipo() == TipoDeCarta.MAGIA){
                    partida.getJugadorHumano().removerCartaMagia();
                }
                else{
                    carta[0] = new Carta(partida.getJugadorHumano().getBaraja().get(finalI).getTipo());
                    partida.getJugadorHumano().removerCartaAtk(partida.getJugadorHumano().getBaraja().get(finalI).getTipo());
                }
            });
        }
    }

    //Crea la Ui enemiga
    private void UIenemiga(Partida partida, VBox vbox) throws FileNotFoundException {
        //cartas enemigas:
        HBox hboxIA = new HBox(partida.getJugadorIA().getBaraja().size());
        colocarCartasEnemigas(partida, hboxIA);
        vbox.getChildren().add(hboxIA);

        //tablero enemigo:
        HBox tableroIA = new HBox(3);
        final int[] danio = new int[1];
        colocarTablero(partida, tableroIA, 0, danio);
        vbox.getChildren().add(tableroIA);
    }


    //Coloca las cartas del enemigo(se ve el reverso nada mas)
    private void colocarCartasEnemigas(Partida partida, HBox hboxIA) throws FileNotFoundException {
        Image image = new Image(new FileInputStream("src/main/resources/Reverso.jpg"));
        for(int i = 0; i < partida.getJugadorIA().getBaraja().size(); i++){
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(80);
            imageView.setFitWidth(60);
            var label = new Group(imageView);
            hboxIA.setAlignment(Pos.CENTER);
            hboxIA.setSpacing(60);
            hboxIA.getChildren().add(label);
        }
    }


    //Coloca el tablero de algun jugador segun el nro de fila (0 o 1)
    private void colocarTablero(Partida partida, HBox hBox, int filaTarget, int[] danio) throws FileNotFoundException {
        Image image;
        for(int i = 0; i < 3; i++){
            if(partida.getTablero().getTablero(filaTarget, i) == null){
                image = new Image(new FileInputStream("src/main/resources/Vacio.jpg"));
            }
            else{
                image = cargarImagen(partida, filaTarget, i);
            }
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(80);
            imageView.setFitWidth(60);
            var group = new Group(imageView);
            int finalI = i;
            group.setOnMouseClicked(mouseEvent -> danio[0] = partida.getTablero().getTablero(filaTarget, finalI).getAtk());
            hBox.setAlignment(Pos.CENTER);
            hBox.setSpacing(100);
            hBox.getChildren().add(group);
        }
    }

    //Carga la imagen de las cartas del tablero
    private Image cargarImagen(Partida partida, int filaTarget, int col) throws FileNotFoundException {
        Image image = null;
        switch (partida.getTablero().getTablero(filaTarget, col).getTipo()){
            case LUCHADOR ->
                image = new Image(new FileInputStream("src/main/resources/Luchador.jpg"));
            case TANQUE ->
                image = new Image(new FileInputStream("src/main/resources/Tanque.jpg"));
            case HECHICERO ->
                image = new Image(new FileInputStream("src/main/resources/Hechicero.jpg"));
        }
        return image;
    }

    //Coloca las cartas de la baraja del usuario
    private void colocarCartasUsuario(Partida partida, HBox hbox) throws FileNotFoundException {
        for(int i = 0; i < partida.getJugadorHumano().getBaraja().size(); i++){
            var group = asignarCartaUsuario(partida.getJugadorHumano().getBaraja().get(i).getTipo());
            hbox.setAlignment(Pos.CENTER);
            hbox.setSpacing(60);
            hbox.getChildren().add(group);
        }
    }

    //Asigna imagenes a la baraja del usuario
    private Group asignarCartaUsuario(TipoDeCarta tipo) throws FileNotFoundException {
        Image image = null;
        Group root;
        switch (tipo){
            case LUCHADOR ->
                image = new Image(new FileInputStream("src/main/resources/Luchador.jpg"));
            case TANQUE ->
                image = new Image(new FileInputStream("src/main/resources/Tanque.jpg"));
            case HECHICERO ->
                image = new Image(new FileInputStream("src/main/resources/Hechicero.jpg"));
            case MAGIA ->
                image = new Image(new FileInputStream("src/main/resources/Magia.jpg"));
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(80);
        imageView.setFitWidth(60);
        root = new Group(imageView);
        return root;
    }
}
