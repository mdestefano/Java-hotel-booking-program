package it.mandes.hotel;

public class Room {

    private static final String NOBODY = "nobody";
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

    public void reserveRoomFor(String guestName) throws NotEmptyRoomException {
        if(!isFree()){
            throw new NotEmptyRoomException("Selected room is not free");
        }

        this.guestName = guestName;
    }

    public void removeGuest(){
        guestName = NOBODY;
    }
}
