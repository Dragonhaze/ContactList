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
        int index = 0;
        System.out.println("Contacts:");
        System.out.println("=========");
        for (Contact contact:
                contacts) {
            index++;
            System.out.println(index+" "+contact.toString());
        }
        System.out.println("=========");
    }
}
