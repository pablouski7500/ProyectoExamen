package loginJavaFX;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
public class Main extends Application{
    
      GridPane gridPrincipal = new GridPane();

      
         Label labelIngresos = new Label();
         Image imagenIngresos, imagenRetirada, imagenTransferencia, imagenSaldo, imagenEstadistica;
         ImageView fondoIngresos, fondoRetirada, fondoTransferencia, fondoSaldo, fondoEstadistica;
    
         
    @Override
    public void start(Stage stage) throws Exception {
       
  
gridPrincipal.setAlignment(Pos.CENTER);
gridPrincipal.setHgap(10);
gridPrincipal.setVgap(10);
gridPrincipal.setPadding(new Insets(25, 25, 25, 25));

      

Text tituloPrincipal = new Text("Practica examen");
tituloPrincipal.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
gridPrincipal.add(tituloPrincipal, 0, 0, 2, 1);
 
Label lblUsuario = new Label("Usuario:");
gridPrincipal.add(lblUsuario, 0, 1);
 
TextField tfUsuario = new TextField();
gridPrincipal.add(tfUsuario, 1, 1);
 
Label lblPass = new Label("Contrasena:");
gridPrincipal.add(lblPass, 0, 2);
 
PasswordField pfPass = new PasswordField();
gridPrincipal.add(pfPass, 1, 2);


Button btnAcceder = new Button("Acceder");
HBox hbBtn = new HBox(10);
hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
hbBtn.getChildren().add(btnAcceder);
gridPrincipal.add(hbBtn, 1, 4);

final Text actiontarget = new Text();
gridPrincipal.add(actiontarget, 1, 6);

btnAcceder.setOnAction(new EventHandler<ActionEvent>() {
 
    @Override
    public void handle(ActionEvent e) {
     //   actiontarget.setFill(Color.BLUE);
     //    actiontarget.setText("Pulsa en el boton señalado");
        
        GridPane gridImagenes = new GridPane();
                
              
                Pane imagenes = new Pane();
                
                imagenIngresos = new Image(getClass().getResourceAsStream("/resources/ingresos.png"));
                fondoIngresos = new ImageView(imagenIngresos);
                imagenes.getChildren().addAll(fondoIngresos);
                fondoIngresos.setFitWidth(110);
                fondoIngresos.setFitHeight(110);
                fondoIngresos.setX(0);
                fondoIngresos.setY(0);
                
                imagenIngresos = new Image(getClass().getResourceAsStream("/resources/ingresos.png"));
                fondoIngresos = new ImageView(imagenIngresos);
                imagenes.getChildren().addAll(fondoIngresos);
                fondoIngresos.setFitWidth(110);
                fondoIngresos.setFitHeight(110);
                fondoIngresos.setX(0);
                fondoIngresos.setY(0);
               
                
                Scene scene = new Scene(imagenes, 600, 300);
                
                stage.setTitle("Hello World!");
                stage.setScene(scene);
                stage.show();
    }
});



      gridPrincipal.setStyle("-fx-background-color: silver");
      Scene scene = new Scene(gridPrincipal, 300, 275);
      stage.setScene(scene);
      stage.setTitle("Practica examen");              
      stage.show(); 

    }
   
     

       public static void main(String[] args) {
          launch(args); 
    }

  
}