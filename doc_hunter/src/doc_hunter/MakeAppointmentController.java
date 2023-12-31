package doc_hunter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class MakeAppointmentController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private TextField idAppointmentField, idPatientField, idDoctorField, recipeField, diagnosticResultsField, statusField;
    @FXML
    private DatePicker dateAppointmentPicker;
    @FXML
    private Button makeAppointmentButton;
    Connect connect = Connect.getinstance();

    
    public void handleBackClick() {
    	navigateTo("mainpage.fxml", backButton);
    }
    
    
    public void handleMakeAppointmentClick() {
        String idAppointment = idAppointmentField.getText().trim();
        String idPatient = idPatientField.getText().trim();
        String idDoctor = idDoctorField.getText().trim();
        String recipe = recipeField.getText().trim();
        String status = statusField.getText().trim();
        String diagnosticResults = diagnosticResultsField.getText().trim();
        LocalDate dateAppointment = dateAppointmentPicker.getValue();

        // Validate inputs
        if (idAppointment.isEmpty() || idPatient.isEmpty() || idDoctor.isEmpty() || recipe.isEmpty() || diagnosticResults.isEmpty() || dateAppointment == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Input Error");
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }
        
        try {
            Integer.parseInt(idAppointment);
            Integer.parseInt(idPatient);
            Integer.parseInt(idDoctor);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Input Error");
            alert.setContentText("Please Input ID Using Number.");
            alert.showAndWait();
            return;
        }

        try {
            String query = "INSERT INTO Appointment (ID_Appointment, ID_Pasien, ID_Dokter, Tanggal_Waktu_Janji, Status_Janji, Hasil_Diagnosa, Resep_Obat) VALUES ('"
                    + idAppointment + "', '" + idPatient + "', '" + idDoctor + "', '" + dateAppointment+ "', '" + status + "', '" + diagnosticResults + "', '" + recipe + "')";
            connect.executeupdate(query);
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Thank you for input data!");
            alert.showAndWait();
            navigateTo("mainpage.fxml", makeAppointmentButton);
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
