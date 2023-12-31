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

public class LandingPageController implements Initializable {
    @FXML
    private Button loginButton;
    @FXML
    private Button signupButton;

    @FXML
    public void handleLoginButtonClick() {
        navigateTo("loginpage1.fxml", loginButton);
    }

    @FXML
    public void handleSignupButtonClick() {
        navigateTo("signuppage1.fxml", signupButton);
    }

    public void handleExitClick() {
        Platform.exit();
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
