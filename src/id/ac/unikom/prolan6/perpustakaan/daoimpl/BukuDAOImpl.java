/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD
package id.ac.unikom.prolan6.perpustakaan.daoimpl;

import id.ac.unikom.prolan6.perpustakaan.dao.BukuDAO;
import id.ac.unikom.prolan6.perpustakaan.entity.Buku;
=======

package id.ac.unikom.prolan6.perpustakaan.daoimpl;

import id.ac.unikom.prolan6.perpustakaan.dao.BukuDAO;
import id.ac.unikom.prolan6.perpustakaan.enitiy.Buku;
>>>>>>> b50703bdef715f3b696bc83679e545a8993aaa50
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
<<<<<<< HEAD
 * @author ig4ever
 */
public class BukuDAOImpl implements BukuDAO {

=======
 * @author Robi Tanzil
 */
public class BukuDAOImpl implements BukuDAO {
    
>>>>>>> b50703bdef715f3b696bc83679e545a8993aaa50
    private final Connection conn;

    public BukuDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Buku> getBuku() {
<<<<<<< HEAD
        return getBuku(null);
    }

    @Override
    public ArrayList<Buku> getBuku(String judulBuku) {
        ArrayList<Buku> arrayBuku = null;
        PreparedStatement state = null;
        boolean isSearching = judulBuku != null && !judulBuku.isEmpty();
=======
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Buku> getBuku(String judul) {
        
        ArrayList<Buku> arrayBuku = null;
        PreparedStatement state = null;
        
        boolean isSearching = judul != null && !judul.isEmpty();
>>>>>>> b50703bdef715f3b696bc83679e545a8993aaa50
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT * FROM buku WHERE judulBuku LIKE ?";
        } else {
            SELECT = "SELECT * FROM buku";
        }
<<<<<<< HEAD

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

=======
        
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
                    
>>>>>>> b50703bdef715f3b696bc83679e545a8993aaa50
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
<<<<<<< HEAD
        return arrayBuku;
    }

=======
        
        return arrayBuku;
    }
    
>>>>>>> b50703bdef715f3b696bc83679e545a8993aaa50
}
