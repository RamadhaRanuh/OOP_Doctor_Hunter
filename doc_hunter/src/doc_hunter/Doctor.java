package doc_hunter;

public class Doctor extends Person {
	private String idDokter;
	private String name;
	private String nomorHP;
    private String spesialisasi;
    private String alamatPraktik;
    
    public Doctor(int id, String nama, String alamat, String nomorHP) {
        super(id, nama, alamat, nomorHP, null, null);
        this.idDokter = String.valueOf(id);
        this.name = nama;
        this.nomorHP = nomorHP;
        this.alamatPraktik = alamat;
    }

}
