package duncan.model;

/**
 * Created by dunca on 24/05/2017.
 */
public class Contact {
    private String name;
    private String surname;
    private int mobile;
    private int home;
    private int work;
    private String address;

    public Contact(String name,int mobile) {
        setName(name);
        setSurname("");
        setMobile(mobile);
        setHome(0);
        setWork(0);
        setAddress("");
    }

    public Contact(String name, int mobile, int home, int work, String adress) {
        setName(name);
        setSurname("");
        setMobile(mobile);
        setHome(home);
        setWork(work);
        setAddress(adress);
    }

    public Contact(String name, String surname, int mobile, String address) {
        setName(name);
        setSurname(surname);
        setMobile(mobile);
        setHome(0);
        setWork(0);
        setAddress(address);
    }


    public Contact(String name, String surname, int mobile, int home, int work, String address) {
        setName(name);
        setSurname(surname);
        setMobile(mobile);
        setHome(home);
        setWork(work);
        setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        if (mobile >= 0) {
            this.mobile = mobile;
        }else {
            this.mobile = 0;
        }
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        if (home >= 0) {
            this.home = home;
        }else {
            this.home = 0;
        }
    }

    public int getWork() {
        return work;
    }

    public void setWork(int work) {
        if (work >= 0) {
            this.work = work;
        }else {
            this.work = 0;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
            return name + " " + surname + '\n' +
                    "Mobile  : " + mobile + '\n' +
                    "Home    : " + home + '\n' +
                    "Work    : " + work + '\n' +
                    "Address : " + address;
    }
}
