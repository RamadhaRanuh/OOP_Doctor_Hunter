package doc_hunter;

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

public class PatientController implements Initializable {
	Connect connect = Connect.getinstance();
    @FXML
    private Button backButton;
    @FXML
    private TableView<Patient> tableView;
    @FXML
    private TableColumn<Patient, Integer> idPasienColumn;
    @FXML
    private TableColumn<Patient, String> namaPasienColumn;
    @FXML
    private TableColumn<Patient, String> alamatColumn;
    @FXML
    private TableColumn<Patient, String> nomorHPColumn;

    
    public void handleBackClick() {
    	navigateTo("mainpage.fxml", backButton);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Bind the table columns to the properties of the Patient model
        idPasienColumn.setCellValueFactory(new PropertyValueFactory<>("idPasien"));
        namaPasienColumn.setCellValueFactory(new PropertyValueFactory<>("namaPasien"));
        alamatColumn.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        nomorHPColumn.setCellValueFactory(new PropertyValueFactory<>("nomorHP"));

        // Create an ObservableList of Patients and populate it with data from the database
        ObservableList<Patient> patients = FXCollections.observableArrayList();

        String query = "SELECT * FROM Pasien";
        connect.rs = connect.executequery(query);
        try {
            while(connect.rs.next()) {
                Patient patient = new Patient();
                patient.setIdPasien(Integer.toString(connect.rs.getInt("ID_Pasien")));
                patient.setNamaPasien(connect.rs.getString("Nama_Pasien"));
                patient.setAlamat(connect.rs.getString("Alamat"));
                patient.setNomorHP(connect.rs.getString("Nomor_Kontak"));
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Set the items of the TableView to the ObservableList
        tableView.setItems(patients);
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
