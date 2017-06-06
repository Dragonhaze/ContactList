package duncan.controller;

import duncan.model.Contact;
import duncan.model.ContactList;

import java.util.Scanner;

/**
 * Created by dunca on 06/06/2017.
 */
public class ContactApp {

    private ContactList contactList;

    public ContactApp(){
        contactList = new ContactList();
    }

    public void start() {
        int option;

        while ((option = showMenu()) != 0) {
            switch (option) {
                case 1:
                    contactList.addContact(askContactInfo());
                    break;
                case 2:
                    contactList.removeContact();
                    break;
                case 3:
                    ;
                    break;
                case 4:
                    ;
                    break;
                case 5:
                    ;
                    break;
            }
        }
    }
    private Contact askContactInfo() {
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
            mobile = scanner.nextInt();
        } while (mobile < 0);

        do {
            System.out.println("Home");
            home = scanner.nextInt();
        } while (home < 0);

        do {
            System.out.println("Work");
            work = scanner.nextInt();
        } while (work < 0);

        do {
            System.out.println("Address:");
            address = scanner.next().trim().replaceAll("\\s+", " ");
        } while (address.equals(""));

        return new Contact(name, surname, mobile, home, work, address);

    }

    public void run(){
        contactList.addContact(new Contact(
                "Manolo",
                "Sanchez",
                100000,
                2002304,
                2343240,
                "Calle calatrava nº1"));
    }

    private int showMenu(){
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("**********Contacts**********");
        System.out.println("* 1 - Add contact          *");
        System.out.println("* 2 - Remove contact       *");
        System.out.println("* 3 - List contacts        *");
        System.out.println("* 4 - Search contact       *");
        System.out.println("* 5 - Save contacts        *");
        System.out.println("* 0 - Exit                 *");
        System.out.println("****************************");
        System.out.println("Opción: ");

        option = scanner.nextInt();

        return option;
    }
}