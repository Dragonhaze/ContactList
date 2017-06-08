package duncan.model;

import java.util.ArrayList;
import java.util.Scanner;

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
        }
    }

    public void removeContact(){
        if (!contacts.isEmpty()){
            String input;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Insert the first name of the contact you want to remove:");
            input = scanner.next();

            if (searchIndexOFContactByName(input) != -1){
                contacts.remove(searchIndexOFContactByName(input));
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


    public String searchContactByName(String name){
        for (Contact contact: contacts){
            if (contact.getName().equals(name)){
               return contact.toString();
            }
        }
        return null;
    }

    public int searchIndexOFContactByName(String name){
        for (Contact contact: contacts){
            if (contact.getName().equals(name)){
                return contacts.indexOf(contact);
            }
        }
        return -1;
    }
    public void askForName() {
        String contactName;
        System.out.println("Insert the first name of the contact you want to search for:");
        Scanner input = new Scanner(System.in);
        contactName = input.next();
        if (searchContactByName(contactName) != null){
            System.out.println(searchContactByName(contactName));
        }else{
            System.out.println("A contact by this name has not been found");
        }

    }
}
