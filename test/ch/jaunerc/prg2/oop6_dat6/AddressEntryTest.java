package ch.jaunerc.prg2.oop6_dat6;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaunerc
 */
public class AddressEntryTest {
    
    
    public AddressEntryTest() {
        
    }
    
    @Test
    public void testNaturalOrder() {
        AddressBook addresses = getTestAddressBook();
        addresses.sort();
        System.out.println("Test Natural Order");
        printOut(addresses);
    }
    
    @Test
    public void testSpecialOrder() {
        AddressBook addresses = getTestAddressBook();
        addresses.sort(new PhoneComparator());
        System.out.println("Test Special Order");
        printOut(addresses);
    }
    
    private AddressBook getTestAddressBook() {
        AddressBook addresses = new AddressBook();
        addresses.addEntry("Hans", "Meier", 6400, "0912");
        addresses.addEntry("Hans", "Meier", 5599, "0910");
        return addresses;
    }
    
    private void printOut(AddressBook ab) {
        for(int i = 0; i < ab.size(); i ++) {
            AddressEntry e = ab.getAt(i);
            System.out.println("FN: "+e.getFistName()+" - LN: "+e.getLastName()+" - PC: "+e.getZip()
            + " - PH: "+e.getPhone());
        }
    }
}
