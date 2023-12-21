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

public class updateDoctorController2 implements Initializable {

    @FXML
    private Button backButton, updateData;
    @FXML
    private TextField name, specialize, contact, address;
    Connect connect = Connect.getinstance();

    public void handleBackClick() {
        navigateTo("updateDoctorPage1.fxml", backButton);
    }

    public void handleUpdateDataClick() {
        String id = updateDoctorController1.id;

        // Check if all fields are empty
        if (name.getText().isEmpty() && specialize.getText().isEmpty() && contact.getText().isEmpty() && address.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Input Error");
            alert.setContentText("Please fill in at least one field.");
            alert.showAndWait();
            return;
        }

        try {
            // Prepare the update query
            StringBuilder updateQuery = new StringBuilder("UPDATE Dokter SET ");

            if (!name.getText().isEmpty()) {
                updateQuery.append("Nama_Dokter = '").append(name.getText()).append("', ");
            }
            if (!specialize.getText().isEmpty()) {
                updateQuery.append("Spesialisasi = '").append(specialize.getText()).append("', ");
            }
            if (!contact.getText().isEmpty()) {
                updateQuery.append("Nomor_Kontak = '").append(contact.getText()).append("', ");
            }
            if (!address.getText().isEmpty()) {
                updateQuery.append("Alamat_Praktik = '").append(address.getText()).append("', ");
            }

            // Remove the last comma and space
            updateQuery.setLength(updateQuery.length() - 2);

            updateQuery.append(" WHERE ID_Dokter = '").append(id).append("'");

            // Execute the update query
            connect.executeupdate(updateQuery.toString());

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Update Success");
            alert.setContentText("Doctor data has been updated.");
            alert.showAndWait();
            navigateTo("mainpage.fxml", updateData);
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