package doc_hunter;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Doctor {
    private SimpleIntegerProperty idDoctor;
    private SimpleStringProperty namaDoctor;
    private SimpleStringProperty spesialisasi;
    private SimpleStringProperty nomorHP;
    private SimpleStringProperty alamat;

    public Doctor() {
        this.idDoctor = new SimpleIntegerProperty();
        this.namaDoctor = new SimpleStringProperty();
        this.spesialisasi = new SimpleStringProperty();
        this.nomorHP = new SimpleStringProperty();
        this.alamat = new SimpleStringProperty();
    }

    public int getIdDoctor() {
        return idDoctor.get();
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor.set(Integer.parseInt(idDoctor));
    }

    public String getNamaDoctor() {
        return namaDoctor.get();
    }

    public void setNamaDoctor(String namaDoctor) {
        this.namaDoctor.set(namaDoctor);
    }

    public String getSpesialisasi() {
        return spesialisasi.get();
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi.set(spesialisasi);
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