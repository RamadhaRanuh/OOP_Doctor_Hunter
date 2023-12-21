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
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class addDoctorController implements Initializable {

    @FXML
    private Button backButton, addData;
    @FXML
    private TextField idField, usernameField, specializationField, contactNumberField, addressField;
    Connect connect = Connect.getinstance();

    public void handleBackClick() {
        navigateTo("managedoctorpage.fxml", backButton);
    }

    public void handleAddDataClick() {
        String id = idField.getText().trim();
        String username = usernameField.getText().trim();
        String specialization = specializationField.getText().trim();
        String contactNumber = contactNumberField.getText().trim();
        String address = addressField.getText().trim();

        // Validate inputs
        if (id.isEmpty() || username.isEmpty() || specialization.isEmpty() || contactNumber.isEmpty() || address.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Input Error");
            alert.setContentText("Please fill in all fields.");
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
            String query = "INSERT INTO Dokter (ID_Dokter, Nama_Dokter, Spesialisasi, Nomor_Kontak, Alamat_Praktik) VALUES ('"
                    + id + "', '" + username + "', '" + specialization + "', '" + contactNumber + "', '" + address + "')";
            connect.executeupdate(query);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Thank you for input data!");
            alert.showAndWait();
            navigateTo("managedoctorpage.fxml", addData);
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