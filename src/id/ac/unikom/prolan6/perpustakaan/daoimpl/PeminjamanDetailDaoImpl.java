package id.ac.unikom.prolan6.perpustakaan.daoimpl;

import id.ac.unikom.prolan6.perpustakaan.dao.PeminjamanDetailDao;
import id.ac.unikom.prolan6.perpustakaan.entitiy.PeminjamanDetail;
import id.ac.unikom.prolan6.perpustakaan.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PeminjamanDetailDaoImpl implements PeminjamanDetailDao {

    private final Connection conn;

    public PeminjamanDetailDaoImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<PeminjamanDetail> getDetail(int idPinjam) {
        ArrayList<PeminjamanDetail> arrayDetail = null;
        String sql = "SELECT b.kdBuku,b.judulBuku,b.pengarang,b.penerbit,b.tahun from peminjaman_detail "
                + "INNER JOIN peminjaman ON "
                + "peminjaman.idPeminjaman=peminjaman_detail.idPeminjaman INNER JOIN buku b ON "
                + "peminjaman_detail.idBuku=b.kdBuku where peminjaman.idPeminjaman= ?";
        PreparedStatement state = null;
        try {
            state = conn.prepareStatement(sql);
            state.setInt(1, idPinjam);
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayDetail = new ArrayList<>();

                while (result.next()) {
                    PeminjamanDetail p = new PeminjamanDetail();
                    p.setKdBuku(result.getString(1));
                    p.setJudul(result.getString(2));
                    p.setPengarang(result.getString(3));
                    p.setPenerbit(result.getString(4));
                    p.setTahun(result.getString(5));

                    arrayDetail.add(p);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PeminjamanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayDetail;
    }

    @Override
    public boolean insertDetail(int idPindam, String idBuku) {
        String sql = "INSERT INTO peminjaman_detail(idPeminjaman,idBuku) values (?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(sql);
            state.setInt(1, idPindam);
            state.setString(2, idBuku);
            int result = state.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanDetailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PeminjamanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return false;
        }

    }
}
