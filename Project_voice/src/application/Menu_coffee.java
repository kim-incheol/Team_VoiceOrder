package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Menu_coffee implements Initializable {
    @FXML private Button back; //뒤로가기
    @FXML private Button americano;
    @FXML private Button latte;
    @FXML private Button caramel;
    @FXML private Button cappuccino;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
 
    }
 
  //뒤로가기
    public void backClick() {

    	 Stage newStage = new Stage(); 
         Stage stage = (Stage)back.getScene().getWindow();
         Parent Main = null;
         try {
      	   Main = FXMLLoader.load(getClass().getResource("Menu.fxml"));
         } catch (IOException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  		}
         Scene sc = new Scene(Main);
         stage.setScene(sc);
         stage.show();
           
        }
    
    public void americanoClick() {
    	System.out.println("아메리카노 클릭");
    }
    
    public void latteClick() {
    	System.out.println("라떼 클릭");
    }
    
    public void caramelClick() {
    	System.out.println("카라멜마끼아또 클릭");
    }
  
    
    public void cappuccinoClick() {
    	System.out.println("카푸치노 클릭");
    }
  
  

    }