package it.mandes.hotel;


public class Hotel {

    private final int capacity;
    private final Room[] rooms;

    public Hotel(int capacity) {
        this.capacity = capacity;
        rooms = new Room[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            rooms[i] = new Room();
        }
    }

    public int findRoomByGuest(String guestToFind) {
        int result = -1;
        for (int i = 0; i < capacity; i++) {
            if (guestToFind.trim().equals(rooms[i].getGuestName().trim())) {
                result = i + 1;
                break;
            }
        }
        return result;
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

    public void reserveRoom(int roomNumber, String guestName) throws NotEmptyRoomException {
        rooms[roomNumber].reserveRoomFor(guestName);
    }
    
    public void freeRoom(int roomNumber){
        rooms[roomNumber].removeGuest();
    }


}
