package doc_hunter;

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
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class updateDoctorController1 implements Initializable {

    @FXML
    private Button backButton, proceedButton;
    @FXML
    private TextField idField;
    public static String id;
    Connect connect = Connect.getinstance();

    public void handleBackClick() {
        navigateTo("managedoctorpage.fxml", backButton);
    }

    public void handleProceedButtonClick() {
        id = idField.getText().trim();

        // Validate inputs
        if (id.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Input Error");
            alert.setContentText("Please fill in the ID field.");
            alert.showAndWait();
            return;
        }

        try {
            Integer.parseInt(id);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Input Error");
            alert.setContentText("Please Input ID Using Number.");
            alert.showAndWait();
            return;
        }

        try {
            // Check if ID exists in the database
            String checkQuery = "SELECT COUNT(*) FROM Dokter WHERE ID_Dokter = '" + id + "'";
            ResultSet resultSet = connect.executequery(checkQuery);
            if (!resultSet.next() || resultSet.getInt(1) == 0) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Update Error");
                alert.setContentText("No data found with the provided ID.");
                alert.showAndWait();
                return;
            }

            // If ID exists, proceed to next scene
            navigateTo("updateDoctorPage2.fxml", proceedButton);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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