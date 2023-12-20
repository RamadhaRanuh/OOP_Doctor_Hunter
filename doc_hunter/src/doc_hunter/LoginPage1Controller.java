package doc_hunter;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class LoginPage1Controller implements Initializable {
    @FXML
    private Button adminButton;
    @FXML
    private Button userButton;
    @FXML
    private Button backButton;

    
    @FXML
    public void handleAdminButtonClick() {
        navigateTo("loginpage2.fxml", adminButton);
    }

    @FXML
    public void handleUserButtonClick() {
        navigateTo("loginpage2.fxml", userButton);
    }
    
    public void handleBackClick() {
    	navigateTo("landingpage.fxml", backButton);
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
