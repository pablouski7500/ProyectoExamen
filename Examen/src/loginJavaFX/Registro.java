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

public class Registro extends Application {

    Label tit = new Label("Rellene los siguientes campos");
    Label lblUser = new Label("Introduce tu nuevo nombre de usuario:");
    Label lblPass = new Label("Introduce tu nueva contraseña:");
    Button registrar = new Button("Registrarse");
    Button cancelar = new Button("Cancelar");
    TextField usuario = new TextField();
    PasswordField contrasena = new PasswordField();
    final double dinero = 100;

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        Pane p = new Pane();

        bp.setCenter(p);

        tit.setLayoutX(80);
        lblUser.setLayoutX(120);
        lblUser.setLayoutY(80);
        usuario.setLayoutX(120);
        usuario.setLayoutY(100);
        lblPass.setLayoutX(120);
        lblPass.setLayoutY(140);
        contrasena.setLayoutX(120);
        contrasena.setLayoutY(160);
        registrar.setLayoutX(130);
        registrar.setLayoutY(200);
        cancelar.setLayoutX(210);
        cancelar.setLayoutY(200);

        p.getChildren().addAll(tit, lblUser, usuario, lblPass, contrasena, registrar, cancelar);

        registrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String usu = usuario.getText();
                String contra = contrasena.getText();
                final int dinero = 100;
                Cuenta cuenta = new Cuenta();

                if (ListaUsuaros.getUsuario(usu) == null) {
                    cuenta.setUsuario(usu);
                    cuenta.setContrasena(contra);
                    cuenta.setDinero(dinero);
                    ListaUsuaros.agregar(cuenta);
                    JOptionPane.showMessageDialog(null, "Usuario registrado con éxito: " + cuenta.getUsuario(), "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        Imagenes img = new Imagenes(cuenta);
                        img.start(stage);
                    } catch (FileNotFoundException ex) {
                        // Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Este usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    Login abrir = new Login();
                    abrir.start(stage);

                } catch (Exception ex) {
                    //Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Scene scene = new Scene(bp, 400, 300);

        stage.setTitle("Registro");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
