package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Menu_coffee implements Initializable {
    @FXML private Button back; //뒤로가기
    @FXML private Button americano;
    @FXML private Button latte;
    @FXML private Button caramel;
    @FXML private Button cappuccino;
    static ObservableList<TableRowDataModel> myList;
    
    @FXML
    static TableView<TableRowDataModel> myTableView;
    @FXML
    static TableColumn<TableRowDataModel, String> product_name;
    @FXML
    static TableColumn<TableRowDataModel, String> product_price;
    @FXML
    static TableColumn<TableRowDataModel, String> product_num;
   
    Stage window;
    Scene scene1, scene2;
    private Pane pane1;
    private Pane pane2;
    
    // 테이블뷰에 넣을 데이터 ( 상품명, 가격, 수량 )
    static void setOrderlist_Table(String name, String price, String num) {
    	myList = FXCollections.observableArrayList(
    			new TableRowDataModel(new SimpleStringProperty(name), new SimpleStringProperty(price), new SimpleStringProperty(num))
    			);
    }
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
    	setOrderlist_Table("","","");
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
    	Stage newStage2 = new Stage(); 
        Stage stage2 = (Stage)back.getScene().getWindow();
        Parent Menu_coffee = null;
        try {
        	Menu_coffee = FXMLLoader.load(getClass().getResource("numberboard.fxml"));
        } catch (IOException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 		}
        Scene sc2 = new Scene(Menu_coffee);
        stage2.setScene(sc2);
        stage2.show();
    	
    	
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