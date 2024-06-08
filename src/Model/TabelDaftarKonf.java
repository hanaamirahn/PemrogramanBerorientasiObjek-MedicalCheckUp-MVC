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
public class TabelDaftarKonf extends AbstractTableModel{
    public TabelDaftarKonf (List<Pasien> lstpsn){
        this.lstpsn = lstpsn;
    }

    @Override
    public int getRowCount() {
       // tergantung isi yang di inputkan
        return this.lstpsn.size();
    }

    @Override
    public int getColumnCount() {
      // karena ada 9 kolom di databases
        return 9;
    }

     //Untuk nama barisnya
    @Override
    public String getColumnName(int column) {
        switch (column) {
            //mulai dari kiri
            case 0:
                return "No Antrian";
            case 1:
                return "NIK";
            case 2:
                return "Nama Lengkap";
            case 3:
                return "Tanggal Lahir";
            case 4:
                return "No HP";
            case 5:
                return "Gol Darah";
            case 6:
                return "Jenis Kelamin";
            case 7:
                return "Riwayat Penyakit";
            case 8:
                return "Keluhan";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lstpsn.get(rowIndex).getNo_antrian();
            case 1:
                return lstpsn.get(rowIndex).getNIK();
            case 2:
                return lstpsn.get(rowIndex).getNama();
            case 3:
                return lstpsn.get(rowIndex).getTgl_lahir();
            case 4:
                return lstpsn.get(rowIndex).getNo_hp();
            case 5:
                return lstpsn.get(rowIndex).getGol_darah();
            case 6:
                return lstpsn.get(rowIndex).getJk();
            case 7:
                return lstpsn.get(rowIndex).getRiwayat_penyakit();
            case 8:
                return lstpsn.get(rowIndex).getKeluhan();
            default:
                return null;
        }
    }
    
    List<Pasien> lstpsn;
}
