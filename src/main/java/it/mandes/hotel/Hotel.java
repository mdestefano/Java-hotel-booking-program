package it.mandes.hotel;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;




public class Hotel {

    static boolean MainMenu = true;
    static boolean SubMenu = true;
    static BufferedReader in;

    private final int capacity;
    private final Room[] rooms;

    public Hotel(int capacity) {
        this.capacity = capacity;
        rooms = new Room[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            rooms[i] = new Room();
        }
    }

    public Room[] getRooms() {
        return rooms;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isFreeRoom(int roomNumber){
        return rooms[roomNumber].isFree();
    }

    public void reserveRoom(int roomNumber, String guestName){
        rooms[roomNumber].reserveRoomFor(guestName);
    }
    
    public void freeRoom(int roomNumber){
        rooms[roomNumber].removeGuest();
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        in = new BufferedReader(new InputStreamReader(System.in));
        int hotelSize = 10;
        Hotel myHotel = new Hotel(hotelSize);

        int roomNum = 0;
        while (MainMenu) {
            while (SubMenu) {
                System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
                System.out.println("Hello and Welcome to our Hotel Program\nPlease keep hands and feet in the vehicle at all time.");
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Please select one of the options.");
                System.out.println("A: Book A New Room.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("E: Display Empty Rooms.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("V: View all Rooms.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("D: Delete customer from room.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("F: Find room from customer name.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("S: Store program data in to file.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("L: Load program data from file.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("O: View rooms Ordered alphabetically by name.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
                String Selection = ask("Choose operation>");
                Selection = Selection.toUpperCase();
                switch (Selection) {
                    case "A":
                        BookARoom(myHotel);
                        break;
                    case "E":
                        CheckIfEmpty(myHotel);
                        break;
                    case "V":
                        ViewAllRooms(myHotel);
                        break;
                    case "D":
                        DeleteCustomerFromRoom(myHotel);
                        break;
                    case "F":
                        FindRoomFromCustomerName(myHotel);
                        break;
                    case "S":
                        StoreProgramDataInToFile(myHotel);
                        break;
                    case "L":
                        LoadProgramDataFromFile(myHotel);
                        break;
                    case "O":
                        ViewRoomsOrderedAlphabeticallyByName(myHotel);
                        break;
                    default:
                        System.out.println("Invalid Selection");
                        break;
                }
                System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");
                System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                if (input.nextInt() == 1) {
                    SubMenu = true;
                } else {
                    SubMenu = false;
                }
            }
            SubMenu = true;
            System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("Would You Like To Continue With The Program\n1 ) Yes\n2 ) No");
            System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            if (input.nextInt() == 1) {
                MainMenu = true;
            } else {
                System.out.println("");
                System.exit(0);

            }
        }

    }

    private static void CheckIfEmpty(Hotel myHotel) {
        for (int i = 0; i < myHotel.getCapacity(); i++) {
            if (myHotel.isFreeRoom(i)) {
                System.out.println("room " + (i + 1) + " is empty");
            }
        }
    }

    private static void BookARoom(Hotel myHotel) {
        String guestName;
        int roomNum = Integer.parseInt(ask("Insert room number (1-10):")) - 1;
        guestName = ask("Insert name of the guest:");
        myHotel.reserveRoom(roomNum,guestName);
    }

    private static void ViewAllRooms(Hotel myHotel) {
        for (int x = 0; x < myHotel.getCapacity(); x++) {
            System.out.println("Room " + (x + 1) + " occupied by " + myHotel.getRooms()[x].getGuestName());
        }
    }

    private static void DeleteCustomerFromRoom(Hotel myHotel) {
        int roomNum = Integer.parseInt(ask("Insert room number (1-10):")) - 1;
        myHotel.freeRoom(roomNum);
        System.out.println("Room is now free");
    }

    private static void FindRoomFromCustomerName(Hotel myHotel) {
        Scanner input = new Scanner(System.in);
        String roomName;
        System.out.println("Enter name to Search for:");
        roomName = input.next();
        boolean Checker = false;
        for (int i = 0; i < myHotel.getCapacity(); i++) {
            if (roomName.equals(myHotel.getRooms()[i].getGuestName())) {
                System.out.println("The Account That Matches That name is Account number " + i);
                Checker = true;
            }
        }
        if (!Checker) {
            System.out.println("There are no Rooms Booked with that name\n(make sure you've used the correct CAP's)");
        }
    }

    private static void StoreProgramDataInToFile(Hotel myHotel) throws IOException {
        /*try (PrintWriter out = new PrintWriter(new FileWriter("/home/unix/student12/w1387769/outputfile.txt"))) {
            int x;
            for (x = 0; x < myHotel.getCapacity(); x++) {
                out.println("Name and Room number is: " + myHotel[x].getName() + "at: " + x);
            }

        }
        System.out.println("All Room Names have been Saved.");*/
        System.out.println("Not Implemented Yet");
    }

    private static void LoadProgramDataFromFile(Hotel myHotel) throws IOException {
        /*FileInputStream fs = new FileInputStream("/home/unix/student12/w1387769/inputfile.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        for (int i = 0; i < myHotel.getCapacity(); i++) {
            myHotel[i].setName(br.readLine());
        }*/
        System.out.println("Not Implemented Yet");
    }

    private static void ViewRoomsOrderedAlphabeticallyByName(Hotel myHotel) {
        String[] myStrArray = new String[myHotel.getCapacity()];
        for (int i = 0; i < myHotel.getCapacity(); i++) {
            myStrArray[i] = myHotel.getRooms()[i].getGuestName();
        }

        Arrays.sort(myStrArray);
        for (int a = 0; a < myStrArray.length; a++) {
            System.out.println(myStrArray[a]);
        }

    }

    private static String ask(String prompt){
        try {
            System.out.print(prompt+" ");
            return in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static class Room {

        private static final String NOBODY = "nobody";
        //protected String mainName;
        private String guestName;

        public Room() {
            guestName = NOBODY;
        }

        public String getGuestName() {
            return guestName;
        }

        public boolean isFree() {
            return guestName.equals(NOBODY);
        }

        public void reserveRoomFor(String guestName) {
            if(!isFree()){
                throw new RuntimeException("Selected room is not free");
            }
            
            this.guestName = guestName;
        }
        
        public void removeGuest(){
            guestName = NOBODY;
        }
    }
}
