

package id.ac.unikom.prolan6.perpustakaan.daoimpl;


import id.ac.unikom.prolan6.perpustakaan.dao.AnggotaDAO;
import id.ac.unikom.prolan6.perpustakaan.entitiy.Anggota;
import id.ac.unikom.prolan6.perpustakaan.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnggotaDAOImpl implements AnggotaDAO {
    
    private final Connection conn;

    public AnggotaDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Anggota> getAnggota() {
        return getAnggota(null);
    }

    @Override
    public ArrayList<Anggota> getAnggota(String nama) {
        
        ArrayList<Anggota> arrayAnggota = null;
        PreparedStatement state = null;
        
        boolean isSearching = nama != null && !nama.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT * FROM anggota WHERE nama LIKE ?";
        } else {
            SELECT = "SELECT * FROM anggota";
        }
        
        try {
            state = conn.prepareStatement(SELECT);
            if (isSearching) {
                state.setString(1, nama + "%");
            }
            
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayAnggota = new ArrayList<>();
                
                while (result.next()) {                    
                    Anggota a = new Anggota();
                    a.setIdAnggota(result.getInt(1));
                    a.setNama(result.getString(2));
                    
                    arrayAnggota.add(a);
                }
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AnggotaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return arrayAnggota;
    }
    
}
