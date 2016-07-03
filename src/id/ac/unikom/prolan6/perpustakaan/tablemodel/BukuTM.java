/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.perpustakaan.tablemodel;

import id.ac.unikom.prolan6.perpustakaan.entity.Buku;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ig4ever
 */
public class BukuTM extends AbstractTableModel {

    ArrayList<Buku> arrayBuku;

    public void setArrayBuku(ArrayList<Buku> arrayBuku) {
        this.arrayBuku = arrayBuku;
    }

    @Override
    public int getRowCount() {
        return arrayBuku.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayBuku.get(rowIndex).getKdBuku();
            case 1:
                return arrayBuku.get(rowIndex).getJudulBuku();
            case 2:
                return arrayBuku.get(rowIndex).getPengarang();
            case 3:
                return arrayBuku.get(rowIndex).getPenerbit();
            case 4:
                return arrayBuku.get(rowIndex).getTahun();
            case 5:
                return arrayBuku.get(rowIndex).getStok();
            case 6:
                return arrayBuku.get(rowIndex).getHarga();
        }
        return null;
    }

//    @Override
//    public String getColumnName(int column) {
//        switch (column) {
//            case 0:
//                return "Kode Buku";
//            case 1:
//                return "Judul Buku";
//            case 2:
//                return "Pengarang";
//            case 3:
//                return "Penerbit";
//            case 4:
//                return "Tahun";
//            case 5:
//                return "Stok";
//            case 6:
//                return "Harga";
//        }
//        return null;
//    }

}
