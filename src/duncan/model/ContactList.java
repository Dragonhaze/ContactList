package duncan.model;

import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by dunca on 24/05/2017.
 */
public class ContactList {
    private ArrayList<Contact> contacts;

    public ContactList(ArrayList<Contact> contacts) {
        this.contacts = new ArrayList<Contact>();
    }

    public ContactList() {
        this.contacts = new ArrayList<Contact>();
    }

    public void addContact(Contact contact){
        if (contact != null){
            contacts.add(contact);
            saveToFile();
        }
    }

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
    public void showContacts(){

        System.out.println("Contacts:");
        System.out.println("=========");
        for (Contact contact:
                contacts) {
            System.out.println((contacts.indexOf(contact)+1)+". "+contact.toString());
            System.out.println("=========");
        }

    }


    public String searchContactByName(String name,String surname){
        for (Contact contact: contacts){
            if (contact.getName().equals(name) && contact.getSurname().equals(surname)){
               return contact.toString();
            }
        }
        return null;
    }

    public int searchIndexOFContactByName(String name,String surname){
        for (Contact contact: contacts){
            if (contact.getName().equals(name)&& contact.getSurname().equals(surname)){
                return contacts.indexOf(contact);
            }
        }
        return -1;
    }
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

    public void saveToFile(){
        try {
            FileOutputStream fos = new FileOutputStream("data/contacts.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < contacts.size() ; i++) {
                oos.writeObject(contacts.get(i));
            }
            oos.close();

        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(){
        try {
            FileInputStream fis = new FileInputStream("data/contacts.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Contact result = (Contact) ois.readObject();
            ois.close();
            System.out.println(result.toString());
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
