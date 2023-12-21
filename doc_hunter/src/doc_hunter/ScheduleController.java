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

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;

public class ScheduleController implements Initializable {
    Connect connect = Connect.getinstance();
    @FXML
    private Button backButton;
    @FXML
    private TableView<Schedule> tableView;
    @FXML
    private TableColumn<Schedule, Integer> idJadwalColumn;
    @FXML
    private TableColumn<Schedule, Integer> idDokterColumn;
    @FXML
    private TableColumn<Schedule, String> hariPraktikColumn;
    @FXML
    private TableColumn<Schedule, String> jamMulaiPraktikColumn;
    @FXML
    private TableColumn<Schedule, String> jamSelesaiPraktikColumn;
    @FXML
    private TextField searchField;

    public void handleBackClick() {
        navigateTo("mainpage.fxml", backButton);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idJadwalColumn.setCellValueFactory(new PropertyValueFactory<>("idJadwal"));
        idDokterColumn.setCellValueFactory(new PropertyValueFactory<>("idDokter"));
        hariPraktikColumn.setCellValueFactory(new PropertyValueFactory<>("hariPraktik"));
        jamMulaiPraktikColumn.setCellValueFactory(new PropertyValueFactory<>("jamMulaiPraktik"));
        jamSelesaiPraktikColumn.setCellValueFactory(new PropertyValueFactory<>("jamSelesaiPraktik"));

        ObservableList<Schedule> schedules = FXCollections.observableArrayList();

        String query = "SELECT * FROM Schedule";
        connect.rs = connect.executequery(query);
        try {
            while(connect.rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setIdJadwal(Integer.toString(connect.rs.getInt("ID_Jadwal")));
                schedule.setIdDokter(Integer.toString(connect.rs.getInt("ID_Dokter")));
                schedule.setHariPraktik(connect.rs.getString("Hari_Praktik"));
                schedule.setJamMulaiPraktik(connect.rs.getString("Jam_Mulai_Praktik"));
                schedule.setJamSelesaiPraktik(connect.rs.getString("Jam_Selesai_Praktik"));
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tableView.setItems(schedules);
    }
    
    
    @FXML
    private void handleSearchClick() {
    	String scheduleId = searchField.getText();
        ObservableList<Schedule> data = FXCollections.observableArrayList();
        String query = "SELECT * FROM Schedule WHERE ID_Jadwal = " + scheduleId;
        connect.rs = connect.executequery(query);
        
        try
        {
        	while (connect.rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setIdJadwal(connect.rs.getString("ID_Jadwal"));
                schedule.setIdDokter(connect.rs.getString("ID_Dokter"));
                schedule.setHariPraktik(connect.rs.getString("Hari_Praktik"));
                schedule.setJamMulaiPraktik(connect.rs.getString("Jam_Mulai_Praktik"));
                schedule.setJamSelesaiPraktik(connect.rs.getString("Jam_Selesai_Praktik"));
                data.add(schedule);
            }

            tableView.setItems(data);
        }
        catch (SQLException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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