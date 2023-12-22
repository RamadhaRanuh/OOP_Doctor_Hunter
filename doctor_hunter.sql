use doctor_hunter;

SELECT * FROM users;
SELECT * FROM admins;
SELECT * FROM Appointment;
SELECT * FROM Pasien;
SELECT * FROM Dokter;
SELECT * FROM Schedule;


CREATE TABLE Dokter (
    ID_Dokter INT PRIMARY KEY,
    Nama_Dokter VARCHAR(255),
    Spesialisasi VARCHAR(100),
    Nomor_Kontak VARCHAR(20),
    Alamat_Praktik VARCHAR(255)
);

-- Tabel Pasien
CREATE TABLE Pasien (
    ID_Pasien INT PRIMARY KEY,
    Nama_Pasien VARCHAR(255),
    Alamat VARCHAR(255),
    Nomor_Kontak VARCHAR(20)
);

-- Tabel Appointment
CREATE TABLE Appointment (
    ID_Appointment INT PRIMARY KEY,
    ID_Pasien INT,
    ID_Dokter INT,
    Tanggal_Waktu_Janji DATETIME,
    Status_Janji VARCHAR(20),
    Hasil_Diagnosa TEXT,
    Resep_Obat TEXT
);



-- Tabel Jadwal_Praktik_Dokter
CREATE TABLE Schedule (
    ID_Jadwal INT PRIMARY KEY,
    ID_Dokter INT,
    Hari_Praktik VARCHAR(20),
    Jam_Mulai_Praktik TIME,
    Jam_Selesai_Praktik TIME
);



use doctor_hunter;
alter table pasien add email varchar(50);
alter table pasien add passwords varchar (10);



create table admins
(
	ID_admin CHAR(10) PRIMARY KEY,
    Nama_admin VARCHAR(255),
    Alamat VARCHAR(255),
    Nomor_Kontak VARCHAR(20),
    email varchar(50),
    passwords varchar (10)
);
create table users
(
	ID_user CHAR(10) PRIMARY KEY,
    Nama_user VARCHAR(255),
    Alamat VARCHAR(255),
    Nomor_Kontak VARCHAR(20),
    email varchar(50),
    passwords varchar (10)
);
DROP TABLE users;
SELECT * FROM users;

SELECT * FROM admins;