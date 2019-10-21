//츄천메뉴

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
 
public class Menu_star implements Initializable{
    @FXML private Button back; //뒤로가기
    @FXML private Button allmenu; //전체메뉴
    @FXML private Button starmenu; //추천메뉴
   
 
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
    public void cakeClick() {
    	System.out.println("케이크 클릭");
    }
    public void lemonClick() {
    	System.out.println("레몬에이드 클릭");
    }
    public void breadClick() {
    	System.out.println("허니브레드 클릭");
    }
   
    
    
   
        

    }