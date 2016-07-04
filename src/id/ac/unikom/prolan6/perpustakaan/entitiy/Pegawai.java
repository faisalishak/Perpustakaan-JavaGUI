/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.perpustakaan.entitiy;

/**
 *
 * @author faisal
 */
public class Pegawai {
    private Integer idPegawai;
    private String namaPegawai;
    private String alamat;
    private String noTelp;
    private String userName;
    private String password;

    public Integer getIdPegawai() {
        return idPegawai;
    }

    public String getNamaPegawai() {
        return namaPegawai;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setIdPegawai(Integer idPegawai) {
        this.idPegawai = idPegawai;
    }

    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    
    
}
