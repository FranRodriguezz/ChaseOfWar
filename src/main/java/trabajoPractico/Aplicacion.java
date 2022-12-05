package trabajoPractico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chase of war");
        VBox vbox = new VBox();
        Partida partida = new Partida();
        vbox.setSpacing(60);

        //cartas enemigas:
        HBox hboxIA = new HBox(partida.getJugadorIA().getBaraja().size());
        colocarCartasEnemigas(partida, hboxIA);
        vbox.getChildren().add(hboxIA);

        //tablero enemigo:
        HBox tableroIA = new HBox(3);
        colocarTablero(partida, tableroIA);
        vbox.getChildren().add(tableroIA);

        //tablero user:
        HBox tableroUsuario = new HBox(3);
        colocarTablero(partida, tableroUsuario);
        vbox.getChildren().add(tableroUsuario);

        //cartas enemigas:
        HBox hboxJugador = new HBox(partida.getJugadorHumano().getBaraja().size());
        colocarCartasUsuario(partida, hboxJugador);
        vbox.getChildren().add(hboxJugador);

        Scene scene = new Scene(vbox, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void colocarCartasEnemigas(Partida partida, HBox hboxIA){
        for(int i = 0; i < partida.getJugadorIA().getBaraja().size(); i++){
            var color = new RadialGradient(50, .8, .5, .5, .7, true, CycleMethod.NO_CYCLE,
                    new Stop(.5f, Color.BLACK),
                    new Stop(.7f, Color.LIGHTPINK),
                    new Stop(.9f, Color.BLACK));
            var label = new Rectangle(50,60, color);
            hboxIA.setAlignment(Pos.CENTER);
            hboxIA.setSpacing(60);
            hboxIA.getChildren().add(label);
        }
    }


    private void colocarTablero(Partida partida, HBox hBox){
        for(int i = 0; i < 3; i++){
            var label = new Label("| Vacio |");
            hBox.setAlignment(Pos.CENTER);
            hBox.setSpacing(100);
            hBox.getChildren().add(label);
        }
    }

    private void colocarCartasUsuario(Partida partida, HBox hbox){
        for(int i = 0; i < partida.getJugadorHumano().getBaraja().size(); i++){
            var label = new Label(partida.getJugadorHumano().getBaraja().get(i).getTipo().toString());
            hbox.setAlignment(Pos.CENTER);
            hbox.setSpacing(40);
            hbox.getChildren().add(label);
        }
    }
}
