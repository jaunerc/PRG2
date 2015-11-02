/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jaunerc.prg2.oop7;

/**
 *
 * @author Cyrill Jauner
 */
public class TestSolidFileIO {
    
    public static void main(String[] args) {
        Cube[] cubes = SolidFileIO.readSolids(".\\soliddata_cubes.txt");
        
        for(Cube c : cubes) {
            System.out.println(c.toString());
        }
    }
}
