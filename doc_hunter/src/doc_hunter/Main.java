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


