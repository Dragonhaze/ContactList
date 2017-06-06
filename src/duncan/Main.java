package duncan;

import duncan.model.Contact;

public class Main {

    public static void main(String[] args) {

        Contact manolo = new Contact(
                "Manolo",
                "Sanchez",
                100000,
                2002304,
                2343240,
                "Calle calatrava nº1");

        Contact luis = new Contact(
                "Luis",
                1039478);

        System.out.println(manolo.toString());
        System.out.println(luis.toString());
    }
}
