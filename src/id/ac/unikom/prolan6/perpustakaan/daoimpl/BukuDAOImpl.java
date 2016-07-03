/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.perpustakaan.daoimpl;

import id.ac.unikom.prolan6.perpustakaan.dao.BukuDAO;
import id.ac.unikom.prolan6.perpustakaan.entity.Buku;
import id.ac.unikom.prolan6.perpustakaan.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ig4ever
 */
public class BukuDAOImpl implements BukuDAO {

    private final Connection conn;

    public BukuDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Buku> getBuku() {
        return getBuku(null);
    }

    @Override
    public ArrayList<Buku> getBuku(String judulBuku) {
        ArrayList<Buku> arrayBuku = null;
        PreparedStatement state = null;
        boolean isSearching = judulBuku != null && !judulBuku.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT * FROM buku WHERE judulBuku LIKE ?";
        } else {
            SELECT = "SELECT * FROM buku";
        }

        try {
            state = conn.prepareStatement(SELECT);
            if (isSearching) {
                state.setString(1, judulBuku + "%");
            }

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayBuku = new ArrayList<>();

                while (result.next()) {
                    Buku a = new Buku();
                    a.setKdBuku(result.getString(1));
                    a.setJudulBuku(result.getString(2));
                    a.setPengarang(result.getString(3));
                    a.setPenerbit(result.getString(4));
                    a.setTahun(result.getInt(5));
                    a.setStok(result.getInt(6));
                    a.setHarga(result.getInt(7));

                    arrayBuku.add(a);
                }
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(BukuDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BukuDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayBuku;
    }

}
