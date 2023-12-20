package doc_hunter;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class SignupPageController2 implements Initializable {
	
	@FXML
	private TextField idField, usernameField, emailField, passwordField, addressField, phoneNumberField;
    @FXML
    private Button signupButton;

    @FXML
    private Button backButton;


    
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    public void handleSignUpButtonClick() {
    	
    	
    	 if (idField.getText().trim().isEmpty() ||
    		        usernameField.getText().trim().isEmpty() ||
    		        emailField.getText().trim().isEmpty() ||
    		        passwordField.getText().trim().isEmpty() ||
    		        addressField.getText().trim().isEmpty() ||
    		        phoneNumberField.getText().trim().isEmpty()) {

    		        // Show error alert
    		        Alert alert = new Alert(AlertType.ERROR);
    		        alert.setTitle("Error Dialog");
    		        alert.setHeaderText("Input Error");
    		        alert.setContentText("Please fill in all fields.");
    		        alert.showAndWait();
    		    }
    	
    	

    	
        if (SignupPage1Controller.userType.equals("admin")) {
            int id = Integer.parseInt(idField.getText().trim());

            // Get other field values
            String nama = usernameField.getText().trim();
            String alamat = addressField.getText().trim();
            String nomorHP = phoneNumberField.getText().trim();
            String email = emailField.getText().trim();
            String password = passwordField.getText().trim();

            // Create new Admin instance
            Admin admin = new Admin(id, nama, alamat, nomorHP, email, password);
        } 
        
        else if (SignupPage1Controller.userType.equals("user")) {
            int id = Integer.parseInt(idField.getText().trim());

            // Get other field values
            String nama = usernameField.getText().trim();
            String alamat = addressField.getText().trim();
            String nomorHP = phoneNumberField.getText().trim();
            String email = emailField.getText().trim();
            String password = passwordField.getText().trim();

            // Create new Admin instance
            User user = new User(id, nama, alamat, nomorHP, email, password);
        }
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Thank you for input data!");
        alert.showAndWait();
        navigateTo("landingpage.fxml", signupButton);
    }

    
    public void handleBackClick() {
    	navigateTo("signuppage1.fxml", backButton);
    }
    


    private void navigateTo(String fxmlFile, Button button) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Scene scene = new Scene(root, 1280, 720);
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
