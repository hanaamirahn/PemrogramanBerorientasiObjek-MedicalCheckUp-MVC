/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAODokter;
import DAOInterface.IDAODokter;
import Model.Dokter;
import Model.TabelModelDokterUmum;
import Model.TabelModelDokterGigi;
import View.Daftar;
import View.JadwalDokterUmum;
import View.Utama;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author ASUS Vivobook
 */
public class ControllerDokter {
    
    public ControllerDokter(JadwalDokterUmum JadwaldrUmum, JadwalDokterUmum JadwaldrGigi)
    {
        //panggil frame
        this.JadwaldrUmum = JadwaldrUmum;
        this.JadwaldrGigi = JadwaldrGigi;
        iDokter = new DAODokter();
    }
    
    public ControllerDokter(Utama utm)
    {
        this.utm = utm;
        iDokter = new DAODokter();
    }
    
      public void isiTabelDokterUmum() {
        // Isi tabel dokter umum
        List<Dokter> lstDokterUmum = iDokter.getAll("Dokter Umum");
        TabelModelDokterUmum tabeldrUmum = new TabelModelDokterUmum(lstDokterUmum);
        //yang didepan variabel
        JadwaldrUmum.gettabelDokterUmum().setModel(tabeldrUmum);
    }

    public void isiTabelDokterGigi() {
        // Isi tabel dokter gigi
        List<Dokter> lstDokterGigi = iDokter.getAll("Dokter Gigi");
        TabelModelDokterGigi tabeldrGigi = new TabelModelDokterGigi(lstDokterGigi);
        JadwaldrGigi.gettabelDokterGigi().setModel(tabeldrGigi);
    }
    
    public void daftar(JFrame currentFrame){
        Daftar dft = new Daftar();
        dft.setVisible(true);
        //Menutup form 
        currentFrame.dispose();
    }
    
    public void jadwaldokter(JFrame currentFrame){
        JadwalDokterUmum jdl = new JadwalDokterUmum();
        jdl.setVisible(true);
        //Menutup form 
        currentFrame.dispose(); 
    }
    
    public void utama(JFrame currentFrame){
        Utama utm = new Utama();
        utm.setVisible(true);
        //Menutup form 
        currentFrame.dispose(); 
    }
    
    //Property
    //Panggil form
    JadwalDokterUmum JadwaldrUmum;
    JadwalDokterUmum JadwaldrGigi;
    Utama utm;
    IDAODokter iDokter;
    List<Dokter> lstDokter;
}
