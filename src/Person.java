import java.util.Scanner;

public class Person {

    int[] num_of_guests = new int[8];
    String[] first_name = new String[8];
    String[] surname = new String[8];
    int[] credit = new int[8];

    Scanner input = new Scanner(System.in);


    public void initialise_guests() {
        for (int x = 0; x < 8; x++ ) num_of_guests[x] = 0;
    }

    public void initialise_first_name() {
        for (int x = 0; x < 8; x++ ) first_name[x] = "no guests";
    }

    public void initialise_surname() {
        for (int x = 0; x < 8; x++ ) surname[x] = "no guests";
    }


    public void paying_guest(int rmno) {

        Room obj=new Room();
        System.out.println(".........Information for the paying guest..........");
        System.out.print("Enter First name: ");
        first_name[rmno]=input.next();
        System.out.print("Enter Surname: ");
        surname[rmno]=input.next();
        System.out.print("Enter Credit Card number: ");
        credit[rmno] = input.nextInt();
    }

}
