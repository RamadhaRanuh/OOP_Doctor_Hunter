package doc_hunter;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Appointment {
    private SimpleIntegerProperty appointmentId;
    private SimpleIntegerProperty patientId;
    private SimpleIntegerProperty doctorId;
    private SimpleStringProperty appointmentDate;
    private SimpleStringProperty status;
    private SimpleStringProperty results;
    private SimpleStringProperty recipe;

    public Appointment() {
        this.appointmentId = new SimpleIntegerProperty();
        this.patientId = new SimpleIntegerProperty();
        this.doctorId = new SimpleIntegerProperty();
        this.appointmentDate = new SimpleStringProperty();
        this.status = new SimpleStringProperty();
        this.results = new SimpleStringProperty();
        this.recipe = new SimpleStringProperty();
    }

    public int getAppointmentId() {
        return appointmentId.get();
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId.set(appointmentId);
    }

    public int getPatientId() {
        return patientId.get();
    }

    public void setPatientId(int patientId) {
        this.patientId.set(patientId);
    }

    public int getDoctorId() {
        return doctorId.get();
    }

    public void setDoctorId(int doctorId) {
        this.doctorId.set(doctorId);
    }

    public String getAppointmentDate() {
        return appointmentDate.get();
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate.set(appointmentDate);
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getResults() {
        return results.get();
    }

    public void setResults(String results) {
        this.results.set(results);
    }

    public String getRecipe() {
        return recipe.get();
    }

    public void setRecipe(String recipe) {
        this.recipe.set(recipe);
    }
}
