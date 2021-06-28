package com.bagdadi.javaapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {
	public static void main(String[] args){
		System.out.println("main");
          launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("initialization");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar=createMenu();
		//rootNode.getChildren().addAll(menuBar);
		rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TEMPERATURE CONVERTER TOOL");
		//primaryStage.setResizable(false);
		primaryStage.show();

	}
	private MenuBar createMenu(){
		//create file
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem= new MenuItem("New");
		newMenuItem.setOnAction(event -> System.out.println(" the new project occur"));
		MenuItem exitMenuItem = new MenuItem("Exit");
		exitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
	/*	use lambda as above
		exitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
				System.exit(0);
			}
		});*/
		SeparatorMenuItem separateMenuItem = new SeparatorMenuItem();
		fileMenu.getItems().addAll(newMenuItem,separateMenuItem,exitMenuItem);
		//create help
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("AboutApp");
		aboutApp.setOnAction(event -> {
			aboutApp();
		});
		helpMenu.getItems().addAll(aboutApp);
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;
	}
	private void aboutApp(){
		Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
		newAlert.setTitle("My first desktop app");
		newAlert.setHeaderText("Learning Javafx ");
		newAlert.setContentText("I am a PRO....Bagdadi ");
		ButtonType accept = new ButtonType("ACCEPT");
		ButtonType no = new ButtonType("NO");
		newAlert.getButtonTypes().setAll(accept,no);
        //newAlert.show();
	    Optional<ButtonType> clickedBtn= newAlert.showAndWait();
	    if(clickedBtn.isPresent()&&clickedBtn.get()==accept)
	    {
		    System.out.println(" accept button is clicked");
	    }
	    if(clickedBtn.isPresent()&&clickedBtn.get()==no)
	    {
		    System.out.println("no button id clicked");
	    }

	}

	@Override
	public void stop() throws Exception {
		System.out.println("stop");
		super.stop();
	}
}
