
package id.ac.unikom.prolan6.perpustakaan.dao;

import id.ac.unikom.prolan6.perpustakaan.entitiy.Anggota;
import java.util.ArrayList;

public interface AnggotaDAO {
    
    ArrayList<Anggota> getAnggota();
    ArrayList<Anggota> getAnggota(String nama);
    
}
