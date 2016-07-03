/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.ac.unikom.prolan6.perpustakaan.daoimpl;

import id.ac.unikom.prolan6.perpustakaan.dao.BukuDAO;
import id.ac.unikom.prolan6.perpustakaan.enitiy.Buku;
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
 * @author Robi Tanzil
 */
public class BukuDAOImpl implements BukuDAO {
    
    private final Connection conn;

    public BukuDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Buku> getBuku() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Buku> getBuku(String judul) {
        
        ArrayList<Buku> arrayBuku = null;
        PreparedStatement state = null;
        
        boolean isSearching = judul != null && !judul.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT * FROM buku WHERE judulBuku LIKE ?";
        } else {
            SELECT = "SELECT * FROM buku";
        }
        
        try {
            state = conn.prepareStatement(SELECT);
            if (isSearching) {
                state.setString(1, judul + "%");
            }
            
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayBuku = new ArrayList<>();
                
                while (result.next()) {                    
                    Buku a = new Buku();
                    a.setIdBuku(result.getString(1));
                    a.setJudul(result.getString(2));
                    a.setHarga(result.getFloat(7));
                    
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
