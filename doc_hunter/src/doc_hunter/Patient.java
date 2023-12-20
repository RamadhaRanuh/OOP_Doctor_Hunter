package doc_hunter;

public class Patient extends Person {
    private String informasiLain;

    public Patient(int id, String nama, String alamat, String nomorHP, String informasiLain) {
        super(id, nama, alamat, nomorHP);
        this.informasiLain = informasiLain;
    }
}
