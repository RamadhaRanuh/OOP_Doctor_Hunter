package doc_hunter;

public class Patient extends Person {
    private String idPasien;
    private String namaPasien;
    private String alamat;
    private String nomorHP;
    
    public Patient(int id, String nama, String alamat, String nomorHP) {
        super(id, nama, alamat, nomorHP, null, null);
        this.idPasien = String.valueOf(id);
        this.namaPasien = nama;
        this.nomorHP = nomorHP;
        this.alamat = alamat;
    }
}
