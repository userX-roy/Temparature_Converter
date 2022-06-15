package application;

import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyMain extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init() throws Exception { //Initialize our application
		System.out.println("Execution Start");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Application Started");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("LayOut.fxml"));
		Pane rootNode = loader.load();
		
		MenuBar menuBar = createMenu();
		
		rootNode.getChildren().addAll(menuBar);

	    Scene scene = new Scene(rootNode, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.setResizable(true);
		primaryStage.setTitle("JavaFX Application");
		primaryStage.show();
		
	}
	
	private MenuBar createMenu() {
		
		//File Menu
		Menu fileMenu = new Menu("File");
		
		//creating options under File menu
		MenuItem newMenuItem = new MenuItem("New file");
		
		//To draw a separate line between two Item
		
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		
		MenuItem quitMenuItem = new MenuItem("Quit");
		
		//adding "NewFile" and "Quit" options inside FileMenu
		fileMenu.getItems().addAll(newMenuItem , separatorMenuItem , quitMenuItem);
		
		//Quit and NewFile click Handling Code
		newMenuItem.setOnAction(/*LAMDA expression*/arg0 -> System.out.println("New File option clicked"));
		
		quitMenuItem.setOnAction(arg0 -> {
			System.out.println("Closing the Application");
			
			Platform.exit(); //exit the app
			
			System.exit(0); //exit the JVM
			
		});
		
		//Help Menu
		Menu helpMenu = new Menu("Help");
		
		MenuItem abouItem = new MenuItem("About");
		helpMenu.getItems().addAll(abouItem);
		
		//About click Handling Code
		
		abouItem.setOnAction(event -> aboutApp());
		
		//The MenuBar creation
		MenuBar menuBar = new MenuBar();
		
		menuBar.getMenus().addAll(fileMenu , helpMenu);
		
		return menuBar;
		
	}
	
	private void aboutApp() {
		Alert aleartDio = new Alert(AlertType.INFORMATION);
		
		aleartDio.setTitle("About JavaFx Application");
		aleartDio.setHeaderText("My first Desktop Application");
		aleartDio.setContentText("This app is made with JavaFX , using openJDK 11 , Features will be added later");
		aleartDio.setHeight(200);
		aleartDio.setWidth(300);
		aleartDio.setResizable(true);
		
		ButtonType yesType = new ButtonType("Yes");
		ButtonType noType = new ButtonType("No");
		aleartDio.getButtonTypes().setAll(yesType, noType);
		
		Optional<ButtonType> clickedButton = aleartDio.showAndWait();
		if (clickedButton.isPresent() && clickedButton.get() == yesType) {
			System.out.println("Yes button clicked");
			
		} else {
			
			System.out.println("No button clicked");

		}
	
	}

	@Override
	public void stop() throws Exception {
		System.out.println("Application Killed");//calls when application stops and about to shut down
		super.stop();
	}

}