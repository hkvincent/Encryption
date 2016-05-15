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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class Decoding {

    Decoding() {

    }

    public Decoding(File path, char[] secert) throws IOException {

        Decode(path, secert);
        System.out.println(path);

    }

    private void Decode(File path, char[] key) throws FileNotFoundException, IOException {
        File file = new File(path.getAbsolutePath());
        char secret = key[0];
        System.out.println(file);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
                "user.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(file));
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
        

    }

    public void delete() {

    }
}
