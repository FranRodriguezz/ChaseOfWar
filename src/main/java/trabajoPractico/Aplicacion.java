package trabajoPractico;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
        vbox.setSpacing(35);
        vbox.setAlignment(Pos.CENTER);
        Partida partida = new Partida();


        crearUI(partida, vbox);
        Scene scene = new Scene(vbox, 1300, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    private void crearUI(Partida partida, VBox vbox) throws FileNotFoundException {

        UIenemiga(partida, vbox);

        UIusuario(partida, vbox);




    }

    private void UIusuario(Partida partida, VBox vbox) throws FileNotFoundException {
        //tablero user:
        HBox tableroUsuario = new HBox(3);
        colocarTablero(partida, tableroUsuario, 1);
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
        for(int i = 0; i < partida.getJugadorHumano().getBaraja().size(); i++){
            Button btn = new Button(partida.getJugadorHumano().getBaraja().get(i).getTipo().toString());
            botonesCartas.getChildren().add(btn);
            //Aca iria la accion de seleccionar carta con el boton?
        }
        vbox.getChildren().add(botonesCartas);
    }

    private void UIenemiga(Partida partida, VBox vbox) throws FileNotFoundException {
        //cartas enemigas:
        HBox hboxIA = new HBox(partida.getJugadorIA().getBaraja().size());
        colocarCartasEnemigas(partida, hboxIA);
        vbox.getChildren().add(hboxIA);

        //tablero enemigo:
        HBox tableroIA = new HBox(3);
        colocarTablero(partida, tableroIA, 0);
        vbox.getChildren().add(tableroIA);
    }


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


    private void colocarTablero(Partida partida, HBox hBox, int filaTarget) throws FileNotFoundException {
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
            var label = new Group(imageView);
            hBox.setAlignment(Pos.CENTER);
            hBox.setSpacing(100);
            hBox.getChildren().add(label);
        }

    }

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

    private void colocarCartasUsuario(Partida partida, HBox hbox) throws FileNotFoundException {
        for(int i = 0; i < partida.getJugadorHumano().getBaraja().size(); i++){
            var label = asignarCartaUsuario(partida.getJugadorHumano().getBaraja().get(i).getTipo());
            int finalI = i;
            label.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    partida.getTablero().insertarCarta(1, 1,
                            partida.getJugadorHumano().getBaraja().remove(finalI));
                    partida.getJugadorHumano().removerCartaAtk(partida.getJugadorHumano().getBaraja().get(finalI).getTipo());
                }
            });
            hbox.setAlignment(Pos.CENTER);
            hbox.setSpacing(60);
            hbox.getChildren().add(label);
        }
    }

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
