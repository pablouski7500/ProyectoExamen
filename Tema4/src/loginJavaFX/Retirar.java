/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginJavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author migju
 */
public class Retirar extends Application{
    
    Label tit = new Label("introduzca la cantidad que desea retirar");
    Button aceptar = new Button("aceptar");
    Button cancelar = new Button("cancelar");
    TextField campoing = new TextField();
    
    @Override
    public void start(Stage stage) throws Exception {
      
       
        BorderPane bp = new BorderPane();
        Pane p = new Pane();
         
        bp.setCenter(p);
       
        tit.setLayoutX(80);
        aceptar.setLayoutX(130);
        aceptar.setLayoutY(150);
        cancelar.setLayoutX(210);
        cancelar.setLayoutY(150);
        campoing.setLayoutX(120);
        campoing.setLayoutY(90);

        p.getChildren().addAll(tit,campoing,aceptar,cancelar);

        
        cancelar.setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent event) {
                
                  try {
                  Imagenes img = new Imagenes();
                  img.start(stage);
                  stage.show();
                  } catch (Exception ex) {
                      //Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex);
                  }
                }          
            }); 
        
       Scene scene = new Scene(bp, 400, 300);
        
        stage.setTitle("Retiradas");
        stage.setScene(scene);
        stage.show();
}
}