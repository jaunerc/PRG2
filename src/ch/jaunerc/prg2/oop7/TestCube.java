/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jaunerc.prg2.oop7;

import java.util.ArrayList;

/**
 *
 * @author Cyrill Jauner
 */
public class TestCube {
    
    public static void main(String[] args) {
        TestCube testCube = new TestCube();
        
        System.out.println("****************************\nInsert order: ");
        printOut(testCube);
        System.out.println("****************************\nNatural order: ");
        testCube.sort();
        printOut(testCube);
        
        System.out.println("****************************\nTest right equals: ");
        Cube c1 = new Cube(1, 1, 2, 3);
        Cube c2 = new Cube(2, 1, 2, 3);
        System.out.println("cube 1 and 2 are equal: "+c1.equals(c2));
    }
    
    public static void printOut(TestCube testCube) {
        for(int i = 0; i < testCube.size(); i++) {
            System.out.println(testCube.getAt(i).toString());
        }
    }
    
    ArrayList<Cube> cubes;
    
    public TestCube() {
        cubes = new ArrayList<>();
        generateCubes();
    }
    
    private void generateCubes() {
        cubes.add(new Cube(1, 10, 20, 30));
        cubes.add(new Cube(2, 1, 2, 3));
        cubes.add(new Cube(3, 30, 20, 15));
        cubes.add(new Cube(4, 0, 2, 5));
    }
    
    public Cube getAt(int i) {
        return cubes.get(i);
    }
    
    public int size() {
        return cubes.size();
    }
    
    /**
     * Sorts the cube list according the natural order.
     */
    public void sort() {
        cubes.sort(null);
    }
}
