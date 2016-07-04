/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.perpustakaan.daoimpl;

import id.ac.unikom.prolan6.perpustakaan.dao.PegawaiDAO;
<<<<<<< HEAD
import id.ac.unikom.prolan6.perpustakaan.entity.Pegawai;
=======
import id.ac.unikom.prolan6.perpustakaan.enitiy.Pegawai;
>>>>>>> b50703bdef715f3b696bc83679e545a8993aaa50
import id.ac.unikom.prolan6.perpustakaan.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> b50703bdef715f3b696bc83679e545a8993aaa50
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
<<<<<<< HEAD
 * @author ig4ever
=======
 * @author faisal
>>>>>>> b50703bdef715f3b696bc83679e545a8993aaa50
 */
public class PegawaiDAOImpl implements PegawaiDAO {

    private final Connection conn;

    public PegawaiDAOImpl() {
<<<<<<< HEAD
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Pegawai> getPegawai() {
        return getPegawai(null);
    }

    @Override
    public ArrayList<Pegawai> getPegawai(String namaPegawai) {
        ArrayList<Pegawai> arrayPegawai = null;
        PreparedStatement state = null;

        boolean isSearching = namaPegawai != null && !namaPegawai.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT * FROM pegawai WHERE namaPegawai LIKE ?";
        } else {
            SELECT = "SELECT * FROM pegawai";
        }

        try {
            state = conn.prepareStatement(SELECT);
            if (isSearching) {
                state.setString(1, namaPegawai + "%");
            }

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPegawai = new ArrayList<>();

                while (result.next()) {
                    Pegawai a = new Pegawai();
                    a.setIdPegawai(result.getInt(1));
                    a.setNamaPegawai(result.getString(2));
                    a.setAlamat(result.getString(3));
                    a.setNoTelp(result.getString(4));
                    a.setUsername(result.getString(5));
                    a.setPassword(result.getString(6));

                    arrayPegawai.add(a);
                }
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PegawaiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayPegawai;
=======
        this.conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public Pegawai login(String userName, String password) {
        Pegawai pegawai = null;
        PreparedStatement state = null;

        String SELECT = "SELECT * FROM pegawai WHERE "
                + "username = ? AND password = ?";

        try {
            state = conn.prepareStatement(SELECT);
            state.setString(1, userName);
            state.setString(2, password);

            ResultSet result = state.executeQuery();
            if (result != null && result.next()) {
                pegawai = new Pegawai();
                pegawai.setIdPegawai(result.getInt(1));
                pegawai.setNamaPegawai(result.getString(2));
                pegawai.setAlamat(result.getString(2));
                pegawai.setNoTelp(result.getString(2));
                Pegawai.isLogin = true;
                Pegawai.nama = result.getString(2);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return pegawai;
>>>>>>> b50703bdef715f3b696bc83679e545a8993aaa50
    }

}
