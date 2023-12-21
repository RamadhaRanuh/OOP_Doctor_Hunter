package doc_hunter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.text.Font;


public class Main extends Application {
	
	/*
    static Map<String, Customer> users = new HashMap<>();
    static Map<String, Customer> admins = new HashMap<>(); 
    static Map<String, Customer> customers = new HashMap<>(); // Customer data
    static List<FoodItem> food = new ArrayList<>(); // Food menu
    static List<DrinkItem> drinks = new ArrayList<>(); // Beverage menu
    static List<Order> orders = new ArrayList<>();
	*/
	
	
	
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("landingpage.fxml"));
        Scene sceneLandingPage = new Scene(root, 1280, 720);
        primaryStage.setScene(sceneLandingPage);
        primaryStage.show();
    }
    
    
    public static void main(String[] args) {
    	
        launch(args);
    }
}


