package duncan.controller;

import duncan.model.Contact;
import duncan.model.ContactList;

/**
 * Created by dunca on 06/06/2017.
 */
public class ContactApp {

    private ContactList contactList;

    public ContactApp(){
        contactList = new ContactList();
    }

    public void run(){
        contactList.addContact(new Contact(
                "Manolo",
                "Sanchez",
                100000,
                2002304,
                2343240,
                "Calle calatrava nº1"));

        contactList.addContact( new Contact(
                "Luis",
                1039478));
    }
}