//이름설정

package application;
 
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
 
public class NameSet implements Initializable{
	static String id;
    @FXML private Button ok; //확인버튼 : order
    @FXML private TextField txtname;
 


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
 
    }

    public void okClick(ActionEvent event) {
        Stage newStage = new Stage();
        Stage stage = (Stage)ok.getScene().getWindow();
       
        if(txtname.getLength()==0 ) {
   		 JOptionPane.showMessageDialog(null, "이름을 입력하지 않았습니다. 이름을 입력해주세요 !");
   		 return;
   		 }
        
        System.out.println(txtname.getText());
        id=txtname.getText().toString();
        System.out.println(id);
        
        if(txtname.getText().equals("susie")) {
        try {
        	 
        //     resultTxt.setText(inputTxt);
            Parent Choice = FXMLLoader.load(getClass().getResource("Manager.fxml"));
            
            Scene sc = new Scene(Choice);
            stage.setScene(sc);
            
            stage.show();
           
            
        } catch (IOException e) {
        	
            e.printStackTrace();
         
        }
        }
        else
        {
            try {
           	 
                //     resultTxt.setText(inputTxt);
                    Parent Manager = FXMLLoader.load(getClass().getResource("Choice.fxml"));
                    
                    
                    
                    Scene sc = new Scene(Manager);
                    stage.setScene(sc);
                    
                    stage.show();
                   
                    
                } catch (IOException e) {
                	
                    e.printStackTrace();
                 
                }
                }
        }
        	
        

    }
    
  
