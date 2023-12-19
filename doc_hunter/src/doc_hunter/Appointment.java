package doc_hunter;

public class Appointment {
    private int idAppointment;
    private int idPasien;
    private int idDokter;
    private String tanggalWaktuJanji;
    private String statusJanji;
    private String hasilDiagnosa;
    private String resepObat;

    public Appointment(int idAppointment, int idPasien, int idDokter, String tanggalWaktuJanji, String statusJanji, String hasilDiagnosa, String resepObat) {
        this.idAppointment = idAppointment;
        this.idPasien = idPasien;
        this.idDokter = idDokter;
        this.tanggalWaktuJanji = tanggalWaktuJanji;
        this.statusJanji = statusJanji;
        this.hasilDiagnosa = hasilDiagnosa;
        this.resepObat = resepObat;
    }
}
