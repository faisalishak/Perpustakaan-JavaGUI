package id.ac.unikom.prolan6.perpustakaan.dao;

import id.ac.unikom.prolan6.perpustakaan.enitiy.Buku;
import java.util.ArrayList;

public interface BukuDAO {

    ArrayList<Buku> getBuku();

    ArrayList<Buku> getBuku(String judul);

}
