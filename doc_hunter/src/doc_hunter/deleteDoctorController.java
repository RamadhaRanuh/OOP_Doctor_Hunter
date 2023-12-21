package doc_hunter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class deleteDoctorController implements Initializable {

    @FXML
    private Button backButton, signupButton;
    @FXML
    private TextField idField;
    Connect connect = Connect.getinstance();

    public void handleBackClick() {
        navigateTo("managedoctorpage.fxml", backButton);
    }

    public void handleSignupButtonClick() {
        String id = idField.getText().trim();

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
                alert.setHeaderText("Delete Error");
                alert.setContentText("No data found with the provided ID.");
                alert.showAndWait();
                return;
            }

            // If ID exists, proceed with deletion
            String deleteQuery = "DELETE FROM Dokter WHERE ID_Dokter = '" + id + "'";
            connect.executeupdate(deleteQuery);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Data Deleted!");
            alert.showAndWait();
            navigateTo("managedoctorpage.fxml", signupButton);
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Database Error");
            alert.setContentText("An error occurred while processing your request.");
            alert.showAndWait();
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