package doc_hunter;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class MainPageController implements Initializable {

	   @FXML
	    private Node backButton;
	    @FXML
	    private Node huntDoctorButton;
	    @FXML
	    private Node makeAppointmentButton;
	    @FXML
	    private Node appointmentHistoryButton;
	    @FXML
	    private Node manageDoctorButton;
	    @FXML
	    private Node scheduleButton;
	    @FXML
	    private Node patientButton;


    
    public void handleBackClick() {
    	navigateTo("landingpage.fxml", backButton);
    }
    
    public void handleHuntDoctorClick() {
    	navigateTo("huntdoctorpage.fxml", huntDoctorButton);
    }
    
    public void handleMakeAppointmentClick() {
    	navigateTo("makeappointmentpage.fxml", makeAppointmentButton);
    }
    
    public void handleAppointmentHistoryClick() {
    	navigateTo("appointmenthistorypage.fxml", appointmentHistoryButton);
    }
    
    public void handleManageDoctorClick() {
        navigateTo("managedoctorpage.fxml", manageDoctorButton);
    }

    public void handleScheduleClick() {
        navigateTo("schedulepage.fxml", scheduleButton);
    }

    public void handlePatientClick() {
        navigateTo("patientpage.fxml", patientButton);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void navigateTo(String fxmlFile, Node node) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Scene scene = new Scene(root, 1280, 720);
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
