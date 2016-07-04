package id.ac.unikom.prolan6.perpustakaan.tablemodel;

import id.ac.unikom.prolan6.perpustakaan.entitiy.Anggota;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AnggotaTM extends AbstractTableModel {

    private ArrayList<Anggota> arrayAnggota;

    public void setArrayAnggota(ArrayList<Anggota> arrayBuku) {
        this.arrayAnggota = arrayBuku;
    }

    @Override
    public int getRowCount() {
        return arrayAnggota.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayAnggota.get(rowIndex).getIdAnggota();
            case 1:
                return arrayAnggota.get(rowIndex).getNama();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID ANGGOTA";
            case 1:
                return "NAMA";
        }
        return null;
    }
}
