import java.util.Scanner;

public class Hotel {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        Room r1=new Room();
        r1.initialise();

        Person r2=new Person();
        r2.initialise_guests();
        r2.initialise_first_name();
        r2.initialise_surname();

        System.out.println("Enter 'V' to view all rooms...");
        System.out.println("Enter 'A' to add Customer to a room...");
        System.out.println("Enter 'E' to view Empty rooms...");
        System.out.println("Enter 'D' to delete customer from room...");
        System.out.println("Enter 'F' to find room from customer name...");
        System.out.println("Enter 'S' to Store program data into file..");
        System.out.println("Enter 'L' to Load program data from file..");
        System.out.println("Enter 'O' to View guests Ordered alphabetically by name..");
        System.out.println("....................................");

        int x=0;
        int roomNum=0;
        while ( roomNum < 6 )
        {
            System.out.print("Enter: ");
            String choice= input.nextLine();

            switch (choice) {
                case "V":
                    r1.view_all_rooms();  //view  all rooms
                    break;
                case "A":
                    r1.add_Customer_to_a_room();  // add customer
                    break;
                case "E":
                    r1.view_Empty_rooms();  //empty rooms
                    break;
                case "D":
                    r1.delete_customer_from_room();  //delete customer
                    break;
                case "F":
                    r1.find_room_from_customer_name(); //find room
                    break;
                case "S":
                    r1.Store_program_data_into_file(); //store data to a file
                    break;
                case "L":
                    r1.Load_program_data_from_file();//load data from the file
                    break;
                case "O":
                    r1.View_guests_Ordered_alphabetically_by_name(); // view guests names alphabetically by name
                    break;
            }

        }
    }
}
