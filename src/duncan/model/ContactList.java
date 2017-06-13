package duncan.model;


import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is a class that stores an arraylist of contacts
 */
public class ContactList {
    private ArrayList<Contact> contacts;

    /**
     * Sole constructor for this class, no more are needed
     */
    public ContactList() {
        this.contacts = new ArrayList<Contact>();
    }

    /**
     * This method adds a contact to the contactList and then saves it to the file where the contacts are stored.
     * @param contact contact that is added.
     */
    public void addContact(Contact contact){
        if (contact != null){
            contacts.add(contact);
            saveToFile();
        }
    }

    /**
     * This method removes a contact from the arraylist if it's not empty, It asks for the name, surname and looks for the contact in the list
     * if it's found it is deleted and the new state is saved.
     */
    public void removeContact(){
        if (!contacts.isEmpty()){
            String contactName;
            String contactSurname;
            Scanner input = new Scanner(System.in);
            System.out.println("Insert the first name of the contact you want to search for:");
            contactName = input.next();
            System.out.println("Insert the last name of the contact you want to search for:");
            contactSurname= input.next();

            if (searchIndexOFContactByName(contactName,contactSurname) != -1){
                contacts.remove(searchIndexOFContactByName(contactName,contactSurname));
                saveToFile();
            }else {
                System.out.println("A contact by this name has not been found");
            }


        }
    }

    /**
     * Lists all contacts in the arraylist
     */
    public void showContacts(){

        if (contacts.isEmpty()){
            System.out.println("There are no contacts");
        }else {
            System.out.println("Contacts:");
            System.out.println("=========");
            for (Contact contact :
                    contacts) {
                System.out.println((contacts.indexOf(contact) + 1) + ". " + contact.toString());
                System.out.println("=========");
            }
        }
    }

    /**
     * Searches for the contact by Name and surname and reruns the contact, if found, as a string, if not it returns null.
     * @param name name of the contact.
     * @param surname surname of the contact.
     * @return The toString of the contact if it is found if not it returns null.
     */
    public String searchContactByName(String name,String surname){
        for (Contact contact: contacts){
            if (contact.getName().equals(name) && contact.getSurname().equals(surname)){
               return contact.toString();
            }
        }
        return null;
    }

    /**
     * Does the same as the method above but it returns the index of the contact,if found, and a -1 if not.
     * @param name name of the contact.
     * @param surname surname of the contact.
     * @return The indexOf the contact found or a -1 if not.
     */
    public int searchIndexOFContactByName(String name,String surname){
        for (Contact contact: contacts){
            if (contact.getName().equals(name)&& contact.getSurname().equals(surname)){
                return contacts.indexOf(contact);
            }
        }
        return -1;
    }

    /**
     * Asks for the name of the user and searches for it using the searchContactByName method and prints the string that it returns.
     */
    public void askForName() {
        String contactName;
        String contactSurname;
        Scanner input = new Scanner(System.in);
        System.out.println("Insert the first name of the contact you want to search for:");
        contactName = input.next();
        System.out.println("Insert the last name of the contact you want to search for:");
        contactSurname= input.next();
        if (searchContactByName(contactName,contactSurname) != null){
            System.out.println(searchContactByName(contactName,contactSurname));
        }else{
            System.out.println("A contact by this name and surname has not been found");
        }

    }

    /**
     * Saves the current state of the arraylist in a file in the data directory
     */
    public void saveToFile(){
        try {
            FileOutputStream fos = new FileOutputStream("data/contacts.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(contacts);

            oos.close();

        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the contacts file from the data directory and overwrites the previous arraylist with the one extracted from the file.
     */
    public void readFromFile(){
        try {

            FileInputStream fis = new FileInputStream("data/contacts.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            contacts = (ArrayList<Contact>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file found to load contacts from, it will de created automatically");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is a user friendly way to create a new contact object and store it in the arraylist.
     * @return it returns the fully formed contact.
     */
    public Contact askContactInfo() {
        Scanner scanner = new Scanner(System.in);
        String name, surname, address;
        int mobile, home, work;

        do {
            System.out.println("Name");
            name = scanner.next().trim().replaceAll("\\s+", " ");
        } while (name.equals(""));

        scanner.nextLine();

        do {
            System.out.println("Surname");
            surname = scanner.nextLine().trim().replaceAll("\\s+", " ");
        } while (surname.equals(""));
        do {
            System.out.println("Mobile");
            try{
                mobile = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Number not valid");
                return null;
            }


        } while (mobile < 0);

        do {
            System.out.println("Home");
            try{
                home = scanner.nextInt();
            }catch (InputMismatchException f){
                System.out.println("Number not valid");
                return null;
            }
        } while (home < 0);

        do {

            System.out.println("Work");
            try{
                work = scanner.nextInt();}
            catch (InputMismatchException n ) {
                System.out.println("Number not valid");
                return null;
            }
        } while (work < 0);


        do {
            System.out.println("Address:");
            scanner.nextLine();
            address = scanner.nextLine().trim().replaceAll("\\s+", " ");
        } while (address.equals(""));

        return new Contact(name, surname, mobile, home, work, address);

    }

    /**
     * This method
     */
    public void editContact(){
        String contactName;
        String contactSurname;
        Scanner input = new Scanner(System.in);
        System.out.println("Insert the first name of the contact you want to search for:");
        contactName = input.next();
        System.out.println("Insert the last name of the contact you want to search for:");
        contactSurname= input.next();
        if (searchIndexOFContactByName(contactName,contactSurname) == -1){
            System.out.println("Contact not found");
        }

            if (contacts.set(searchIndexOFContactByName(contactName,contactSurname),askContactInfo()) == null){
                System.out.println("Not valid");
                readFromFile();
            }

    }
}
