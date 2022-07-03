import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;


public class Room {
    String roomName;
    int roomNum ;
    String[] room = new String[8];
    Scanner input = new Scanner(System.in);

    Queue<String> Waiting_name =new LinkedList<String>();    //define a queue

    public int getRoomNum() {
        return roomNum;
    }

    public void initialise() {
        for (int x = 0; x < 8; x++ ) room[x] = "e";

    }

    public void view_all_rooms() {
        System.out.println(".........Views All rooms.........");

        for (int x = 0; x < 8; x++ )
        {
            System.out.println("room " + x + " occupied by " + room[x]);
        }
        System.out.println("....................................");

    }

    public void add_Customer_to_a_room()
    {
        System.out.println(".........Adds customer to room.........");
        int rr=0;
        for (int x = 0; x < 8; x++ ) {
            if (room[x].equals("e")) {
                rr=rr+1;
            }
        }
        if (rr == 0){
            System.out.println("Enter room number (0-7) or 8 to stop:" );
            roomNum = input.nextInt();
            System.out.println("Enter customer name for the room " + roomNum +" :" ) ;
            roomName = input.next();

            Waiting_name.add(roomName);

            System.out.print("Enter number of guests in the room: ");
            int guest_num= input.nextInt();

            if (guest_num !=0){
                Person obj=new Person();
                obj.paying_guest(roomNum);
            }
            System.out.println("....................................");

        }
        else {
            System.out.println("Enter room number (0-7) or 8 to stop:" );
            roomNum = input.nextInt();
            if (room[roomNum].equals("e")) {
                System.out.println("Enter customer name for room " + roomNum +" :" ) ;
                roomName = input.next();
                room[roomNum] = roomName ;
                System.out.print("Enter number of guests in the room: ");
                int guest_num= input.nextInt();

                if (guest_num !=0){
                    Person obj=new Person();
                    obj.paying_guest(roomNum);
                }
                System.out.println("....................................");
            }
            else {
                System.out.println("that room is not empty.... ");
                System.out.println("....................................");
            }

        }

    }

    public void view_Empty_rooms()
    {

        System.out.println(".........Empty rooms.........");
        for (int x = 0; x < 8; x++ )
        {
            if (room[x].equals("e")) System.out.println("room " + x + " is empty");
        }
        System.out.println("....................................");
    }
    public void delete_customer_from_room()
    {
        System.out.println(".........Delete customer from room.........");
        System.out.println("Enter the customer room number : ");
        int dlt_customer = input.nextInt();
        input.nextLine();

        int rr=0;
        for (int x = 0; x < 8; x++ ) {
            if (room[x].equals("e")) {
                rr=rr+1;
            }
        }
        if (rr==0) {
            room[dlt_customer] = Waiting_name.poll();
        }
        else {
            room[dlt_customer] = "e" ;
        }






        System.out.println("....................................");
    }

    public void find_room_from_customer_name()
    {
        System.out.println("......... Find room from customer name.........");
        System.out.println("Enter the customer's name :");
        String find_customer = input.nextLine();
        input.nextLine();
        int index = 0;
        int index_valid =0;
        for (int x = 0; x < 8; x++ ) {
            if (room[x].equals(find_customer)) {
                index=x;
                index_valid=1;

            }
        }
        if (index_valid==1) {
            System.out.println(find_customer + "- room " + index);
        }
        else {
            System.out.println("There are no one called " + find_customer);
        }
        System.out.println("....................................");
    }

    public void Store_program_data_into_file()
    {
        try {
            FileWriter myWriter = new FileWriter("HotelExample_Data.txt");
            for (int x = 0; x < 8; x++ ){
                myWriter.write(room[x]+ "\n");
            }

            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Data saved into file successfully.........");
        System.out.println("....................................");
    }



    public void Load_program_data_from_file() {
        try{
            for (int x = 0; x < 8; x++ ){
                room[x] = Files.readAllLines(Paths.get("HotelExample_Data.txt")).get(x);
            }
        }
        catch(IOException e){
            System.out.println("e");
        }

        System.out.println("Data loaded successfully.........");
        System.out.println("....................................");
    }



    public void View_guests_Ordered_alphabetically_by_name()
    {
        System.out.println(".........View guests Ordered alphabetically by name.........");

        String temp;
        String str[] = new String[8];

        for (int x = 0; x < 8; x++ ){
            str[x]=room[x];
        }

        //Sorting the strings
        for (int i = 0; i < 8; i++)
        {
            for (int j = i + 1; j < 8; j++)
            {
                if (str[i].compareTo(str[j]) > 0)
                {
                    temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        System.out.println( Arrays.toString(str));
        System.out.println("....................................");
    }

}
