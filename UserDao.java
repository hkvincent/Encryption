/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserCom;

/**
 *
 * @author Administrator
 */
public interface UserDao {

    public abstract boolean login(String username, String password);

    public abstract boolean register(UserCilent user);
}
