/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD

package id.ac.unikom.prolan6.perpustakaan.dao;

import id.ac.unikom.prolan6.perpustakaan.entity.Pegawai;
import java.util.ArrayList;

/**
 *
 * @author ig4ever
 */
public interface PegawaiDAO {
    ArrayList<Pegawai> getPegawai();
    
    ArrayList<Pegawai> getPegawai(String namaPegawai);
=======
package id.ac.unikom.prolan6.perpustakaan.dao;

import id.ac.unikom.prolan6.perpustakaan.enitiy.Pegawai;

/**
 *
 * @author faisal
 */
public interface PegawaiDAO {
    Pegawai login(String userName, String password);
    
>>>>>>> b50703bdef715f3b696bc83679e545a8993aaa50
}
