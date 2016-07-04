/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.ac.unikom.prolan6.perpustakaan.tablemodel;

import id.ac.unikom.prolan6.perpustakaan.entitiy.Pegawai;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ig4ever
 */
public class PegawaiTM extends AbstractTableModel{
    
    ArrayList<Pegawai> arrayPegawai;

    public void setArrayPegawai(ArrayList<Pegawai> arrayPegawai) {
        this.arrayPegawai = arrayPegawai;
    }

    @Override
    public int getRowCount() {
        return arrayPegawai.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayPegawai.get(rowIndex).getIdPegawai();
            case 1:
                return arrayPegawai.get(rowIndex).getNamaPegawai();
            case 2:
                return arrayPegawai.get(rowIndex).getAlamat();
            case 3:
                return arrayPegawai.get(rowIndex).getNoTelp();
            case 4:
                return arrayPegawai.get(rowIndex).getUserName();
            case 5:
                return arrayPegawai.get(rowIndex).getPassword();
        }
        return null;
    }
    
}
