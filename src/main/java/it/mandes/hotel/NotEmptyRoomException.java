package it.mandes.hotel;

public class NotEmptyRoomException extends Exception {
    public NotEmptyRoomException(String message) {
        super(message);
    }

    public NotEmptyRoomException() {
        super ("Selectd room is not empty");
    }
}
