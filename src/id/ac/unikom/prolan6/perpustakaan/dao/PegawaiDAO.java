/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.perpustakaan.dao;

import id.ac.unikom.prolan6.perpustakaan.enitiy.Pegawai;

/**
 *
 * @author faisal
 */
public interface PegawaiDAO {
    Pegawai login(String userName, String password);
    
}
