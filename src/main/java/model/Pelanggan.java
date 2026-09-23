/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Pelanggan {
    private final String idPelanggan;
    private String nama;
    private String noHP;
    private String nik;

    public Pelanggan(String idPelanggan, String nama, String noHP, String nik) {
        this.idPelanggan = idPelanggan;
        setNama(nama);
        setNoHP(noHP);
        setNik(nik);
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (!validasiNama(nama)) {
            throw new IllegalArgumentException("Nama harus 3-50 karakter dan hanya berisi huruf serta spasi.");
        }

        this.nama = nama.trim();
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        if (!validasiNoHP(noHP)) {
            throw new IllegalArgumentException("No HP harus diawali 08 dan terdiri dari 10-15 digit.");
        }

        this.noHP = noHP;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        if (!validasiNIK(nik)) {
            throw new IllegalArgumentException("NIK harus terdiri dari tepat 16 digit angka.");
        }

        this.nik = nik;
    }
    
    public static boolean validasiNama(String nama) {
        if (nama == null) {
            return false;
        }

        String nilai = nama.trim();
        return nilai.length() >= 3 && nilai.length() <= 50 && nilai.matches("[a-zA-Z ]+");
    }

    public static boolean validasiNoHP(String noHP) {
        if (noHP == null) {
            return false;
        }

        return noHP.matches("08[0-9]{8,13}");
    }

    public static boolean validasiNIK(String nik) {
        if (nik == null) {
            return false;
        }

        return nik.matches("[0-9]{16}");
    }
}