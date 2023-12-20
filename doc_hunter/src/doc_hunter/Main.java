package doc_hunter;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create labels
        Label welcomeLabel = new Label("Welcome to Doctor Hunter!");
        Label loginLabel = new Label("Please login / sign up!");

        // Create buttons
        Button loginButton = new Button("Login");
        Button signupButton = new Button("Sign Up");

        // Create layout and add elements
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(welcomeLabel, loginLabel, loginButton, new Label("OR"), signupButton);

        // Create scene and set it to stage
        Scene sceneLandingPage = new Scene(layout, 1280, 720);
        primaryStage.setScene(sceneLandingPage);
        primaryStage.show();

        
        // Add action listeners to buttons
        loginButton.setOnAction(e -> primaryStage.setScene(loginPage1(primaryStage)));
        signupButton.setOnAction(e -> primaryStage.setScene(signUpPage1(primaryStage)));
        

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
        // Create navbar elements
        Menu manageDoctorMenu = new Menu("Manage Doctor");
        Menu doctorScheduleMenu = new Menu("Doctor's Schedule");
        Menu patientMenu = new Menu("Patient");

        // Create navbar layout
        MenuBar navbar = new MenuBar(manageDoctorMenu, doctorScheduleMenu, patientMenu);

        // Create main page elements
        Label welcomeLabel = new Label("Welcome to Doctor Hunter!");
        Button huntDoctorButton = new Button("Hunt Doctor");
        Button makeAppointmentButton = new Button("Make Appointment");
        Button appointmentHistoryButton = new Button("Appointment History");

        // Create main page layout
        VBox mainPageLayout = new VBox(10, welcomeLabel, new HBox(10, huntDoctorButton, makeAppointmentButton, appointmentHistoryButton));
        mainPageLayout.setAlignment(Pos.CENTER);

        // Create layout and scene
        BorderPane layout = new BorderPane();
        layout.setTop(navbar);
        layout.setCenter(mainPageLayout);
        return new Scene(layout, 1280, 720);
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}


