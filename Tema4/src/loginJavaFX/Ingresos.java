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
public class Ingresos extends Application{

    Label tit = new Label("introduzca la cantidad que desea ingresar");
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
        
        stage.setTitle("Ingresos");
        stage.setScene(scene);
        stage.show();
          
         
    }
      public static void main(String[] args) {
        launch(args);
    }
}
