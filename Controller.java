package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

	@FXML
	public Label nameLabel;
	@FXML
	public ChoiceBox<String> choiceBox;
	@FXML
	public TextField userInput;	
	@FXML
	public Button convertButton;
	
	private boolean isTrue = true;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		convertButton.setOnAction(event -> {
			convert();
		});
		
		choiceBox.getItems().add("Celcius to Fahrenheit");
		choiceBox.getItems().add("Fahrenheit to Celcius");
		choiceBox.setValue("Celcius to Fahrenheit");
		
		choiceBox.getSelectionModel().selectedItemProperty().addListener((ChangeListener<String>) (arg01, arg11, arg2) -> {
			
		if (arg2.equals("Celcius to Fahrenheit")) {
			isTrue = true;
		}
		
		else {
			isTrue = false;
		}
		
		});
	}

	private void convert() {
		
		String inputString = userInput.getText();
		float enteredTemp = 0.0f;
		try {
			enteredTemp = Float.parseFloat(inputString);
		} catch (Exception e) {
			warnUser();
			return;
		}
		
		float newTemp = 0.0f;
		if (isTrue==true) {
			newTemp = (enteredTemp*9/5) + 32;
		}
		
		else {
			 newTemp = (enteredTemp - 32)*9/5;
		}
		displayTemp(newTemp);
	}

	private void warnUser() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERROR");
		alert.setHeaderText("Invalid Input");
		alert.setContentText("Enter a Correct value");
		alert.show();
		
	}

	private void displayTemp(float newTemp) {
        
		String unit = isTrue ? " F" : " C";
		
		Alert alertDio = new Alert(AlertType.INFORMATION);
		alertDio.setTitle("Temp Conversion result");
		alertDio.setHeaderText("Message");
		
		alertDio.setContentText("The temp is "+newTemp+" "+unit);
		alertDio.show();
	}

}