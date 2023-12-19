package doc_hunter;

public class Doctor extends Person {
    private String spesialisasi;
    private String jadwalPraktik;
    private String alamatPraktik;
    private String informasiLain;

    public Doctor(int id, String nama, String alamat, String nomorHP, String spesialisasi, String jadwalPraktik, String alamatPraktik, String informasiLain) {
        super(id, nama, alamat, nomorHP);
        this.spesialisasi = spesialisasi;
        this.jadwalPraktik = jadwalPraktik;
        this.alamatPraktik = alamatPraktik;
        this.informasiLain = informasiLain;
    }
}
