package duncan.controller;

import duncan.model.Contact;
import duncan.model.ContactList;

import java.util.InputMismatchException;
import java.util.Scanner;



/**
 * The controller for the application (where the magic happens)
 */
public class ContactApp {

    /**
     * This is the arraylist that is used for the rest of the class
     */
    private ContactList contactList;

    /**
     * The only constructor
     */
    public ContactApp(){
        contactList = new ContactList();
    }

    /**
     * This is the method invoked at the start of the program and at the end of each cycle,
     * it contains the switch that lets the user determine what option the y want to use and also reads the contacts from the file.
     */
    public void start() {
        contactList.readFromFile();

        int option;

        while ((option = showMenu()) != 0) {
            switch (option) {
                case 1:
                    Contact contact = askContactInfo();
                    if (contact == null){
                        start();
                    }else {
                        contactList.addContact(askContactInfo());
                    }

                    break;
                case 2:
                    contactList.removeContact();
                    break;
                case 3:
                    contactList.showContacts();
                    break;
                case 4:
                    contactList.askForName();
                    break;
                case -1:
                    System.out.println("Introduce a valid option");
                    break;
            }
        }
    }

    /**
     * This method is a user friendly way to create a new contact object and store it in the arraylist.
     * @return it returns the fully formed contact.
     */
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
            address = scanner.next().trim().replaceAll("\\s+", " ");
        } while (address.equals(""));

        return new Contact(name, surname, mobile, home, work, address);

    }

    /**
     * This method shows a graphical representation of the menu and also records the user's input
     * @return It returns the user's option
     */
    private int showMenu(){
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("**********Contacts**********");
        System.out.println("* 1 - Add contact          *");
        System.out.println("* 2 - Remove contact       *");
        System.out.println("* 3 - List contacts        *");
        System.out.println("* 4 - Search contact       *");
        System.out.println("* 0 - Exit                 *");
        System.out.println("****************************");
        System.out.println("Option: ");

        try{
            option = scanner.nextInt();
        }catch (InputMismatchException e){
            return -1;
        }
            if (option != 1 && option !=2 && option !=3 && option !=4 && option !=0){
                return -1;
            }

        return option;
    }

}