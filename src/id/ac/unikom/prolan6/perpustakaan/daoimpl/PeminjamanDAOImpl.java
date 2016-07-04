package id.ac.unikom.prolan6.perpustakaan.daoimpl;

import id.ac.unikom.prolan6.perpustakaan.dao.PeminjamanDAO;
import id.ac.unikom.prolan6.perpustakaan.entitiy.Peminjaman;
import id.ac.unikom.prolan6.perpustakaan.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PeminjamanDAOImpl implements PeminjamanDAO {

    private final Connection conn;

    public PeminjamanDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Peminjaman> getPeminjaman(String nama) {
        boolean isSearching = nama != null && !nama.isEmpty();
        String SELECT;
        ArrayList<Peminjaman> arrayPeminjaman = null;
        if(isSearching){
         SELECT = "SELECT "
                + "peminjaman.idPeminjaman, "
                + "peminjaman.tglPinjam, "
                + "peminjaman.tglKembali, "
                + "peminjaman.harga, "
                + "anggota.namaAnggota "
                + "FROM peminjaman, anggota "
                + "WHERE "
                + "anggota.namaAnggota LIKE ? and peminjaman.idAnggota = anggota.idAnggota ";
        }else{
            SELECT = "SELECT "
                + "peminjaman.idPeminjaman, "
                + "peminjaman.tglPinjam, "
                + "peminjaman.tglKembali, "
                + "peminjaman.harga, "
                + "anggota.namaAnggota "
                + "FROM peminjaman, anggota "
                + "WHERE "
                + "peminjaman.idAnggota = anggota.idAnggota ORDER BY peminjaman.tglPinjam DESC";
        }
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);
            if (isSearching) {
                    state.setString(1, nama + "%");
                }
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPeminjaman = new ArrayList<>();
                
                while (result.next()) {
                    Peminjaman p = new Peminjaman();
                    p.setIdPinjam(result.getInt(1));
                    p.setTglPinjam(result.getDate(2));
                    p.setTglKembali(result.getDate(3));

                    p.setHarga(result.getFloat(4));
                    p.setNama(result.getString(5));

                    arrayPeminjaman.add(p);
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

        return arrayPeminjaman;
    }

    @Override
    public boolean pinjam(int idAnggota,  Calendar tglPinjam, Calendar tglKembali, int harga) {
        String INSERT = "INSERT INTO peminjaman "
                + "(idAnggota, tglPinjam, tglKembali,harga) "
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setInt(1, idAnggota);
            state.setDate(2, new Date(tglPinjam.getTimeInMillis()));
            state.setDate(3, new Date(tglKembali.getTimeInMillis()));
            state.setInt(4, harga);

            int result = state.executeUpdate();
            return result > 0;

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

        return false;
    }

    @Override
    public boolean kembali(int idPinjam, Calendar tglKembali, float harga) {

        String UPDATE = "UPDATE peminjaman "
                + "SET tgl_kem = ?, harga = ? "
                + "WHERE id_pin = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setDate(1, new Date(tglKembali.getTimeInMillis()));
            state.setFloat(2, harga);
            state.setInt(3, idPinjam);

            int result = state.executeUpdate();
            return result > 0;

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

        return false;
    }

    @Override
    public int getIdPeminjaman() {
        int idPinjam = 0;
        String last = "SELECT * FROM peminjaman ORDER BY idPeminjaman DESC LIMIT 1";
        PreparedStatement state = null;
        
        try {
            state = conn.prepareStatement(last);
            ResultSet res = state.executeQuery();
            if(res != null){
                res.last();
                idPinjam = res.getInt("idPeminjaman");
            }else{
                System.out.println("Error get data");
            }
         
            
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idPinjam;
    }

    @Override
    public ArrayList<Peminjaman> getPeminjaman() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
