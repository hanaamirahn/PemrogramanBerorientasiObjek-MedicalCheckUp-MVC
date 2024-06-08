/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS Vivobook
 */
public class Dokter {

    /**
     * @return the id_dokter
     */
    public Integer getId_dokter() {
        return id_dokter;
    }

    /**
     * @param id_dokter the id_dokter to set
     */
    public void setId_dokter(Integer id_dokter) {
        this.id_dokter = id_dokter;
    }

    /**
     * @return the nama_dokter
     */
    public String getNama_dokter() {
        return nama_dokter;
    }

    /**
     * @param nama_dokter the nama_dokter to set
     */
    public void setNama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }

    /**
     * @return the spesialisasi
     */
    public String getSpesialisasi() {
        return spesialisasi;
    }

    /**
     * @param spesialisasi the spesialisasi to set
     */
    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    /**
     * @return the status_ketersediaan
     */
    public String getStatus_ketersediaan() {
        return status_ketersediaan;
    }

    /**
     * @param status_ketersediaan the status_ketersediaan to set
     */
    public void setStatus_ketersediaan(String status_ketersediaan) {
        this.status_ketersediaan = status_ketersediaan;
    }

    /**
     * @return the jadwal_dokter
     */
    public String getJadwal_dokter() {
        return jadwal_dokter;
    }

    /**
     * @param jadwal_dokter the jadwal_dokter to set
     */
    public void setJadwal_dokter(String jadwal_dokter) {
        this.jadwal_dokter = jadwal_dokter;
    }
    
    private Integer id_dokter;
    private String nama_dokter;
    private String spesialisasi;
    private String status_ketersediaan;
    private String jadwal_dokter;
    
}
