package doc_hunter;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("landingpage.fxml"));
        Scene sceneLandingPage = new Scene(root, 1280, 720);
        primaryStage.setScene(sceneLandingPage);
        primaryStage.show();
    }
    
    private Scene loginPage1(Stage primaryStage) {
        // Create elements
        Label label = new Label("Please Login as");
        Button adminButton = new Button("Admin");
        Button userButton = new Button("User");

        // Set button actions
        adminButton.setOnAction(e -> primaryStage.setScene(loginPage2(primaryStage, "Admin")));
        userButton.setOnAction(e -> primaryStage.setScene(loginPage2(primaryStage, "User")));

        // Create layout and scene
        VBox layout = new VBox(10, label, adminButton, new Label("OR"), userButton);
        layout.setAlignment(Pos.CENTER);
        return new Scene(layout, 1280, 720);
    }

    private Scene loginPage2(Stage primaryStage, String userType) {
        // Create elements
        Label label = new Label("Login as " + userType);
        Label emailLabel = new Label("Email / Username:");
        TextField emailField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");

        // Set button action
        loginButton.setOnAction(e -> primaryStage.setScene(mainPage()));

        // Create layout and scene
        VBox layout = new VBox(10, label, emailLabel, emailField, passwordLabel, passwordField, loginButton);
        layout.setAlignment(Pos.CENTER);
        return new Scene(layout, 1280, 720);
    }

    private Scene signUpPage1(Stage primaryStage) {
        // Create elements
        Label label = new Label("Please Sign Up as");
        Button adminButton = new Button("Admin");
        Button userButton = new Button("User");

        // Set button actions
        adminButton.setOnAction(e -> primaryStage.setScene(signUpPage2(primaryStage, "Admin")));
        userButton.setOnAction(e -> primaryStage.setScene(signUpPage2(primaryStage, "User")));

        // Create layout and scene
        VBox layout = new VBox(10, label, adminButton, new Label("OR"), userButton);
        layout.setAlignment(Pos.CENTER);
        return new Scene(layout, 1280, 720);
    }

    private Scene signUpPage2(Stage primaryStage, String userType) {
        // Create elements
        Label label = new Label("Sign Up as " + userType);
        Label ktpLabel = new Label("Nomor KTP:");
        TextField ktpField = new TextField();
        Label nameLabel = new Label("Nama:");
        TextField nameField = new TextField();
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Label addressLabel = new Label("Alamat:");
        TextField addressField = new TextField();
        Label contactLabel = new Label("Nomor Kontak:");
        TextField contactField = new TextField();
        Button signUpButton = new Button("Sign Up");

        // Set button action
        signUpButton.setOnAction(e -> primaryStage.setScene(mainPage()));

        // Create layout and scene
        VBox layout = new VBox(10, label, ktpLabel, ktpField, nameLabel, nameField, emailLabel, emailField, passwordLabel, passwordField, addressLabel, addressField, contactLabel, contactField, signUpButton);
        layout.setAlignment(Pos.CENTER);
        return new Scene(layout, 1280, 720);
    }

    private Scene mainPage() {

    	MenuBar leftBar = new MenuBar();
    	leftBar.getMenus().addAll(new Menu("Manage Doctor"));
    	leftBar.setStyle("-fx-font-size: 14px;"); 

    	MenuBar CenterBar = new MenuBar();
    	CenterBar.getMenus().addAll(new Menu("Schedule"));
    	CenterBar.setStyle("-fx-font-size: 14px;"); 

    	MenuBar rightBar = new MenuBar();
    	rightBar.getMenus().addAll(new Menu("Patient"));
    	rightBar.setStyle("-fx-font-size: 14px;"); 
         Region spacer1 = new Region();
         Region spacer2 = new Region();
         spacer1.getStyleClass().add("menu-bar");
         spacer2.getStyleClass().add("menu-bar");
         HBox.setHgrow(spacer1, Priority.SOMETIMES);
         HBox.setHgrow(spacer2, Priority.SOMETIMES);
         HBox navbar = new HBox(leftBar, spacer1, CenterBar, spacer2,  rightBar);

         
        // Create main page elements
        Label welcomeLabel = new Label("Welcome to Doctor Hunter!");
        Button huntDoctorButton = new Button("Hunt Doctor");
        Button makeAppointmentButton = new Button("Make Appointment");
        Button appointmentHistoryButton = new Button("Appointment History");

     // Create HBox and set its alignment to center
        HBox buttonBox = new HBox(10, huntDoctorButton, makeAppointmentButton, appointmentHistoryButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Create main page layout
        VBox mainPageLayout = new VBox(10, welcomeLabel, buttonBox);
        mainPageLayout.setAlignment(Pos.CENTER);

        // Create layout and scene
        BorderPane layout = new BorderPane();
        layout.setTop(navbar);
        layout.setCenter(mainPageLayout);
        BorderPane.setAlignment(mainPageLayout, Pos.CENTER); // Center the VBox in the BorderPane
        return new Scene(layout, 1280, 720);
    }
    
    
    public static void main(String[] args) {
    	
        launch(args);
    }
}


