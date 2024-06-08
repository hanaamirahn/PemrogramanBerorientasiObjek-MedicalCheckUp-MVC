/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOPasien;
import Helper.KoneksiDB;
import Model.Pasien;
import Model.Dokter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ASUS Vivobook
 */
public class DAOPasien implements IDAOPasien {

    // Buat Konstruktor
    public DAOPasien() {
        con = KoneksiDB.getConnection();
    }
    
     @Override
    public void insert(Pasien b) {
        PreparedStatement statement = null;
        try {
            // Buat prepared statement dengan query insert
            statement = con.prepareStatement(strInsert);
            statement.setInt(1, b.getNIK());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getTgl_lahir());
            statement.setInt(4, b.getNo_hp());
            statement.setString(5, b.getGol_darah());
            statement.setString(6, b.getJk());
            statement.setString(7, b.getRiwayat_penyakit());
            statement.setString(8, b.getKeluhan());

            // Eksekusi statement
            statement.executeUpdate();
            System.out.println("Data berhasil dimasukkan");
        } catch (SQLException e) {
            // Tangkap dan log error
            e.printStackTrace();
            System.out.println("Gagal Daftar: " + e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Gagal menutup statement: " + ex.getMessage());
            }
        }

    }
   
     @Override
    public List<Pasien> getAll() {
      List<Pasien> lstpsn = null;
      lstpsn= new ArrayList<Pasien>();
      PreparedStatement statement = null;
      ResultSet rs = null;
       try
       {
            statement = con.prepareStatement(strRead);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                Pasien pasien = new Pasien();
                pasien.setNo_antrian(rs.getInt("no_antrian"));
                pasien.setNIK(rs.getInt("NIK"));
                pasien.setNama(rs.getString("nama"));
                pasien.setTgl_lahir(rs.getString("tgl_lahir"));
                pasien.setNo_hp(rs.getInt("no_hp"));
                pasien.setGol_darah(rs.getString("gol_darah"));
                pasien.setJk(rs.getString("jk"));
                pasien.setRiwayat_penyakit(rs.getString("riwayat_penyakit"));
                pasien.setKeluhan(rs.getString("keluhan"));
                lstpsn.add(pasien);
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
        
        return lstpsn;

    }
    
     @Override
    public void delete(int no_antrian) {
        PreparedStatement statement = null;
       try
       {
           statement = con.prepareStatement(strDelete);
           statement.setInt(1, no_antrian);
           statement.execute();
       }catch(SQLException e)
       {
           System.out.println("gagal delete");
       }
       finally
       {
           try
           {
               statement.close();
           } catch (SQLException ex)
           {
               System.out.println("gagal delete");
           }
       }
    }
    
     @Override
    public void update(Pasien b) {
        PreparedStatement statement = null;
       try
       {
           statement = con.prepareStatement(strUpdate);
           
           statement.setString(1, b.getNama());
           statement.setString(2, b.getTgl_lahir());
           statement.setInt(3, b.getNo_hp());
           statement.setString(4, b.getGol_darah());
           statement.setString(5, b.getJk());
           statement.setString(6, b.getRiwayat_penyakit());
           statement.setString(7, b.getKeluhan());
           statement.setInt(8, b.getNIK());
           statement.execute();
       }catch(SQLException e)
       {
           System.out.println("gagal update");
       }
       finally
       {
           try
           {
               statement.close();
           } catch (SQLException ex)
           {
               System.out.println("gagal update");
           }
       }
    }

    
    // Koneksi ke database
    Connection con;
    
    // Query SQL untuk insert data
    String strInsert = "INSERT INTO calon_pasien (NIK, nama, tgl_lahir, no_hp, gol_darah, jk, riwayat_penyakit, keluhan) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    String strRead = "SELECT * FROM calon_pasien ORDER BY no_antrian DESC LIMIT 1;";
    String strDelete = "delete from calon_pasien where no_antrian=?";
    String strUpdate = "update calon_pasien set nama=?, tgl_lahir=?, no_hp=?, gol_darah=?,jk=?, riwayat_penyakit=?, keluhan=? where NIK=?";
   
}