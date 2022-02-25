package loginJavaFX;

import java.io.FileNotFoundException;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumno
 */
public class Saldo extends Application {

    Cuenta cuenta;

    public Saldo(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        Pane p = new Pane();

        bp.setCenter(p);

        double saldoActual = cuenta.getDinero();
        double ultimoIngreso = cuenta.getUltimoIngreso();
        double ultimaRetirada = cuenta.getUltimaRetirada();

        Label lblSaldo = new Label("SALDO ACTUAL:");
        Label totalSal = new Label(saldoActual + " €");
        Label lblIngreso = new Label("INGRESOS:");
        Label totalIng = new Label(ultimoIngreso + " €");
        Label lblExtraccion = new Label("EXTRACCION");
        Label totalExt = new Label(ultimaRetirada + " €");
        Button imprimir = new Button("Imprimir");
        Button cancelar = new Button("Cancelar");

        lblSaldo.setLayoutX(40);
        lblSaldo.setLayoutY(40);

        totalSal.setLayoutX(300);
        totalSal.setLayoutY(40);

        lblIngreso.setLayoutX(40);
        lblIngreso.setLayoutY(90);
        totalIng.setLayoutX(300);
        totalIng.setLayoutY(90);

        lblExtraccion.setLayoutX(40);
        lblExtraccion.setLayoutY(140);
        totalExt.setLayoutX(300);
        totalExt.setLayoutY(140);

        imprimir.setLayoutX(130);
        imprimir.setLayoutY(180);
        cancelar.setLayoutX(210);
        cancelar.setLayoutY(180);

        p.getChildren().addAll(lblSaldo, totalSal, lblIngreso, totalIng, lblExtraccion, totalExt, imprimir, cancelar);

        imprimir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    String ruta = "src/loginJavaFX/Fichero.txt";
                    String contenido = "SALDO ACTUAL: " + saldoActual + "\n"
                            + "INGRESO: " + ultimoIngreso + "\n"
                            + "EXTRACCIÓN: " + ultimaRetirada;
                    File file = new File(ruta);
                    // Si el archivo no existe es creado
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(contenido);
                    bw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Imagenes img = new Imagenes(cuenta);
                    img.start(stage);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Ingresos.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.show();

            }
        });

        Scene scene = new Scene(bp, 400, 300);

        stage.setTitle("Saldo");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
