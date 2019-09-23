
package tts_testt;

//데베 사용시 유의시항 
//SelectDB_all(table, 7);// 인스턴스 생성 후 dbcreate 를 실행한 다음 트리맵 초기화를 처음에 한번 꼭 진행해야함
//함수 사용이 아니라 직접적으로 해쉬, 트리맵을 접근해서 변경할 시 꼭 변경한 후 select,select_all 명령어를 사용해서 데이터를 초기화를 한번 진행 해 주어야한다.

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.Iterator;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Db_order {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Boolean connect = false;
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

	// 주문번호 주문시각 이름(테이블명?) 카테고리 상품명 (주문)수량 완료여부 총가격
	public void dbCreate_orderList(String table) { // 주문목록데이터베이스 테이블 생성(orderList)
		connect_DB();
		try {
			String query_create = "CREATE table " + table + "("
					+ "order_num int not null primary key auto_increment, order_time varchar(20),"
					+ " autoBot_name varchar(20), category varchar(20), product_name varchar(20), number_of_products int(11), order_result varchar(20), "
					+ "total_price int(15)" + ");";
			stmt.executeUpdate(query_create);
		} catch (Exception e) {
			connect = false;
			System.out.println("table 생성 실패");
		}
	}

	// 주문번호 주문시각 이름(테이블명?) 카테고리 상품명 (주문)수량 완료여부 총가격
	public void dbInsert_orderList(String table, String order_time, String autoBot_name, String category,
			String product_name, String number_of_products, String order_result, String total_price) {// inventory 테이블
																										// 정보입력
		connect_DB();

		try {
			String query_insert = "INSERT INTO " + table + " VALUES(NULL,'" + order_time + "','" + autoBot_name + "','"
					+ category + "','" + product_name + "','" + number_of_products + "','" + order_result + "','"
					+ total_price + "');";
			stmt.executeUpdate(query_insert);
			SelectDB_all(table, 7);// 트리맵 초기화
		} catch (Exception e) {
			System.out.println("insert 실패");
			connect = false;
		}
	}

	// 딜리트문 실행 전에 해쉬맵 쓰고 하기
	public void dbRemove_orderList(String table) { //dbUpdate_orderList메서드를 통해success로 변경된 리스트를 찾아서 삭제
		connect_DB();
		try {
			stmt.executeUpdate("delete from " + table + " where order_result='success';");
			SelectDB_all(table, 7);// 트리맵 초기화
		} catch (Exception e) {
			System.out.println("상품 삭제 실패");
			connect = false;
		}

	}

	public void dbRemove_orderList(String table, int order_num) { // 주문번호 이용해서 삭제
		connect_DB();
		try {
			stmt.executeUpdate("delete from " + table + " where order_num=" + "'" + order_num + "';");
			SelectDB_all(table, 7);// 트리맵 초기화
		} catch (Exception e) {
			System.out.println("상품 삭제 실패");
			connect = false;
		}

	}

	public void dbUpdate_orderList(String table, int order_num) { // 주문번호를 찾아 주문번호가 존재하면 해당 주문번호에대한 완료 여부 변경
		Boolean hash_B = false;
		connect_DB();

		hash_B = tree_list_all.containsKey(order_num);
		if (hash_B==false) {
			System.out.println("해당 주문번호가 없습니다.");
		}

		try {
			if (hash_B) {
				stmt.executeUpdate(
						"UPDATE " + table + " SET order_result='success' WHERE order_num= '" + order_num + "';");
				SelectDB_all(table, 7);// 트리맵 초기화
			}
		} catch (Exception e) {
			System.out.println("상품 업데이트 실패");
			connect = false;
		}

	}

	public TreeMap<Integer, String[]> SelectDB_all(String table, int number) // 데이터 베이스 상 num을 제외한 나머지 숫자 number에 입력(7)
																				// //////////////키값: num 으로 반환
	{
		connect_DB();
		tree_list_all.keySet().removeAll(tree_list_all.keySet());  //트리맵 요소 초기화
		try {
			rs = stmt.executeQuery("SELECT * FROM " + table);

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			while (rs.next()) {
				String[] s_all = new String[number];
				for (int i = 0; i < number; i++) {
					s_all[i] = rs.getString(i + 2);
				}
				tree_list_all.put(rs.getInt(1), s_all);
//	        	 SelectDB_all(table, 7);//트리맵 초기화
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
			connect = false;
		}
		return tree_list_all;
	}

	// order_list 전체출력
	public void SelectDB_all_sys(TreeMap<Integer, String[]> tree) {
		Iterator<Integer> keySetIterator = tree.keySet().iterator();
		while (keySetIterator.hasNext()) {
			Integer key = keySetIterator.next();
			System.out.print("key:" + key);
			for (int i = 0; i < 7; i++) {
				System.out.print("    " + tree.get(key)[i]);
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {

//			Db_order db= new Db_order();
////			db.dbCreate_inventory("inventory");
////			db.dbInsert_inventory("inventory","coffee","iceAmericano","15");    //인서트에 오류 하나 생기는데 알아보기 usessL오류
//			TreeMap<String, String> map = new TreeMap<>();
//			TreeMap<String, String[]> map1 = new TreeMap<>();
//			map=db.SelectDB("inventory");
//			System.out.println(map.get("iceAmericano"));
//			map1=db.SelectDB_all("inventory",3);   //number_of_products 값을 int형으로 바꿔도 가능한지 보자 아니면 애초에 int형으로 안바꿔도 될 가능성도 있음 toint이런함수를 사용해서
////			db.dbRemove("inventory","nokcha"); 
//			db.dbUpdate("inventory","iceAmericano");

		// -------------------------------------------//
		Db_order db = new Db_order();
		   db.dbCreate_orderList("orderList");
			db.SelectDB_all("orderList", 7);
		   db.dbInsert_orderList("orderList","13:58","bixbee","bread","honey_bread","3","fail","20000");
		   db.dbInsert_orderList("orderList","14:58","ddd","bread","c","2","fail","31000");
		   db.dbInsert_orderList("orderList","14:58","ss","bread","a","1","fail","5000");
		   db.dbInsert_orderList("orderList","14:58","aa","bread","s","1","fail","2000");
		   db.dbInsert_orderList("orderList","14:58","aa","bread","d","1","fail","3000");
		   db.dbInsert_orderList("orderList","14:58","bbbee","bread","f","1","fail","1000");

		   db.dbUpdate_orderList("orderList",6);
			db.SelectDB_all_sys(tree_list_all);
		   db.dbRemove_orderList("orderList");
		   db.dbRemove_orderList("orderList",5);
		db.SelectDB_all_sys(tree_list_all);
	}
}
