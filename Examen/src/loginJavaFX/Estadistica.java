/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginJavaFX;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Alumno
 */
public class Estadistica extends Application {

    Cuenta cuenta;

    public Estadistica(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void start(Stage stage) {

        // Implementar boton salir
        Button cancelar = new Button("Cancelar");

        cancelar.setLayoutX(350);
        cancelar.setLayoutY(370);
        //Definiendo Eje   
        final NumberAxis xaxis = new NumberAxis(100, 1200, 1);
        final NumberAxis yaxis = new NumberAxis(1, 30, 5);

        //Definiendo etiqueta para eje   
        xaxis.setLabel("Dinero");
        yaxis.setLabel("Operaciones");

        //Creando la instancia del gráfico de líneas con el eje especificado  
        LineChart linechart = new LineChart(xaxis, yaxis);

        //creando la serie   
        XYChart.Series series = new XYChart.Series();

        //estableciendo el nombre y la fecha de la serie   
        series.setName("Evolucion del dinero");
        series.getData().add(new XYChart.Data(100, 1));
        series.getData().add(new XYChart.Data(150, 8));
        series.getData().add(new XYChart.Data(220, 9));
        series.getData().add(new XYChart.Data(290, 3));
        series.getData().add(new XYChart.Data(280, 13));
        series.getData().add(new XYChart.Data(330, 15));
        series.getData().add(new XYChart.Data(600, 22));
        series.getData().add(new XYChart.Data(1100, 14));
        series.getData().add(new XYChart.Data(400, 17));

        cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Imagenes img = new Imagenes(cuenta);
                    img.start(stage);
                } catch (FileNotFoundException ex) {
                    //  Logger.getLogger(Ingresos.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.show();

            }
        });
        //añadiendo series al gráfico de líneas   
        linechart.getData().add(series);

        // configuración de grupo y escena   
        Group root = new Group(linechart, cancelar);
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Estadistica");
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
