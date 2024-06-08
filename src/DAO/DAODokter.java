/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAODokter;
import Helper.KoneksiDB;
import Model.Dokter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS Vivobook
 */
public class DAODokter implements IDAODokter{
    // Buat Konstruktor
    public DAODokter()
    {
        con = KoneksiDB.getConnection();
    }
    
    @Override
    public List<Dokter> getAll(String spesialisasi) {
      List<Dokter> lstdr = null;
      lstdr = new ArrayList<Dokter>();
      PreparedStatement statement = null;
      ResultSet rs = null;
       try
       {
            statement = con.prepareStatement(strRead);
            statement.setString(1, spesialisasi);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                Dokter dokter = new Dokter();
                dokter.setId_dokter(rs.getInt("id_dokter"));
                dokter.setNama_dokter(rs.getString("nama_dokter"));
                dokter.setSpesialisasi(rs.getString("spesialisasi"));
                dokter.setStatus_ketersediaan(rs.getString("status_ketersediaan"));
                dokter.setJadwal_dokter(rs.getString("jadwal_dokter"));
                lstdr.add(dokter);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
           //INI DIPERLAJARI KODENYA GAK PAHAM
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
            }
        }
        
        return lstdr;
    }
    
    // Metode untuk mengambil data jadwal dokter dari database
    public List<Dokter> getJadwalDokter() {
        List<Dokter> lstdr = new ArrayList<>();
        String sql = "SELECT nama_dokter,spesialisasi,jadwal_dokter FROM dokter WHERE status_ketersediaan = 'Tersedia' ORDER BY spesialisasi";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Dokter dr = new Dokter();
                dr.setNama_dokter(rs.getString("nama_dokter"));
                dr.setSpesialisasi(rs.getString("spesialisasi"));
                dr.setJadwal_dokter(rs.getString("jadwal_dokter"));
                lstdr.add(dr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstdr;
    }
     
    Connection con;
    
    //Query Perintah SQL
    String strRead = "select * from dokter where spesialisasi = ?;";
}
