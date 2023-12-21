package doc_hunter;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Patient {
    private SimpleIntegerProperty idPasien;
    private SimpleStringProperty namaPasien;
    private SimpleStringProperty alamat;
    private SimpleStringProperty nomorHP;

    public Patient() {
        this.idPasien = new SimpleIntegerProperty();
        this.namaPasien = new SimpleStringProperty();
        this.alamat = new SimpleStringProperty();
        this.nomorHP = new SimpleStringProperty();
    }

    public int getIdPasien() {
        return idPasien.get();
    }

    public void setIdPasien(String idPasien) {
        this.idPasien.set(Integer.parseInt(idPasien));
    }

    public String getNamaPasien() {
        return namaPasien.get();
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien.set(namaPasien);
    }

    public String getAlamat() {
        return alamat.get();
    }

    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
    }

    public String getNomorHP() {
        return nomorHP.get();
    }

    public void setNomorHP(String nomorHP) {
        this.nomorHP.set(nomorHP);
    }
}