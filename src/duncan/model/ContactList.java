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
            int input;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduzca el numero del contacto que quieres eliminar");

            input = scanner.nextInt();
            contacts.remove(input);

        }
    }
    public void showContacts(){

        System.out.println("Contacts:");
        System.out.println("=========");
        for (Contact contact:
                contacts) {
            System.out.println((contacts.indexOf(contact)+1)+". "+contact.toString());
        }
        System.out.println("=========");
    }
}
