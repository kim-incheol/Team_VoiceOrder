//주문내역서

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
 
public class Orderlist implements Initializable{
    @FXML private Button back;//뒤로가기
   
 
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
      	   Main = FXMLLoader.load(getClass().getResource("Choice.fxml"));
         } catch (IOException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  		}
         Scene sc = new Scene(Main); 
         stage.setScene(sc);
         stage.show();
           
        }
    
    
    public void payClick() {

    	System.out.println("결제완료");
//   	 Stage newStage = new Stage(); //뒤로가기
//        Stage stage = (Stage)back.getScene().getWindow();
//        Parent Main = null;
//        try {
//     	   Main = FXMLLoader.load(getClass().getResource("Choice.fxml"));
//        } catch (IOException e) {
// 		// TODO Auto-generated catch block
// 		e.printStackTrace();
// 		}
//        Scene sc = new Scene(Main); //뒤로가기
//        stage.setScene(sc);
//        stage.show();
          
       }
        

    }

