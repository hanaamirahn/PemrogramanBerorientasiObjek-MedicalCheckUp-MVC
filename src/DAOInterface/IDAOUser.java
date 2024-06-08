/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.User;

/**
 *
 * @author ASUS Vivobook
 */
public interface IDAOUser {
    public boolean addUser(User b);
    User getUserByUsername(String username);
    boolean validateUser(String username, String password);
}
