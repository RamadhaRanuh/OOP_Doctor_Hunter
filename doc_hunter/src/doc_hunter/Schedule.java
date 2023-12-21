package doc_hunter;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Schedule {
    private SimpleIntegerProperty idJadwal;
    private SimpleIntegerProperty idDokter;
    private SimpleStringProperty hariPraktik;
    private SimpleStringProperty jamMulaiPraktik;
    private SimpleStringProperty jamSelesaiPraktik;

    public Schedule() {
        this.idJadwal = new SimpleIntegerProperty();
        this.idDokter = new SimpleIntegerProperty();
        this.hariPraktik = new SimpleStringProperty();
        this.jamMulaiPraktik = new SimpleStringProperty();
        this.jamSelesaiPraktik = new SimpleStringProperty();
    }

    public int getIdJadwal() {
        return idJadwal.get();
    }

    public void setIdJadwal(String idJadwal) {
        this.idJadwal.set(Integer.parseInt(idJadwal));
    }

    public int getIdDokter() {
        return idDokter.get();
    }

    public void setIdDokter(String idDokter) {
        this.idDokter.set(Integer.parseInt(idDokter));
    }

    public String getHariPraktik() {
        return hariPraktik.get();
    }

    public void setHariPraktik(String hariPraktik) {
        this.hariPraktik.set(hariPraktik);
    }

    public String getJamMulaiPraktik() {
        return jamMulaiPraktik.get();
    }

    public void setJamMulaiPraktik(String jamMulaiPraktik) {
        this.jamMulaiPraktik.set(jamMulaiPraktik);
    }

    public String getJamSelesaiPraktik() {
        return jamSelesaiPraktik.get();
    }

    public void setJamSelesaiPraktik(String jamSelesaiPraktik) {
        this.jamSelesaiPraktik.set(jamSelesaiPraktik);
    }
}