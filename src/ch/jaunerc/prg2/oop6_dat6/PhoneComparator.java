package ch.jaunerc.prg2.oop6_dat6;

import java.util.Comparator;

/**
 *
 * @author jaunerc
 */
public class PhoneComparator implements Comparator<AddressEntry>{

    @Override
    public int compare(AddressEntry o1, AddressEntry o2) {
        return o1.getPhone().compareTo(o2.getPhone());
    }
}
