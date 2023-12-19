package doc_hunter;

public class Schedule {
    private int idJadwal;
    private int idDokter;
    private String hariPraktik;
    private String jamMulaiPraktik;
    private String jamSelesaiPraktik;

    public Schedule(int idJadwal, int idDokter, String hariPraktik, String jamMulaiPraktik, String jamSelesaiPraktik) {
        this.idJadwal = idJadwal;
        this.idDokter = idDokter;
        this.hariPraktik = hariPraktik;
        this.jamMulaiPraktik = jamMulaiPraktik;
        this.jamSelesaiPraktik = jamSelesaiPraktik;
    }
}
