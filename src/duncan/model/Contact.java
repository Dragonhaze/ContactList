package duncan.model;


import java.io.Serializable;
import java.util.Objects;

/**
 * This is an object that stores a contact
 */
public class Contact implements Comparable<Contact> , Serializable {
    private String name;
    private String surname;
    private int mobile;
    private int home;
    private int work;
    private String address;

    /**
     * This is the only constructor of the class with all of the parameters.
     * @param name name of the contact.
     * @param surname surname of the contact.
     * @param mobile mobile phone number.
     * @param home home phone number.
     * @param work work phone number.
     * @param address contact's adress.
     */
    public Contact(String name, String surname, int mobile, int home, int work, String address) {
        setName(name);
        setSurname(surname);
        setMobile(mobile);
        setHome(home);
        setWork(work);
        setAddress(address);
    }

    /**
     * Name's getter that returns the name of the contact
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Name's setter witch sets the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Surnames getter that returns the surname of the contact
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Surnames setter where surname is set
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * the getter for mobile
     * @return
     */
    public int getMobile() {
        return mobile;
    }

    /**
     * The setter for mobile that doesn't allow negative numbers
     * @param mobile
     */
    public void setMobile(int mobile) {
        if (mobile >= 0) {
            this.mobile = mobile;
        }else {
            this.mobile = 0;
        }
    }

    /**
     * the getter for home number
     * @return
     */
    public int getHome() {
        return home;
    }

    /**
     * The setter for home number that doesn't allow negative numbers
     * @param home
     */
    public void setHome(int home) {
        if (home >= 0) {
            this.home = home;
        }else {
            this.home = 0;
        }
    }

    /**
     * the getter for work number
     * @return
     */
    public int getWork() {
        return work;
    }

    /**
     * The setter for work number that doesn't allow negative numbers
     * @param work
     */
    public void setWork(int work) {
        if (work >= 0) {
            this.work = work;
        }else {
            this.work = 0;
        }
    }

    /**
     * the getter for address
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * the setter for address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * The toString method that turns the object into a string
     * @return
     */
    @Override
    public String toString() {

            return name + " " + surname + '\n' +
                    "Mobile  : " + mobile + '\n' +
                    "Home    : " + home + '\n' +
                    "Work    : " + work + '\n' +
                    "Address : " + address;
    }

    /**
     * This method is used for telling if two contact objects are the same, it only uses the name and the surname
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if( this == obj ) { return true; }

        if ( obj == null ) { return false; }

        if ( this.getClass() != obj.getClass() ) { return false; }

        Contact f = (Contact) obj;

        return Objects.equals(this.getName(), f.getName()) &&
                Objects.equals(this.getSurname(), f.getSurname()) ;

    }


    @Override
    public int compareTo(Contact cont) {

        int i = cont.getName().compareToIgnoreCase(this.getName());
        if (i != 0){
            return i;
        }

        return this.getSurname().compareToIgnoreCase(cont.getSurname());
    }
}
