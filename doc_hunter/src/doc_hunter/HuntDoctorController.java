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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class HuntDoctorController implements Initializable {
    Connect connect = Connect.getinstance();
    @FXML
    private Button backButton;
    @FXML
    private TableView<Doctor> tableView;
    @FXML
    private TableColumn<Doctor, Integer> idDokterColumn;
    @FXML
    private TableColumn<Doctor, String> namaDokterColumn;
    @FXML
    private TableColumn<Doctor, String> spesialisasiColumn;
    @FXML
    private TableColumn<Doctor, String> nomorHPColumn;
    @FXML
    private TableColumn<Doctor, String> alamatColumn;
    @FXML
    private TextField searchField;

    public void handleBackClick() {
        navigateTo("mainpage.fxml", backButton);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idDokterColumn.setCellValueFactory(new PropertyValueFactory<>("idDoctor"));
        namaDokterColumn.setCellValueFactory(new PropertyValueFactory<>("namaDoctor"));
        spesialisasiColumn.setCellValueFactory(new PropertyValueFactory<>("spesialisasi"));
        nomorHPColumn.setCellValueFactory(new PropertyValueFactory<>("nomorHP"));
        alamatColumn.setCellValueFactory(new PropertyValueFactory<>("alamat"));

        populateTable("SELECT * FROM Dokter");
    }

    @FXML
    private void handleSearchClick() {
        String doctorId = searchField.getText();
        String query;
        if(doctorId == null || doctorId.trim().isEmpty())
        {
            query = "SELECT * FROM Dokter";
        }
        else
        {
            query = "SELECT * FROM Dokter WHERE Nama_Dokter = " + '"' +  doctorId + '"';
        }
        populateTable(query);
    }

    private void populateTable(String query) {
        ObservableList<Doctor> doctors = FXCollections.observableArrayList();
        connect.rs = connect.executequery(query);
        try {
            while(connect.rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setIdDoctor(Integer.toString(connect.rs.getInt("ID_Dokter")));
                doctor.setNamaDoctor(connect.rs.getString("Nama_Dokter"));
                doctor.setSpesialisasi(connect.rs.getString("Spesialisasi"));
                doctor.setNomorHP(connect.rs.getString("Nomor_Kontak"));
                doctor.setAlamat(connect.rs.getString("Alamat_Praktik"));
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tableView.setItems(doctors);
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