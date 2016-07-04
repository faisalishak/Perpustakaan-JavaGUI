package id.ac.unikom.prolan6.perpustakaan.dao;

import id.ac.unikom.prolan6.perpustakaan.entitiy.PeminjamanDetail;
import java.util.ArrayList;

public interface PeminjamanDetailDao {

    ArrayList<PeminjamanDetail> getDetail(int idPinjam);

    boolean insertDetail(int idPindam, String idBuku);

}
