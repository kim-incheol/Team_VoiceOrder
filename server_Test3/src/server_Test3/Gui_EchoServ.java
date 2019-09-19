package server_Test3;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

class SFrame extends JFrame implements ActionListener{
	// Server UI
	JButton but_input= new JButton("입력");	
	private JTextArea textArea=new JTextArea();
	private JTextField nameField=new JTextField("주인장");
	private JTextField textField = new JTextField(); 
	
	static ServerSocket serverSocket = null; 
	static Socket clientSocket =null; 
	static PrintWriter writer; 		// output
	static BufferedReader reader; 	// input
	static String inputLine, outputLine; 
	
	public SFrame(){ 
		setSize(740, 440); 
		setTitle("POS 창"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		
		textArea.setBounds(10, 10, 700, 300);
		add(textArea);
		nameField.setBounds(10, 320, 200, 30);
		add(nameField);
		textField.setBounds(10, 360, 600, 30);
		add(textField);
		but_input.setBounds(630, 360, 70, 30);
		add(but_input);
		but_input.addActionListener(this);  
	} 
	
	@Override public void actionPerformed(ActionEvent arg0) { 	// 입력 버튼 기능
		String s; 
		s=nameField.getText()+" : "+textField.getText(); 	// 닉네임 : 채팅
		if(arg0.getSource()==but_input){ 
			textArea.append(s+"\n"); 	// 채팅창에 출력
			writer.println(s); 			// 쓰기(output)
			textField.setText(""); 		// 입력창 초기화
			} 
//		if(arg0.getSource()==button){ 
//		} 
	} 
	
	public void serverStart() throws IOException{ 
		System.out.println("서버 시작!"); 
		
		try{ 
			serverSocket = new ServerSocket(5555); 	// 5555포트로 된 서버 오픈
		}catch(IOException e){ 
			System.out.println("다음의 포트 번호에 연결할 수 없습니다 : 5555"); 
			System.exit(1); 	// UI종료
		} 
		
		clientSocket = null; // 소켓
		
		try{ 
			clientSocket = serverSocket.accept(); 	// 서버소켓 대기
		}catch(IOException e){ 
			System.err.println("accept() 실패 "); 
			System.exit(1); 	// 종료
		} 
		
		writer = new PrintWriter(clientSocket.getOutputStream(),true); 	// 쓰기
		reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));	// 읽기 
		
		// 서버 연결시 출력되는 문구
		outputLine = "카페 : 무엇을 도와드릴까요?"; 	
		writer.println(outputLine); 
		textArea.append("서버 메시지 : 고갱님의 도움요청.\n"); 		
		
		while((inputLine = reader.readLine())!=null){ 	// 한 줄씩 읽기
			String s =inputLine+"\n"; 	// s 스트링변수에 저장
			System.out.println(s); 		
			textArea.append(s); 		// 채팅창에 출력
			//outputLine = inputLine; 
			//out.println(outputLine); 
			if(outputLine.equals("quit")) 
				break; 
		} 
	}
}

public class Gui_EchoServ {
	public static void main(String[] args) throws IOException{
		SFrame f = new SFrame(); 
		f.serverStart(); 
	}
}
