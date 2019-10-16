//메뉴판 & 주문내역서 페이지

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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.example.speech.*;

public class Menu_and_Orderlist implements Initializable{
    @FXML private Button order; //주문하기 버튼
    @FXML private Button orderlist; //주문내역&결제 버튼
    @FXML private Button back1; //뒤로가기 버튼
    @FXML private Label namelabel;
    @FXML private Button VoiceReco;
    
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	namelabel.setText(NameSet.id);
        // TODO Auto-generated method stub
 
    }
    
    //주문내역&결제 
    public void orderListClick() { 
        Stage newStage2 = new Stage(); 
        Stage stage2 = (Stage)orderlist.getScene().getWindow();
        Parent OrderList = null;
		try {
			 OrderList = FXMLLoader.load(getClass().getResource("OrderList.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
        Scene sc2 = new Scene(OrderList);
        stage2.setScene(sc2);
        stage2.show();
        System.out.println("주문내역 클릭");
    }
    
    //뒤로가기
    public void backClick() {
       Stage newStage3 = new Stage(); 
       Stage stage3 = (Stage)back1.getScene().getWindow();
       Parent Main = null;
       try {
    	   Main = FXMLLoader.load(getClass().getResource("Main.fxml"));
       } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
       Scene sc3 = new Scene(Main);
       stage3.setScene(sc3);
       stage3.show();
    }
    
  //메뉴판
    public void menuClick() {
        Stage newStage = new Stage(); 
        Stage stage = (Stage)order.getScene().getWindow();
   
        try {
            Parent allMenu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Scene sc = new Scene(allMenu); 
            stage.setScene(sc);
            stage.show();
       
        } catch (IOException e) {
            e.printStackTrace();    
        }
        

    }
    
    //음성인식
    public void VoiceRecoClick() {
    	try {
    		RecoVoice();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void RecoVoice(String... args) {
    	try {
			Recognize.sttstart(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}