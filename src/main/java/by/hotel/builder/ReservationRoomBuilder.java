package by.hotel.builder;

import by.hotel.bean.Reservation;
import by.hotel.bean.ReservationRoom;
import by.hotel.bean.Room;

/**
 * ReservationRoomBuilder.java
 * The class store objects with properties and methods.
 * This class is a template Builder.
 * <b> room </ b> and <b> reservation </ b>.
 * @autor Igor Kozlov
 * @version 1.0
 */
public class ReservationRoomBuilder {
    /**
     * Property - room
     */
    private Room room;
    /**
     * Property - reservation
     */
    private Reservation reservation;

    /**  Function for set value {@link ReservationRoomBuilder#room}
     *@param room - the room to be set.
     *@return object of class ReservationRoomBuilder
     */
    public ReservationRoomBuilder room(Room room){
        this.room = room;
        return this;
    }

    /**  Function for set value {@link ReservationRoomBuilder#reservation}
     *@param reservation - the reservation to be set.
     *@return object of class ReservationRoomBuilder
     */
    public ReservationRoomBuilder reservation(Reservation reservation){
        this.reservation = reservation;
        return this;
    }

    /**
     * Function for get value {@link ReservationRoom#room}
     * @return value of room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Function for get value {@link ReservationRoom#reservation}
     * @return value of reservation
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**  Function for build reservation room
     *@return object of class ReservationRoom
     */
    public ReservationRoom build(){
        return new ReservationRoom(this);
    }
}
