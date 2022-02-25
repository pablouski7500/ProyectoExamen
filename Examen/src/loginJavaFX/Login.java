/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginJavaFX;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumno
 */
public class Login extends Application {

    Label tit = new Label("Rellene los siguientes campos");
    Button acceder = new Button("Iniciar Sesion");
    Button registrarse = new Button("Registrarse");
    Label lblUser = new Label("Introduce el usuario:");
    Label lblPass = new Label("Introduce la contraseña:");
    TextField tfUsuario = new TextField();
    PasswordField pfPass = new PasswordField();

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        BorderPane bp = new BorderPane();
        Pane p = new Pane();

        bp.setCenter(p);

        tit.setLayoutX(80);
        acceder.setLayoutX(120);
        acceder.setLayoutY(200);
        registrarse.setLayoutX(220);
        registrarse.setLayoutY(200);
        lblUser.setLayoutX(120);
        lblUser.setLayoutY(70);
        tfUsuario.setLayoutX(120);
        tfUsuario.setLayoutY(90);
        lblPass.setLayoutX(120);
        lblPass.setLayoutY(130);
        pfPass.setLayoutX(120);
        pfPass.setLayoutY(150);

        p.getChildren().addAll(tit, acceder, registrarse, lblUser, tfUsuario, lblPass, pfPass);

        acceder.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                String usu = tfUsuario.getText();
                String contra = pfPass.getText();
                Cuenta cuenta = ListaUsuaros.VerificarLogueo(usu, contra);
                if (cuenta == null) {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        System.out.println("Usuario logueado:" + cuenta.toString());
                        Imagenes img = new Imagenes(cuenta);
                        img.start(stage);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

        });

        registrarse.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                try {
                    Registro abrir = new Registro();
                    abrir.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        Scene scene = new Scene(bp, 400, 300);

        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
