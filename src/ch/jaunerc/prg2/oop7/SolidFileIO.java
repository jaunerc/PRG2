/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jaunerc.prg2.oop7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cyrill Jauner
 */
public class SolidFileIO {
    
    public static Cube[] readSolids(final String fileName) {
        BufferedReader reader = null;
            List<Cube> list = new LinkedList<>();
        try {
            int number = 1;
            String line;
            File f = new File(fileName);
            reader = new BufferedReader(new FileReader(f));
            
            while((line = reader.readLine()) != null) {
                String[] tokens = line.split("[: ]");
                switch(tokens[0]) {
                    case "C":
                        int s1 = Integer.parseInt(tokens[2]);
                        int s2 = Integer.parseInt(tokens[3]);
                        int s3 = Integer.parseInt(tokens[4]);
                        list.add(new Cube(number, s1, s2, s3));
                        
                }
                number++;
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SolidFileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SolidFileIO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(SolidFileIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return list.toArray(new Cube[list.size()]);
    }
}
