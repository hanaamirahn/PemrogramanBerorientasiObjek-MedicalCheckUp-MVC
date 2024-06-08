/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Model.Dokter;
/**
 *
 * @author ASUS Vivobook
 */
public class Pasien {

    /**
     * @return the no_antrian
     */
    public Integer getNo_antrian() {
        return no_antrian;
    }

    /**
     * @param no_antrian the no_antrian to set
     */
    public void setNo_antrian(Integer no_antrian) {
        this.no_antrian = no_antrian;
    }

    /**
     * @return the NIK
     */
    public Integer getNIK() {
        return NIK;
    }

    /**
     * @param NIK the NIK to set
     */
    public void setNIK(Integer NIK) {
        this.NIK = NIK;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the tgl_lahir
     */
    public String getTgl_lahir() {
        return tgl_lahir;
    }

    /**
     * @param tgl_lahir the tgl_lahir to set
     */
    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    /**
     * @return the no_hp
     */
    public Integer getNo_hp() {
        return no_hp;
    }

    /**
     * @param no_hp the no_hp to set
     */
    public void setNo_hp(Integer no_hp) {
        this.no_hp = no_hp;
    }

    /**
     * @return the gol_darah
     */
    public String getGol_darah() {
        return gol_darah;
    }

    /**
     * @param gol_darah the gol_darah to set
     */
    public void setGol_darah(String gol_darah) {
        this.gol_darah = gol_darah;
    }

    /**
     * @return the jk
     */
    public String getJk() {
        return jk;
    }

    /**
     * @param jk the jk to set
     */
    public void setJk(String jk) {
        this.jk = jk;
    }

    /**
     * @return the riwayat_penyakit
     */
    public String getRiwayat_penyakit() {
        return riwayat_penyakit;
    }

    /**
     * @param riwayat_penyakit the riwayat_penyakit to set
     */
    public void setRiwayat_penyakit(String riwayat_penyakit) {
        this.riwayat_penyakit = riwayat_penyakit;
    }

    /**
     * @return the keluhan
     */
    public String getKeluhan() {
        return keluhan;
    }

    /**
     * @param keluhan the keluhan to set
     */
    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    private Integer no_antrian;
    private Integer NIK;
    private String nama;
    private String tgl_lahir;
    private Integer no_hp;
    private String gol_darah;
    private String jk;
    private String riwayat_penyakit;
    private String keluhan;

}
