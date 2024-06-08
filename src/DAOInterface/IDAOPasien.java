/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Pasien;
import java.util.List;
import View.Daftar;

/**
 *
 * @author ASUS Vivobook
 */
public interface IDAOPasien {
    //insert data
    public void insert (Pasien b);
    //read data calon_pasien
    public List<Pasien> getAll();
    //delete data
    public void delete(int no_antrian);
    //update data
    public void update(Pasien b);
}
