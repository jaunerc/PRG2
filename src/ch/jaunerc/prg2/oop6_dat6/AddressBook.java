/* Copyright 2015 Hochschule Luzern - Technik & Architektur */
package ch.jaunerc.prg2.oop6_dat6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Peter Sollberger (peter.sollberger@hslu.ch)
 */
public final class AddressBook {
    private final List<AddressEntry> addresses;

    public AddressBook() {
        addresses = new ArrayList<>();
    }

    public void addEntry(final String firstName, final String lastName, final int zip) {
        addresses.add(new AddressEntry(firstName, lastName, zip));
    }
    
    public void addEntry(final String firstName, final String lastName, final int zip, final String phone) {
        AddressEntry e = new AddressEntry(firstName, lastName, zip);
        e.setPhone(phone);
        addresses.add(e);
    }

    /**
     * Get the number of addresses in the book.
     * @return Size.
     */
    public int size() {
        return addresses.size();
    }

    /**
     * Get the address entry at the specified possition.
     * @param index zero based index
     * @return Address entry at the spezified position according the sort order.
     */
    public AddressEntry getAt(final int index) {
        return addresses.get(index);
    }

    /**
     * Sorts the address lsit according the natural order.
     */
    public void sort() {
        addresses.sort(null);
    }

    /**
     * Sorts the addresses according the rules of the comparator.
     * @param coparator Defines sort order.
     */
    public void sort(final Comparator<AddressEntry> coparator) {
        addresses.sort(coparator);
    }

    public static void main(String[] args) {
        final AddressBook book = new AddressBook();

        book.addEntry("Hans", "Muster", 6048);
        book.addEntry("Fritz", "Meier", 6049);

        for (int i = 0; i < book.size(); i++) {
            final AddressEntry e = book.getAt(i);
            System.out.printf("%d: %s, %s, %d\n", i, e.getLastName(), e.getFistName(), e.getZip());
        }
    }
}
