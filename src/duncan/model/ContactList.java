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
            String contactName;
            String contactSurname;
            Scanner input = new Scanner(System.in);
            System.out.println("Insert the first name of the contact you want to search for:");
            contactName = input.next();
            System.out.println("Insert the last name of the contact you want to search for:");
            contactSurname= input.next();

            if (searchIndexOFContactByName(contactName,contactSurname) != -1){
                contacts.remove(searchIndexOFContactByName(contactName,contactSurname));
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
}
