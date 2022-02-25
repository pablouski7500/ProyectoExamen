package loginJavaFX;

import java.io.FileNotFoundException;
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
public class Transferencia extends Application {

    Label tit = new Label("Introduzca el nombre de usuario del cliente");
    Label tit2 = new Label("Introduzca la cantidad que desea ingresar");
    Button aceptar = new Button("Aceptar");
    Button cancelar = new Button("Cancelar");
    TextField campoing = new TextField();
    TextField campoing2 = new TextField();
    Cuenta cuenta;

    public Transferencia(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        Pane p = new Pane();

        bp.setCenter(p);

        tit.setLayoutX(40);
        tit.setLayoutY(40);
        campoing.setLayoutX(40);
        campoing.setLayoutY(60);
        tit2.setLayoutX(40);
        tit2.setLayoutY(100);
        campoing2.setLayoutX(40);
        campoing2.setLayoutY(120);
        aceptar.setLayoutX(130);
        aceptar.setLayoutY(170);
        cancelar.setLayoutX(210);
        cancelar.setLayoutY(170);

        p.getChildren().addAll(tit, campoing, tit2, campoing2, aceptar, cancelar);
        aceptar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String nombreUsuarioDestino = campoing.getText();
                Double dineroIngreso = Double.parseDouble((String) campoing2.getText());

                Cuenta cuentaDestino = ListaUsuaros.getUsuario(nombreUsuarioDestino);

                if (cuenta.getDinero() > dineroIngreso && cuentaDestino != null) {
                    cuenta.setDinero(cuenta.getDinero() - dineroIngreso);
                    cuenta.setUltimaRetirada(dineroIngreso);

                    cuentaDestino.setDinero(cuentaDestino.getDinero() + dineroIngreso);
                    //cuentaDestino.setUltimoTransferencia(dineroIngreso);
                    cuentaDestino.setUltimoIngreso(dineroIngreso);
                    String mensajeOutput = "Se ha realizado correctamente la transferencia de " + dineroIngreso + "€ a la cuenta de " + cuentaDestino.getUsuario();
                    JOptionPane.showMessageDialog(null, mensajeOutput, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                } else if (dineroIngreso > cuenta.getDinero()) {
                    String mensajeOutput = "No tienes el sufuciente dinero";
                    JOptionPane.showMessageDialog(null, mensajeOutput, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String mensajeOutput = "El usuario receptor no existe";
                    JOptionPane.showMessageDialog(null, mensajeOutput, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }

                // Comprobar que el dinero del usuario es superior al dineroDestino
                // cuentaDestino existe
                try {
                    Imagenes img = new Imagenes(cuenta);
                    img.start(stage);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Ingresos.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.show();

            }
        });

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

        Scene scene = new Scene(bp, 400, 300);

        stage.setTitle("Transferencia");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
