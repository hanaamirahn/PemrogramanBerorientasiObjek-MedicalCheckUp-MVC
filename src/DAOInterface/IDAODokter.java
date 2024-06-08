/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Dokter;
import java.util.List;

/**
 *
 * @author ASUS Vivobook
 */
public interface IDAODokter {
    //read data dokter
    public List<Dokter> getAll(String spesialisasi);
}
