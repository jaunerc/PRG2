/* Copyright 2015 Hochschule Luzern - Technik & Architektur */
package ch.jaunerc.prg2.oop6_dat6;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Holds address relevant fields of one person.
 * Person are equals if they have the same names and the same ZIP code.
 * @author ???
 */
public final class AddressEntry implements Comparable<AddressEntry>{
    private String fistName;
    private String lastName;    
    private int zip;
    private String city;
    private String phone;
    private String eMail;

    /** 
     * Create an entry with the initial values.
     */
    public AddressEntry(String fistName, String lastName, int zip) {
        setFistName(fistName);
        setLastName(lastName);
        setZip(zip);
        setCity("");
        setPhone("");
        seteMail("");
    }

    public void setCity(String city) throws IllegalArgumentException {
        this.city = city;
    }

    public void setPhone(String phone) throws IllegalArgumentException {
        for(char c : phone.toCharArray()) {
            if(!Character.isDigit(c)) {
                throw new IllegalArgumentException("phone is in a incorrect format");
            }
        }
        this.phone = phone;
    }

    public void seteMail(String eMail) throws IllegalArgumentException {
        if(!eMail.contains("@")) {
            throw new InvalidEmailAddressException("");
        }
        this.eMail = eMail;
    }

    public void setFistName(String fistName) throws IllegalArgumentException {
        if(isCorrectName(fistName)) {
            this.fistName = fistName;
        } else {
            throw new IllegalArgumentException("The firstName is in a incorrect format");
        }
    }

    public void setLastName(String lastName) throws IllegalArgumentException {
        if(isCorrectName(lastName)) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("The lastName is in a incorrect format");
        }
    }

    public void setZip(int zip) throws IllegalArgumentException {
        if(zip < 1000 || zip > 9999) {
            throw new IllegalArgumentException("zip has to be four letters!!!!");
        }
        this.zip = zip;
    }
    
    private boolean isCorrectName(String name) {
        if(name == null || containsNumber(name) || name.length() > 20) {
            return false;
        }
        return true;
    }
    
    private boolean containsNumber(String s) {
        Pattern p = Pattern.compile(".*\\d.*");
        return p.matcher(s).find();
    }

    /**
     * Get the value of fistName.
     * @return the value of fistName
     */
    public String getFistName() {
        return fistName;
    }

    /**
     * Get the value of lastName.
     * @return the value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the value of zip.
     * @return the value of zip
     */
    public int getZip() {
        return zip;
    }

    /**
     * Get the value of city.
     * @return the value of city
     */
    public String getCity() {
        return city;
    }    

    /**
     * Get the value of phone
     * @return the value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Get the value of eMail
     *
     * @return the value of eMail
     */
    public String getEMail() {
        return eMail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.fistName);
        hash = 17 * hash + Objects.hashCode(this.lastName);
        hash = 17 * hash + this.zip;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AddressEntry other = (AddressEntry) obj;
        if (!Objects.equals(this.fistName, other.fistName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (this.zip != other.zip) {
            return false;
        }
        return true;
    }
    
    /**
     * Compares the given address entry with this.
     * @param o the other address entry.
     * @return value to indicate if the given object is greater, lower or equal to this.
     */
    @Override
    public int compareTo(AddressEntry o) {
        if(this == o) {
            return 0;
        }
        int firstNameRes = fistName.compareTo(o.fistName);
        if(firstNameRes == 0) {
            int lastNameRes = lastName.compareTo(o.lastName);
            if(lastNameRes == 0) {
                return Integer.compare(zip, o.zip);
            } else {
                return lastNameRes;
            }
        } else {
            return firstNameRes;
        }
    }
    
}
