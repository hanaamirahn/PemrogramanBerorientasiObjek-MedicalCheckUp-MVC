/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS Vivobook
 */
public class TabelModelDokterUmum extends AbstractTableModel{

    public TabelModelDokterUmum (List<Dokter> lstdrUmum){
        this.lstdrUmum = lstdrUmum;
    }
   
    @Override
    public int getRowCount() {
        // tergantung isi yang di inputkan
        return this.lstdrUmum.size();
    }

    @Override
    public int getColumnCount() {
        // karena ada 5 kolom di databases
        return 5;
    }

    //Untuk nama barisnya
    @Override
    public String getColumnName(int column) {
        switch (column) {
            //mulai dari kiri
            case 0:
                return "Nama_Dokter";
            case 1:
                return "Spesialisasi";
            case 2:
                return "Status_Ketersediaan";
            case 3:
                return "Jadwal_Dokter";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lstdrUmum.get(rowIndex).getNama_dokter();
            case 1:
                return lstdrUmum.get(rowIndex).getSpesialisasi();
            case 2:
                return lstdrUmum.get(rowIndex).getStatus_ketersediaan();
            case 3:
                return lstdrUmum.get(rowIndex).getJadwal_dokter();
            default:
                return null;
        }
    }
    
    List<Dokter> lstdrUmum;  
}
