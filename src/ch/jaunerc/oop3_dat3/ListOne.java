/*
 * License header jaunerc
 */
package ch.jaunerc.oop3_dat3;

import java.util.ArrayList;

/**
 *
 * @author jaunerc
 */
public class ListOne implements IList{
    private ArrayList<Integer> list;
    
    public ListOne() {
        list = new ArrayList<>();
    }
    
    @Override
    public void add(Integer obj) {
        list.add(obj);
    }

    @Override
    public boolean remove(Integer obj) {
        return (list.remove(obj));
    }

    @Override
    public boolean removeValue(int i) {
        boolean found = false;
        
        for(Integer obj : list) {
            if(obj.intValue() == i) {
                list.remove(obj);
                found = true;
                break;
            }
        }
        
        return found;
    }

    @Override
    public boolean removeValues(int i) {
        boolean found = false;
        
        for(Integer obj : list) {
            if(obj.intValue() == i) {
                list.remove(obj);
                found = true;
            }
        }
        
        return found;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean exists(int i) {
        return (list.indexOf(i) != -1);
    }

    @Override
    public void print() {
        System.out.println("listOne:");
        for(Integer obj : list) {
            System.out.println(" - "+obj.intValue());
        }
    }
    
    
}
