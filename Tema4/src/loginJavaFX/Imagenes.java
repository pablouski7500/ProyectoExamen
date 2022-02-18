package loginJavaFX;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Alumno
 */
public class Imagenes extends Application {

    GridPane gridPrincipal = new GridPane();

    Label labelIngresos = new Label();
    Image imagenIngresos, imagenRetirada, imagenTransferencia, imagenSaldo, imagenEstadistica;
    ImageView fondoIngresos, fondoRetirada, fondoTransferencia, fondoSaldo, fondoEstadistica;
    Button btnIngreso, btnRetirada, btnTransferencia, btnSaldo, btnEstadistica;

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        Pane imagenes = new Pane();
        //Scene root = new Scene(imagenes, 500, 400);

        Image imagenIngresos = new Image("/resources/ingresos.png");
        ImageView fondoIngresos = new ImageView(imagenIngresos);
        fondoIngresos.setFitHeight(80);
        fondoIngresos.setPreserveRatio(true);
        Button btnIngreso = new Button();
        btnIngreso.setTranslateX(50);
        btnIngreso.setTranslateY(50);
        btnIngreso.setPrefSize(110, 110);
        btnIngreso.setGraphic(fondoIngresos);

         btnIngreso.setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent event) {
                
                  try {
                  Ingresos ingr =new Ingresos();
                  ingr.start(stage);
                  } catch (Exception ex) {
                      //Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex);
                  }
                }          
            }); 
      
        
        Image imagenRetirada = new Image("/resources/retirar.jpg");
        ImageView fondoRetirada = new ImageView(imagenRetirada);
        fondoRetirada.setFitHeight(80);
        fondoRetirada.setPreserveRatio(true);
        Button btnRetirada = new Button();
        btnRetirada.setTranslateX(190);
        btnRetirada.setTranslateY(50);
        btnRetirada.setPrefSize(110, 110);
        btnRetirada.setGraphic(fondoRetirada);
        
        btnRetirada.setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent event) {
                
                  try {
                  Retirar ret = new Retirar();
                  ret.start(stage);
                  stage.show();
                  } catch (Exception ex) {
                      //Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
                        
                    }); 

         
        Image imagenTransferencia = new Image("/resources/transferencia.jpg");
        ImageView fondoTransferencia = new ImageView(imagenTransferencia);
        fondoTransferencia.setFitHeight(80);
        fondoTransferencia.setPreserveRatio(true);
        Button btnTransferencia = new Button();
        btnTransferencia.setTranslateX(320);
        btnTransferencia.setTranslateY(50);
        btnTransferencia.setPrefSize(110, 110);
        btnTransferencia.setGraphic(fondoTransferencia);

       
        
         btnTransferencia.setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent event) {
                
                  try {
                  Ingresos ingr =new Ingresos();
                  ingr.start(stage);
                  } catch (Exception ex) {
                      //Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
                        
                    }); 

        Image imagenSaldo = new Image("/resources/saldo.jpg");
        ImageView fondoSaldo = new ImageView(imagenSaldo);
        fondoSaldo.setFitHeight(80);
        fondoSaldo.setPreserveRatio(true);
        Button btnSaldo = new Button();
        btnSaldo.setTranslateX(110);
        btnSaldo.setTranslateY(200);
        btnSaldo.setPrefSize(110, 110);
        btnSaldo.setGraphic(fondoSaldo);

         btnSaldo.setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent event) {
                
                  try {
                  Ingresos ingr =new Ingresos();
                  ingr.start(stage);
                  } catch (Exception ex) {
                      //Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex);
                  }
                }          
            }); 

        Image imagenEstadistica = new Image("/resources/estadistica.png");
        ImageView fondoEstadistica = new ImageView(imagenEstadistica);
        fondoEstadistica.setFitHeight(80);
        fondoEstadistica.setPreserveRatio(true);
        Button btnEstadistica = new Button();
        btnEstadistica.setTranslateX(280);
        btnEstadistica.setTranslateY(200);
        btnEstadistica.setPrefSize(110, 110);
        btnEstadistica.setGraphic(fondoEstadistica);

        btnEstadistica.setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent event) {
                
                  try {
                  Ingresos ingr =new Ingresos();
                  ingr.start(stage);
                  } catch (Exception ex) {
                      //Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex);
                  }
                }          
            });

        Button btnSalir = new Button("Salir");
        imagenes.getChildren().addAll(btnSalir);
        btnSalir.setLayoutX(225);
        btnSalir.setLayoutY(350);

        btnSalir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {

                    Main prin = new Main();
                    prin.start(stage);

                } catch (FileNotFoundException ex) {
                    //  Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

      
        
        Group btnImagenes = new Group(btnIngreso, btnRetirada, btnTransferencia, btnSaldo, btnEstadistica);
        Pane grupoPane = new Pane(imagenes,btnImagenes);
        
        Scene scene = new Scene(grupoPane, 500,400);
        stage.setTitle("MI CUENTA");
        stage.setScene(scene);
        stage.show();

    }
    
    
}