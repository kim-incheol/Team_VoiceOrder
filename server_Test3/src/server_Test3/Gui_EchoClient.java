package server_Test3;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

class ClientFrame extends JFrame implements ActionListener { 
	// Client UI
	JButton but_input =new JButton("입력");
	private JTextArea textArea=new JTextArea();
	private JTextField nameField=new JTextField();
	private JTextField textField = new JTextField();
	
	// out , in 설정 
	static PrintWriter writer = null; 
	static BufferedReader reader = null; 
	
	public ClientFrame() { 
		setSize(740, 440); 
		setTitle("고객 창"); 
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
		if (arg0.getSource() == but_input) { 
			String s = nameField.getText()+" : " + textField.getText(); 	// 닉네임 : 채팅
			textArea.append(s+"\n"); 	// 채팅창에 출력
			writer.println(s); 			// 쓰기(output)
			textField.setText(""); 		// 입력창 초기화
		} 
	} 
	
	public void client() throws IOException { 
		Socket socket = null; 
		try { 
			socket = new Socket("192.168.0.40", 5555); 	// 서버 구축한 PC IP 입력, 소켓 열기ㄴ
			writer = new PrintWriter(socket.getOutputStream(), true); 	// 쓰기
			reader = new BufferedReader(new InputStreamReader( socket.getInputStream()));	// 읽기 
			} catch (UnknownHostException e) { 
				System.err.println("localhost에 접근할 수 없습니다."); 
				System.exit(1); 	// UI종료
			} catch (IOException eg) { 
					System.err.println("입출력 오류"); 
					System.exit(1);  // UI종료
			} 
		
		String fromServer; 
		
		while ((fromServer = reader.readLine()) != null) { 		// 한 줄씩 읽기
			String s =fromServer+"\n"; 
			System.out.println(s); 
			textArea.append(s); 
			System.out.println(fromServer); 
			if (fromServer.equals("quit")) 
				break; 
			} 
		writer.close(); 	// 종료
		reader.close(); 	// 종료
		socket.close(); 	// 종료
		} 
	}

	public class Gui_EchoClient {
		public static void main(String[] args) throws IOException{
			ClientFrame f = new ClientFrame(); 
			f.client();
	}
}
