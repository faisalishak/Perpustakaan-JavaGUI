/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.perpustakaan.daoimpl;

import id.ac.unikom.prolan6.perpustakaan.dao.PegawaiDAO;
import id.ac.unikom.prolan6.perpustakaan.entitiy.Pegawai;
import id.ac.unikom.prolan6.perpustakaan.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PegawaiDAOImpl implements PegawaiDAO {

    private final Connection conn;

    public PegawaiDAOImpl() {
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
                    a.setUserName(result.getString(5));
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
                pegawai.setAlamat(result.getString(3));
                pegawai.setNoTelp(result.getString(4));

            }

        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return pegawai;
    }

}
