package it.mandes.hotel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean MainMenu = true;
    static boolean SubMenu = true;
    static BufferedReader in;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        in = new BufferedReader(new InputStreamReader(System.in));
        int hotelSize = 10;
        Hotel myHotel = new Hotel(hotelSize);

        while (MainMenu) {
            while (SubMenu) {
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("Hello and Welcome to our Hotel Program\nPlease keep hands and feet in the vehicle at all time.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("Please select one of the options.");
                System.out.println("A: Book A New Room.");
                System.out.println("E: Display Empty Rooms.");
                System.out.println("V: View all Rooms.");
                System.out.println("D: Delete customer from room.");
                System.out.println("F: Find room from customer name.");
                System.out.println("S: Store program data in to file.");
                System.out.println("L: Load program data from file.");
                System.out.println("O: View rooms Ordered alphabetically by name.");
                System.out.println("---------------------------------------------------------------------------------------");
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
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");
                System.out.println("---------------------------------------------------------------------------------------");
                if (input.nextInt() == 1) {
                    SubMenu = true;
                } else {
                    SubMenu = false;
                }
            }
            SubMenu = true;
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("Would You Like To Continue With The Program\n1 ) Yes\n2 ) No");
            System.out.println("---------------------------------------------------------------------------------------");
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
        try {
            myHotel.reserveRoom(roomNum, guestName);
        } catch (NotEmptyRoomException e) {
            System.out.println(e.getMessage());
            System.out.println("Try with another room");
        }
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
        String guestToFind = ask("Enter name to search for:");
        int roomNumber = myHotel.findRoomByGuest(guestToFind);
        if (roomNumber > 0) {
            System.out.println(guestToFind + " has reserved room " + roomNumber);
        } else {
            System.out.println(guestToFind + " has not reserved any room");
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

    private static String ask(String prompt) {
        try {
            System.out.print(prompt + " ");
            return in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}