/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package id.ac.unikom.prolan6.perpustakaan.dao;


import id.ac.unikom.prolan6.perpustakaan.entitiy.Pegawai;
import java.util.ArrayList;

/**
 *
 * @author ig4ever
 */
public interface PegawaiDAO {
    ArrayList<Pegawai> getPegawai();
    
    ArrayList<Pegawai> getPegawai(String namaPegawai);
    Pegawai login(String userName, String password);
}
