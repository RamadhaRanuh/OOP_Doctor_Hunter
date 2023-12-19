-- create database doctor_hunter;

use doctor_hunter;
CREATE TABLE Dokter (
    ID_Dokter INT PRIMARY KEY,
    Nama_Dokter VARCHAR(255),
    Spesialisasi VARCHAR(100),
    Nomor_Kontak VARCHAR(20),
    Alamat_Praktik VARCHAR(255),
    Informasi_Lainnya TEXT
);

-- Tabel Pasien
CREATE TABLE Pasien (
    ID_Pasien INT PRIMARY KEY,
    Nama_Pasien VARCHAR(255),
    Alamat VARCHAR(255),
    Nomor_Kontak VARCHAR(20),
    Informasi_Lainnya TEXT
);

-- Tabel Appointment
CREATE TABLE Appointment (
    ID_Appointment INT PRIMARY KEY,
    ID_Pasien INT,
    ID_Dokter INT,
    Tanggal_Waktu_Janji DATETIME,
    Status_Janji VARCHAR(20),
    Hasil_Diagnosa TEXT,
    Resep_Obat TEXT,
    FOREIGN KEY (ID_Pasien) REFERENCES Pasien(ID_Pasien),
    FOREIGN KEY (ID_Dokter) REFERENCES Dokter(ID_Dokter)
);

-- Tabel Jadwal_Praktik_Dokter
CREATE TABLE Jadwal_Praktik_Dokter (
    ID_Jadwal INT PRIMARY KEY,
    ID_Dokter INT,
    Hari_Praktik VARCHAR(20),
    Jam_Mulai_Praktik TIME,
    Jam_Selesai_Praktik TIME,
    FOREIGN KEY (ID_Dokter) REFERENCES Dokter(ID_Dokter)
);