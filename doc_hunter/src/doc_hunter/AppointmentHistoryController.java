package doc_hunter;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class AppointmentHistoryController implements Initializable {
	Connect connect = Connect.getinstance();
    @FXML
    private Button backButton;
    @FXML
    private TableView<Appointment> tableView;
    @FXML
    private TableColumn<Appointment, Integer> appointmentIdColumn;
    @FXML
    private TableColumn<Appointment, Integer> patientIdColumn;
    @FXML
    private TableColumn<Appointment, Integer> doctorIdColumn;
    @FXML
    private TableColumn<Appointment, String> appointmentDateColumn;
    @FXML
    private TableColumn<Appointment, String> statusColumn;
    @FXML
    private TableColumn<Appointment, String> resultsColumn;
    @FXML
    private TableColumn<Appointment, String> recipeColumn;

    
    public void handleBackClick() {
    	navigateTo("mainpage.fxml", backButton);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Bind the table columns to the properties of the Appointment model
        appointmentIdColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        patientIdColumn.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        doctorIdColumn.setCellValueFactory(new PropertyValueFactory<>("doctorId"));
        appointmentDateColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        resultsColumn.setCellValueFactory(new PropertyValueFactory<>("results"));
        recipeColumn.setCellValueFactory(new PropertyValueFactory<>("recipe"));

        // Create an ObservableList of Appointments and populate it with data from the database
        ObservableList<Appointment> appointments = FXCollections.observableArrayList();

        String query = "SELECT * FROM Appointment";
        connect.rs = connect.executequery(query);
        try {
            while(connect.rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointmentId(connect.rs.getInt("ID_Appointment"));
                appointment.setPatientId(connect.rs.getInt("ID_Pasien"));
                appointment.setDoctorId(connect.rs.getInt("ID_Dokter"));
                appointment.setAppointmentDate(connect.rs.getString("Tanggal_Waktu_Janji"));
                appointment.setStatus(connect.rs.getString("Status_Janji"));
                appointment.setResults(connect.rs.getString("Hasil_Diagnosa"));
                appointment.setRecipe(connect.rs.getString("Resep_Obat"));
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Set the items of the TableView to the ObservableList
        tableView.setItems(appointments);
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
