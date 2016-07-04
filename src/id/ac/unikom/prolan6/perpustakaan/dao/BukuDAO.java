<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.ac.unikom.prolan6.perpustakaan.dao;

import id.ac.unikom.prolan6.perpustakaan.entity.Buku;
import java.util.ArrayList;

/**
 *
 * @author ig4ever
 */
public interface BukuDAO {
    ArrayList<Buku> getBuku();
    
    ArrayList<Buku> getBuku(String judulBuku);
=======
package id.ac.unikom.prolan6.perpustakaan.dao;

import id.ac.unikom.prolan6.perpustakaan.enitiy.Buku;
import java.util.ArrayList;

public interface BukuDAO {

    ArrayList<Buku> getBuku();

    ArrayList<Buku> getBuku(String judul);

>>>>>>> b50703bdef715f3b696bc83679e545a8993aaa50
}
