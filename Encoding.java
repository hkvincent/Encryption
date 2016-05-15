/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodingFution;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Encoding {

    Encoding() {

    }

    public Encoding(String path, char[] secert) {
        try {
            Encode(path, secert);
            System.out.println(path);
        } catch (IOException ex) {
            Logger.getLogger(Encoding.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Encode(String path, char[] key) throws IOException {
        File file = new File(path);
        int pathIndex = file.getAbsolutePath().lastIndexOf("\\");
        String pathName = file.getAbsolutePath().substring(0, pathIndex);
        String name = file.getName();
        int index = name.lastIndexOf(".");
        String[] tempName = new String[8];
        tempName[0] = name.substring(0, index);
        tempName[1] = name.substring(index + 1);
        File desFile = new File(pathName + "\\" + "temp" + "." + tempName[1]);
        System.out.println(desFile);
        char secret = key[0];
        System.out.println(path);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
                file));
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(desFile));
        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = bis.read(bys)) != -1) {
            byte[] bt = bys;
            for (int i = 0; i < bys.length; i++) {
                bt[i] = (byte) (bt[i] ^ (int) secret);
            }
            bos.write(bt, 0, len);
            bos.flush();
        }
        bos.close();
        bis.close();
        file.delete();
        desFile.renameTo(file);

    }
}
