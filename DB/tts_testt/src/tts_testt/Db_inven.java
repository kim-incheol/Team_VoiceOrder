package tts_testt;



//데베 사용시 유의시항 

//인스턴스 생성 후  dbcreate 를 실행한 다음
//SelectDB(table);    
//SelectDB_all(table, 3);
//처음에 이 두개 꼭 진행  (해시,트리맵 정보갱신)

//함수 사용이 아니라 직접적으로 해쉬, 트리맵을 접근해서 변경할 시 꼭 변경한 후 select,select_all 명령어를 사용해서 데이터를 초기화를 한번 진행 해 주어야한다.

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Db_inven {
	   Connection conn=null;
	   Statement stmt=null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   Boolean connect=false;
//	   ArrayList<String> array_list= new ArrayList<String>();
	   static TreeMap<String, String> tree_list = new TreeMap<String, String>();
	   static TreeMap<Integer, String[]> tree_list_all = new TreeMap<>();
	   
	   public void connect_DB() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe_manager?useSSL=false",
						"root", "sylphide1");
			} catch (Exception k) {
				System.out.println("연결 실패");
			}
			try {
				connect = true;
				stmt = (Statement) conn.createStatement();
			} catch (Exception e) {
				System.out.println("공간확보실패");
			}
			
		}


	   public void dbCreate_inventory(String table) {    //재고관리데이터베이스 테이블 생성(inventory)
		   connect_DB();
		   try {
		         String query_create = "CREATE table "+table+"("
		            + "num int not null primary key auto_increment, category varchar(20),"
		            +" product_name varchar(20), number_of_products int(11)"+");";
		         stmt.executeUpdate(query_create);
		      }catch(Exception e){
		         connect=false;
		         System.out.println("table 생성 실패");
		       }
		   }
	   
	   
	   public void dbInsert_inventory(String table, String category, String product_name, String number_of_products) {//inventory 테이블 정보입력
		   connect_DB();
		   try {
		         String query_insert = "INSERT INTO "+table +" VALUES(NULL,'"+category+"','"+product_name+"','"+number_of_products+"');";
		         stmt.executeUpdate(query_insert);
		         SelectDB(table);    //해시,트리맵 정보갱신
		         SelectDB_all(table, 3);
		      }catch(Exception e){
		         System.out.println("insert 실패");
		         connect=false;
		      }
		   }


	   
	   //딜리트문 실행 전에 해쉬맵 쓰고 하기
	   public void dbRemove_inventory(String table,String product_name) {
		   Boolean hash_B=false;
		   connect_DB();
		      try {
		    	  hash_B=tree_list.containsKey(product_name);
		    	  if(hash_B) {
		    		  System.out.println("해당 상품명이 존재합니다.");
		    	  }
		    	  else {
		    		  System.out.println("해당 상품명이 없습니다.");
		    	  }
		      }catch(Exception e){
		    	  System.out.println(" 해당 상품명을 찾는데 실패하였습니다.");
		      }
		      try {
		    	  stmt.executeUpdate("delete from "+table+" where product_name="+"'"+product_name+"';");
			         SelectDB(table);    //해시,트리맵 정보갱신
			         SelectDB_all(table, 3);
		      }
		      catch(Exception e){
		    	  System.out.println("상품 삭제 실패");
		    	  connect=false;
		      }
		   
	   }
	   
	   

	   //재고 추가하는거 매개변수받아서추가
	   public void dbUpdate_inventory(String table,String product_name,int num) { //여기서 num은 재고추가/감소의 숫자 설정   
		   Boolean hash_B=false;
		   int update_num=0;
		   connect_DB();
		      try {
		    	  hash_B=tree_list.containsKey(product_name);
		    	  if(hash_B) {
		    		  String g=tree_list.get(product_name);     //상품재고확인
		    		  update_num=Integer.parseInt(g);
		    		  if(update_num>0) {
		    			update_num+=num;
		    		  }
		    		  else {
		    			  System.out.println("상품 재고가 없습니다");
		    			  hash_B=false;
		    		  }
		    		  if(update_num<0)
		    			  update_num=0;    //-가되면 -가몇개인지 반환해도 괜찮을듯
		    	  }
		    	  else {
		    		  System.out.println("해당 상품명이 없습니다.");
		    	  }
		      }catch(Exception e){
		    	  System.out.println(" 상품명을 찾는데 실패하였습니다.");
		      }
		      try {
		    	  if(hash_B) {
		    		  stmt.executeUpdate("UPDATE "+table+" SET number_of_products='"+update_num+"' WHERE product_name= '"+product_name+"';");
				      SelectDB(table);    //해시,트리맵 정보갱신
				      SelectDB_all(table, 3);
		    	  }
		      }
		      catch(Exception e){
		    	  System.out.println("상품 업데이트 실패");
		    	  connect=false;
		      }
		   
		   
	   }
	   
	   public void dbUpdate_inventory(String table,String product_name) {    //상품명을 찾아서 존재하면 값을 하나 내리는 재고관리
		   Boolean hash_B=false;
		   int update_num=0;
		   connect_DB();
		      try {
		    	  hash_B=tree_list.containsKey(product_name);
		    	  if(hash_B) {
		    		  System.out.println("해당 상품명이 존재합니다.");
		    		  String g=tree_list.get(product_name);     //상품재고확인
		    		  update_num=Integer.parseInt(g);
		    		  if(update_num>0) {
		    			update_num--;  
		    		  }
		    		  else {
		    			  System.out.println("상품 재고가 없습니다");
		    			  hash_B=false;
		    		  }
		    	  }
		    	  else {
		    		  System.out.println("해당 상품명이 없습니다.");
		    	  }
		      }catch(Exception e){
		    	  System.out.println(" 상품명을 찾는데 실패하였습니다.");
		      }
		      try {
		    	  if(hash_B) {
		    		  System.out.println(update_num);
		    		  stmt.executeUpdate("UPDATE "+table+" SET number_of_products='"+update_num+"' WHERE product_name= '"+product_name+"';");
				      SelectDB(table);    //해시,트리맵 정보갱신
				      SelectDB_all(table, 3);
		    	  }
		      }
		      catch(Exception e){
		    	  System.out.println("상품 업데이트 실패");
		    	  connect=false;
		      }
		   
		   
	   }
	   
	   public TreeMap<String, String> SelectDB(String table)  //상품 하나 하나에 대한 재고 확인                        ////////키값 상품명으로 반환
	   {
		   connect_DB();
		   tree_list.keySet().removeAll(tree_list.keySet());  //트리맵 요소 초기화
	      
	      try {
	         rs=stmt.executeQuery("SELECT * FROM "+table);
	   
	      } catch (SQLException e1) {
	         e1.printStackTrace();
	      }
	      try {
	         while(rs.next()) {
	            tree_list.put(rs.getString(3),rs.getString(4));
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	         connect=false;
	      }
	      return tree_list;
	   }
	   
	   public TreeMap<Integer, String[]> SelectDB_all(String table, int number)   //데이터 베이스 상 num을 제외한 나머지 칼럼의수  number에 입력(3)  //////////////키값: num 으로 반환(db의 num)
	   {
		   connect_DB();
		   tree_list_all.keySet().removeAll(tree_list_all.keySet());  //트리맵 요소 초기화
	      try {
	         rs=stmt.executeQuery("SELECT * FROM "+table);
	   
	      } catch (SQLException e1) {
	         e1.printStackTrace();
	      }
	      try {
	         while(rs.next()) {
	        	 String[] s_all = new String[number];
	        	 for(int i=0;i<number;i++) {
	        		 s_all[i]=rs.getString(i+2);
	        	 }
	        	 tree_list_all.put(rs.getInt(1),s_all);
//	        	 String[] temp1;
//	        	 temp1 = tree_list_all.get(rs.getString(1));
//	        	 for(int i=0; i< temp1.length; i++)
//	             {
//	           	  System.out.println("tree_list_all,get " + 
//	            "key_value = " +rs.getString(1)+"  "+ temp1[i].toString());
//	             }
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	         connect=false;
	      }
	      return tree_list_all;
	   }
	   //order_list 전체출력
	   public void SelectDB_all_sys(TreeMap<Integer, String[]> tree){
		   Iterator<Integer> keySetIterator = tree.keySet().iterator();
		   while(keySetIterator.hasNext()) {
			   Integer key = keySetIterator.next();
			   System.out.print("key:"+key);
			   for(int i=0;i<3;i++) {
			   System.out.print("    "+tree.get(key)[i]);
			   }
			   System.out.println("\n");
		   }
	   }
	   public void SelectDB_sys(String product_name) {             //해당 상품명에대한 재고 출력
		   System.out.println(tree_list.get(product_name));   
	   }
	   
	   public static void main(String[] args) {
		   	
			Db_inven db= new Db_inven();
			db.SelectDB("inventory");    //해시,트리맵 정보갱신
			db.SelectDB_all("inventory", 3);
//			db.dbCreate_inventory("inventory");
//			db.dbInsert_inventory("inventory","coffee","iceAmericano","15");   
//			TreeMap<String, String> map = new TreeMap<>();
//			TreeMap<Integer, String[]> map1 = new TreeMap<>();
			db.dbUpdate_inventory("inventory","iceAmericano",+50);
//			map=db.SelectDB("inventory");
			db.SelectDB_sys("iceAmericano");
//			map1=db.SelectDB_all("inventory",3);   //number_of_products 값을 int형으로 바꿔도 가능한지 보자 아니면 애초에 int형으로 안바꿔도 될 가능성도 있음 toint이런함수를 사용해서
//			db.dbUpdate_inventory("inventory","iceAmericano");
			db.SelectDB_all_sys(tree_list_all);
	   }
	}

//usessL오류