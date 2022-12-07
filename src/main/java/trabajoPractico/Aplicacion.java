package trabajoPractico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
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
        vbox.setSpacing(50);
        vbox.setAlignment(Pos.CENTER);
        Partida partida = new Partida();
        crearUI(partida, vbox);
        int turno = 0;
        /*
        while(!partida.finalizada()){
            partida.jugar(turno);
            if(turno == 0){
                turno = 1;
            }
            else{
                turno = 0;
            }
        }*/
        Scene scene = new Scene(vbox, 700, 625);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    private void crearUI(Partida partida, VBox vbox) throws FileNotFoundException {
        //vida enemiga:
        var vidaIA = new ProgressBar(partida.getJugadorIA().getVida());
        vbox.getChildren().add(vidaIA);

        //cartas enemigas:
        HBox hboxIA = new HBox(partida.getJugadorIA().getBaraja().size());
        colocarCartasEnemigas(partida, hboxIA);
        vbox.getChildren().add(hboxIA);

        //tablero enemigo:
        HBox tableroIA = new HBox(3);
        colocarTablero(partida, tableroIA, 0);
        vbox.getChildren().add(tableroIA);

        //tablero user:
        HBox tableroUsuario = new HBox(3);
        colocarTablero(partida, tableroUsuario, 1);
        vbox.getChildren().add(tableroUsuario);

        //cartas enemigas:
        HBox hboxJugador = new HBox(partida.getJugadorHumano().getBaraja().size());
        colocarCartasUsuario(partida, hboxJugador);
        vbox.getChildren().add(hboxJugador);

        //vida user:
        var vidaUsuario = new ProgressBar(partida.getJugadorHumano().getVida());
        vbox.getChildren().add(vidaUsuario);
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
