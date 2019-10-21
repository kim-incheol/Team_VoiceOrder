package application;

import java.awt.Window;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.*;


import javafx.application.Platform;
import com.example.speech.Recognize;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Menu_coffee implements Initializable {
    @FXML private Button back; //뒤로가기
    @FXML private Button americano;
    @FXML private Button latte;
    @FXML private Button caramel;
    @FXML private Button cappuccino;
    private ObservableList<TableRowDataModel> myList;
    
    @FXML
    private TableView<TableRowDataModel> myTableView;
    @FXML
    private TableColumn<TableRowDataModel, String> product_name;
    @FXML
    private TableColumn<TableRowDataModel, String> product_price;
    @FXML
    private TableColumn<TableRowDataModel, String> product_num;

    private Stack<Label> stack = new Stack<>();
    private Popup numPopup;
    private List<Popup> numPopList = new ArrayList<>();

    static int selectindex=0;

    
    // 테이블뷰에 넣을 데이터 ( 상품명, 가격, 수량 )
    public void setOrderlist_Table(String name, String price, String num) {
		myList = FXCollections.observableArrayList(
    			new TableRowDataModel(new SimpleStringProperty(name), new SimpleStringProperty(price), new SimpleStringProperty(num))
    			);
    	selectindex++;
    }
    
    
    public void deleteRow(int selecteindex) {
    	if(selectindex>0) {
    		myList.remove(selecteindex);
        	selectindex--;
    	}
    }
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
    	if(myList==null) {System.out.println("myList"+"NULL");}
    	System.out.println("넣기전"+selectindex);
    	setOrderlist_Table("","","");
    	System.out.println("넣은후"+selectindex);
    	product_name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    	product_price.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
    	product_num.setCellValueFactory(cellData -> cellData.getValue().numProperty());
    	myTableView.setItems(myList);
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
    	try {
    		Stage stage = (Stage)americano.getScene().getWindow();
    		openNumPopup(stage);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
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

    
    public void closeNumPopup(Button btn) {

        numPopup = (Popup)btn.getScene().getWindow(); // 버튼을 통해서 현재 스테이지를 알아냄
         numPopup.hide();

       System.out.println("수량 팝업창 닫기");
    }
    
    public void openNumPopup(Stage stage) {
        numPopup = new Popup();
        
        if(numPopup.isShowing()) {
           numPopup.hide();
        }else {
           Scene scene = stage.getScene();
           javafx.stage.Window window = scene.getWindow();
           
           numPopup.getContent().clear();
//           numPopList.add(numPopup);
           
           Parent numberboard = null;
           try {
              numberboard = FXMLLoader.load(getClass().getResource("numberboard.fxml"));
           } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
           }
//           stack.push(numPopup);
           
          numPopup.getContent().addAll(numberboard);
          numPopup.setAutoHide(true);
           
           Platform.runLater(new Runnable() {
             
             @Override
             public void run() {
                // TODO Auto-generated method stub
                numPopup.show(window);
             }
          });   
        }
     }

  //음성인식
    public void VoiceRecoClick() {
    		RecoVoice();
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

