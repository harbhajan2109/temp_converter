package com.bagdadi.javaapp;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.EventListener;
import java.util.ResourceBundle;

public class controller implements Initializable {
	@FXML
	public Label welcomeLabel;
	@FXML
	public Button buttonconvert;
	@FXML
	public ChoiceBox<String> choicebox;
	@FXML
	public TextField textfield;
	private static final String C_TO_F_TEXT = "Celcius to Farenheit";
	private static final String F_TO_C_TEXT = "Farenheit to Celcius";
	private boolean isC_TO_F = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choicebox.getItems().add(C_TO_F_TEXT);
		choicebox.getItems().add(F_TO_C_TEXT);
		choicebox.setValue(C_TO_F_TEXT);
		/*using lambda
		choicebox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println(newValue);
			}
		});*/
		choicebox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.equals(C_TO_F_TEXT)) {
				isC_TO_F = true;
			} else {
				isC_TO_F = false;
			}
		});
		buttonconvert.setOnAction(event -> {
			convert();
		});
	}

	private void convert() {
		String input = textfield.getText();
		float enteredTemp=0.0f;
		try{
		 enteredTemp = Float.parseFloat(input);
		}catch (Exception ex){
			warnUser();
			return;
		}
		float newTemp = 0.0f;
		if (isC_TO_F) {
			newTemp = (enteredTemp * 9 / 5) + 32;
		} else {
			newTemp = (enteredTemp - 32) * 5 / 9;
		}
		  display(newTemp);
	}

	private void warnUser() {
		Alert alert= new Alert(Alert.AlertType.ERROR);
		alert.setTitle("ERROR OCCURED");
		alert.setHeaderText("Invalid temperature enterd ");
		alert.setContentText("Enter valid temperature ");
		alert.show();

	}

	private void display(float newTemp) {
		String unit = isC_TO_F? "F":"C";
		System.out.println("The new temp is: " + newTemp + unit);
		Alert alert= new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("RESULT");
		alert.setContentText("The new temp is: " + newTemp + unit);
		alert.show();

	}
}
