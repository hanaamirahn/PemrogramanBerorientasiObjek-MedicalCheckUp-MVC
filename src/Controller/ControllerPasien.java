/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAODokter;
import DAO.DAOPasien;
import DAOInterface.IDAOPasien;
import java.sql.SQLException;
import Helper.KoneksiDB;
import Model.Dokter;
import Model.Pasien;
import Model.TabelDaftarKonf;
import View.Daftar;
import View.Makasi;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS Vivobook
 */
public class ControllerPasien {
    
    public ControllerPasien(Daftar dft) {
        // Inisialisasi frame dan DAO
        this.dft = dft;
        iPasien = new DAOPasien();
        iDokter = new DAODokter();
        isiCBJadwalDokter(); 
        
    }
    
    public ControllerPasien(Makasi mks){
        this.mks = mks;
        iPasien = new DAOPasien();
    }
    
        public void insert() {
        try {
            // Ambil data dari form
            Pasien b = new Pasien();
            b.setNIK(Integer.parseInt(dft.gettxtNIK().getText()));
            b.setNama(dft.gettxtnama().getText());
            b.setTgl_lahir(dft.gettxttgl().getText());
            b.setNo_hp(Integer.parseInt(dft.gettxtnohp().getText()));
            b.setGol_darah(dft.gettxtgol().getText());
            b.setJk(dft.getJkel().getSelectedItem().toString());
            b.setRiwayat_penyakit(dft.gettxtriwayat().getText());
            b.setKeluhan(dft.gettxtkeluhan().getText());

            // Insert data pasien
            iPasien.insert(b);
            JOptionPane.showMessageDialog(null, "Data berhasil dimasukkan. Silakan cek kembali data Anda.");
        } catch (Exception e) {
            // Tangkap dan tampilkan error
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lengkapi Data Anda: ");
        }
    }

     // Metode untuk mengisi combobox dengan jadwal dokter
    private void isiCBJadwalDokter() {
        List<Dokter> lstdr = iDokter.getJadwalDokter();
        for (Dokter dr : lstdr) {
            // Format teks yang akan ditampilkan di combobox
            String jdwdr = dr.getNama_dokter() + " - " + dr.getSpesialisasi() + " - " + dr.getJadwal_dokter();
            // Tambahkan teks ke combobox
            dft.getJadwal().addItem(jdwdr);
        }
    }
    
    public void isiField(int row)
    {
        dft.gettxtNIK().setEnabled(false);
        dft.gettxtNIK().setText(lstps.get(row).getNIK().toString());
        dft.gettxtnama().setText(lstps.get(row).getNama());
        dft.gettxttgl().setText(lstps.get(row).getTgl_lahir());
        dft.gettxtnohp().setText(lstps.get(row).getNo_hp().toString());
        dft.gettxtgol().setText(lstps.get(row).getGol_darah());
        dft.getJkel().setSelectedItem(lstps.get(row).getJk());
        dft.gettxtriwayat().setText(lstps.get(row).getRiwayat_penyakit());
        dft.gettxtkeluhan().setText(lstps.get(row).getKeluhan());
    }
    
    public void isiTabelKonf() {
        // Isi tabel pasien
        List<Pasien> lstkonf = iPasien.getAll();
        lstps = iPasien.getAll();
        TabelDaftarKonf tabelkonf = new TabelDaftarKonf(lstkonf);
        dft.gettabelkonf().setModel(tabelkonf);
    }
    
    public void delete()
    {
        iPasien.delete(Integer.parseInt(dft.gettxtNA().getText()));;
        JOptionPane.showMessageDialog(null, "Delete Berhasil");
    }
    
    public void update()
    {
        Pasien b = new Pasien();
        b.setNIK(Integer.parseInt(dft.gettxtNIK().getText()));
        b.setNama(dft.gettxtnama().getText());
        b.setTgl_lahir(dft.gettxttgl().getText());
        b.setNo_hp(Integer.parseInt(dft.gettxtnohp().getText()));
        b.setGol_darah(dft.gettxtgol().getText());
        b.setJk(dft.getJkel().getSelectedItem().toString());
        b.setRiwayat_penyakit(dft.gettxtriwayat().getText());
        b.setKeluhan(dft.gettxtkeluhan().getText());
        iPasien.update(b);
        JOptionPane.showMessageDialog(null, "Update Berhasil");
    }
    
     public void reset()
    {
        if(!dft.gettxtNIK().isEnabled())
            dft.gettxtNIK().setEnabled(true);
        dft.gettxtNIK().setText("");
        dft.gettxtnama().setText("");
        dft.gettxttgl().setText("");
        dft.gettxtnohp().setText("");
        dft.gettxtgol().setText("");
        dft.getJkel().setSelectedItem("L");
        dft.gettxtriwayat().setText("");
        dft.gettxtkeluhan().setText("");
    }
   
    public void daftar(JFrame currentFrame) {
        Daftar dft = new Daftar();
        dft.setVisible(true);
        currentFrame.dispose();
    }
    
    public void makasi(JFrame currentFrame) {
        Makasi mks = new Makasi();
        mks.setVisible(true);
        currentFrame.dispose();
    }
   
    
    //Property
    //Panggil form
    Daftar dft;
    Makasi mks;
    IDAOPasien iPasien;
    DAODokter iDokter;
    List<Pasien> lstps;
}