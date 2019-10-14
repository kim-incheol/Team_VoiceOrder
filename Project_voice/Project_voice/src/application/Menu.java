//메뉴

package application;
 
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.AmbientLight;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
 
public class Menu implements Initializable{
    @FXML private Button back; //뒤로가기버튼
    @FXML private Button allmenu; //전체메뉴
    @FXML private Button starmenu; //추천메뉴
    @FXML private Button coffee;
    @FXML private Button juice;
    @FXML private Button desert;
    
    
    
//    @FXML private Button americano; 
//    @FXML private Button latte; 
//    @FXML private Button jamong;
//    @FXML private Button lemon;
//    @FXML private Button smoothie;
//    @FXML private Button choco;
//    @FXML private Button bread;
//    @FXML private Button cake;
//    
// 
//    static ArrayList<String> mArray = new ArrayList<>();
//    
//    static String menu_americano;
//    static String menu_latte;
//    static String menu_jamong;
//    static String menu_lemon;
//    static String menu_smoothie;
//    static String menu_choco;
//    static String menu_bread;
//    static String menu_cake;
    
   
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
 
    }
 
    //뒤로가기
    public void backClick() {

    	 Stage newStage = new Stage(); //뒤로가기
         Stage stage = (Stage)back.getScene().getWindow();
         Parent Main = null;
         try {
      	   Main = FXMLLoader.load(getClass().getResource("Choice.fxml"));
         } catch (IOException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  		}
         Scene sc = new Scene(Main); //뒤로가기
         stage.setScene(sc);
         stage.show();
           
        }
    
    //전체메누
    
    public void allmenuClick() {

      	 Stage newStage1 = new Stage(); 
           Stage stage1 = (Stage)allmenu.getScene().getWindow();
           Parent allMenu = null;
           try {
           	allMenu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
           } catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		}
           Scene sc1 = new Scene(allMenu); 
           stage1.setScene(sc1);
           stage1.show();
           System.out.println("전체메뉴클릭");
             
          }
    
    //추천메뉴
    public void starmenuClick() {

    	 Stage newStage2 = new Stage(); 
         Stage stage2 = (Stage)starmenu.getScene().getWindow();
         Parent Menu_star = null;
         try {
        	 Menu_star = FXMLLoader.load(getClass().getResource("Menu_star.fxml"));
         } catch (IOException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  		}
         Scene sc2 = new Scene(Menu_star); 
         stage2.setScene(sc2);
         stage2.show();
         System.out.println("추천메뉴클릭");
        }
    
    //커피클릭
    public void coffeeClick() {

   	 Stage newStage3 = new Stage(); 
        Stage stage3 = (Stage)coffee.getScene().getWindow();
        Parent Menu_coffee = null;
        try {
        	Menu_coffee = FXMLLoader.load(getClass().getResource("Menu_coffee.fxml"));
        } catch (IOException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 		}
        Scene sc3 = new Scene(Menu_coffee); 
        stage3.setScene(sc3);
        stage3.show();
        System.out.println("커피메뉴클릭");
       }
    
    //주스클릭
    public void juiceClick() {

   	 Stage newStage4 = new Stage(); 
        Stage stage4 = (Stage)juice.getScene().getWindow();
        Parent Menu_juice = null;
        try {
        	Menu_juice = FXMLLoader.load(getClass().getResource("Menu_juice.fxml"));
        } catch (IOException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 		}
        Scene sc4 = new Scene(Menu_juice); 
        stage4.setScene(sc4);
        stage4.show();
        System.out.println("주스메뉴클릭");
       }
    
    //디저트클릭
    public void desertClick() {

   	 Stage newStage5 = new Stage(); 
        Stage stage5 = (Stage)desert.getScene().getWindow();
        Parent Menu_desert = null;
        try {
        	Menu_desert = FXMLLoader.load(getClass().getResource("Menu_desert.fxml"));
        } catch (IOException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 		}
        Scene sc5 = new Scene(Menu_desert); 
        stage5.setScene(sc5);
        stage5.show();
        System.out.println("디저트메뉴클릭");
       }
    

    
    
    
//    public void americanoClick() {
//    	//menu_americano=americano.getText().toString();
//    	JOptionPane.showMessageDialog(null, "아메리카노가 주문되었습니다.");
//    	americano.setText("아메리카노");
//    	menu_americano=americano.getText().toString();
//    	
//    	mArray.add(menu_americano);
//        System.out.println("메뉴 : "+ menu_americano);
//       }
//    
//    
//    
//    public void latteClick() {
//    	JOptionPane.showMessageDialog(null, "카페라떼가 주문되었습니다.");
//    	latte.setText("카페라떼");
//    	menu_latte=latte.getText().toString();
//    	mArray.add(menu_latte);
//        System.out.println("메뉴 : "+menu_latte);
//       }
//    
//    public void jamongClick() {
//    	JOptionPane.showMessageDialog(null, "자몽에이드가 주문되었습니다.");
//    	jamong.setText("자몽에이드");
//    	menu_jamong=jamong.getText().toString();
//    	mArray.add(menu_jamong);
//        System.out.println("메뉴 : "+menu_jamong);
//       }
//    
//    public void lemonClick() {
//    	JOptionPane.showMessageDialog(null, "레몬에이드가 주문되었습니다.");
//    	lemon.setText("레몬에이드");
//    	menu_lemon=lemon.getText().toString();
//    	mArray.add(menu_lemon);
//        System.out.println("메뉴 : "+menu_lemon);
//       }
//    
//    public void smoothieClick() {
//    	JOptionPane.showMessageDialog(null, "스무디가 주문되었습니다.");
//    	smoothie.setText("스무디");
//    	menu_smoothie=smoothie.getText().toString();
//    	mArray.add(menu_smoothie);
//        System.out.println("메뉴 : "+menu_smoothie);
//       }
//    
//    public void chocoClick() {
//    	JOptionPane.showMessageDialog(null, "초코프라페가 주문되었습니다.");
//    	choco.setText("초코프라페");
//    	menu_choco=choco.getText().toString();
//    	mArray.add(menu_choco);
//        System.out.println("메뉴 : "+menu_choco);
//       }
//    
//    public void breadClick() {
//    	JOptionPane.showMessageDialog(null, "허니브레드가 주문되었습니다.");
//    	bread.setText("허니브레드");
//    	menu_bread=bread.getText().toString();
//    	mArray.add(menu_bread);
//        System.out.println("메뉴 : "+menu_bread);
//       }
//    
//    public void cakeClick() {
//    	JOptionPane.showMessageDialog(null, "케이크가 주문되었습니다.");
//    	cake.setText("케이크");
//    	menu_cake=cake.getText().toString();
//    	mArray.add(menu_cake);
//        System.out.println("메뉴 : "+menu_cake);
//       }

        

    }

