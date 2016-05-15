/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserCom.impl;

import CodingFution.Decoding;
import UserCom.UserCilent;
import UserCom.UserDao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class UserDaoImpl implements UserDao {

    private File file = new File("temp.txt"); 
    private File file2 = new File("user.txt");
    private File file3 = new File("vincent\\Verification.txt");
    private File file4 = new File("vincent");
    public boolean login(String userName, String passWord) {
        boolean flag = false;
        try {
            Decoding dc = new Decoding(file, "星".toCharArray());
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = br.readLine()) != null) {
                    String[] datas = line.split("=");
                    if (datas[0].equals(userName) && datas[1].equals(passWord)) {
                        flag = true;
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public boolean register(UserCilent user) {
        boolean flag = false;
        BufferedWriter bw = null;
        if (!file2.exists()&&!file3.exists()) {
            try {
                file2.createNewFile();
                file4.mkdirs();
                file3.createNewFile();
                try {
                    bw = new BufferedWriter(new FileWriter(file2));
                    bw.write(user.getUser() + "=" + user.getPassword());
                    bw.newLine();
                    bw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        bw.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                flag = true;
            } catch (IOException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return flag;

    }
}
