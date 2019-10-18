package application;

import java.awt.Button;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class NumberBoard {
	@FXML
	private Text result;
	
	@FXML
	private void operand(ActionEvent event) {
		if((result.getText()).equals("0")) {
//			result.setText("");
			result.setText(((javafx.scene.control.Button) event.getSource()).getText());
		}else {
			result.setText(result.getText() + ((javafx.scene.control.Button) event.getSource()).getText());
		}
	}
	
	@FXML
	private void operator(ActionEvent event) {
		if(((javafx.scene.control.Button) event.getSource()).getText().equals("+")) {			
			int number = Integer.parseInt(result.getText())+1;
			String str = Integer.toString(number);
			result.setText(str);
			
		}
		else if(((javafx.scene.control.Button) event.getSource()).getText().equals("-")) {
			int number = Integer.parseInt(result.getText())-1;
			if(number<=0) {
				number=0;
			}
			String str = Integer.toString(number);
			result.setText(str);
		}
		else if(((javafx.scene.control.Button) event.getSource()).getText().equals("Á¤Á¤")) {			
			result.setText("0");
		}
	}
}

