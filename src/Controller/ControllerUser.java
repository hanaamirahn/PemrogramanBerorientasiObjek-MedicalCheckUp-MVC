/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOUser;
import DAOInterface.IDAOUser;
import Model.User;
import View.SignUp;
import View.Utama;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS Vivobook
 */
public class ControllerUser {
    
    
    
    public ControllerUser(SignUp sgn){
        this.sgn = sgn;
        iUser = new DAOUser();
    }
    
    public ControllerUser(Utama utm){
        this.utm = utm;
        
        iUser = new DAOUser();
    }

    

    public User getUserByUsername(String username) {
        return iUser.getUserByUsername(username);
    }
    
    public void addUser(){
        User b = new User();
        b.setUsername(sgn.gettxtusername().getText());
        b.setEmail(sgn.gettxtemail().getText());
        b.setPassword(sgn.gettxtpassword().getText());
        boolean res = iUser.addUser(b);
        
        if(res){
            Utama utm = new Utama();
            utm.setVisible(true);
            sgn.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Data Belum Lengkap");
        }
    }
    
    
    SignUp sgn;
    IDAOUser iUser;
    Utama utm;

}
