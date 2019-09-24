//주문내역서

package application;
 
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.print.DocFlavor.STRING;
import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
 
public class Orderlist implements Initializable{
	
	int count =0;
	
    @FXML private Button back;//뒤로가기
   
    @FXML private ListView<String> orderlist_list;
    
    final ObservableList<String> list = FXCollections.observableArrayList();
    
   
    
    @FXML private Label order_name;
    @FXML private Label order_num;
    @FXML private Button order_up;
    @FXML private Button order_down;

    
    
    @FXML 
    private void deleteorder(ActionEvent action) {
    	
    	int select=orderlist_list.getSelectionModel().getSelectedIndex();
    	list.remove(select);
    	JOptionPane.showMessageDialog(null,"취소되었습니다.");
    	
    }
    
    
//	@Override
//    public void initialize(URL location, ResourceBundle resources) {
//        // TODO Auto-generated method stub
//		
//		order_name.setText(NameSet.id);
//    	for(int i =0; i<Menu.mArray.size(); i++)
//    	{
//    		list.add(Menu.mArray.get(i));
//    	}
//
//    	
//    	orderlist_list.setItems(list);
    	
//    	
//    	
//    	order_num.setText(""+count);
//    	order_up.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent event) {
//				// TODO Auto-generated method stub
//				count++;
//				order_num.setText(""+count);
//			}
//		});
//    	
//    	order_down.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				// TODO Auto-generated method stub
//				count--;
//				order_num.setText(""+count);
//			}
//    		
//		});
//    	
//
//    	
//    }
    
   
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
    
    	JOptionPane.showMessageDialog(null, "결제가 완료 되었습니다.");
    	System.exit(1);
    
    	
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


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}

