package doc_hunter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginPage2Controller implements Initializable {
    @FXML
    private Button loginButton;

    @FXML
    private Button backButton;
    
    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;
    Connect connect = Connect.getinstance();
    
    @FXML
    public void handleLoginButtonClick() {
        if(emailField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty()) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }

        String emailOrName = emailField.getText().trim();
        String password = passwordField.getText().trim();

        if (LoginPage1Controller.userType.equals("admin")) {
            try {
            	String query = "SELECT * FROM admins WHERE (email = ? OR Nama_admin = ?) AND passwords = ?";
            	PreparedStatement preparedStatement = connect.prepareStatement(query);
            	preparedStatement.setString(1, emailOrName);
            	preparedStatement.setString(2, emailOrName);
            	preparedStatement.setString(3, password);
            	connect.rs = preparedStatement.executeQuery();
                if (!connect.rs.next()) {
                    showAlert("Error", "Invalid email or password.");
                    return;
                }
                
                else
                {
                	navigateTo("mainpage.fxml", loginButton);
                }
            } 
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        } else if (LoginPage1Controller.userType.equals("user")) {
            try {
            	String query = "SELECT * FROM users WHERE (email = ? OR Nama_user = ?) AND passwords = ?";
            	PreparedStatement preparedStatement = connect.prepareStatement(query);
            	preparedStatement.setString(1, emailOrName);
            	preparedStatement.setString(2, emailOrName);
            	preparedStatement.setString(3, password);
            	connect.rs = preparedStatement.executeQuery();
                if (!connect.rs.next()) {
                    showAlert("Error", "Invalid email or password.");
                    return;
                }
                
                else
                {
                	navigateTo("mainpage.fxml", loginButton);
                }
            } 
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }

        
    }
    
    public void handleBackClick() {
    	navigateTo("loginpage1.fxml", backButton);
    }
    
    public void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
