package id.ac.unikom.prolan6.perpustakaan.tablemodel;

import id.ac.unikom.prolan6.perpustakaan.enitiy.Buku;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class BukuTM extends AbstractTableModel {

    private ArrayList<Buku> arrayBuku;

    public void setArrayBuku(ArrayList<Buku> arrayBuku) {
        this.arrayBuku = arrayBuku;
    }

    @Override
    public int getRowCount() {
        return arrayBuku.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayBuku.get(rowIndex).getIdBuku();
            case 1:
                return arrayBuku.get(rowIndex).getJudul();
            case 2:
                return arrayBuku.get(rowIndex).getHarga();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id Buku";
            case 1:
                return "Judul";
            case 2:
                return "Harga";
        }
        return null;
    }

}
