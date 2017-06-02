package by.hotel.bean;

import by.hotel.builder.ReservationRoomBuilder;

/**
 * ReservationRoom.java
 * The class store objects with properties
 * <b> room </ b> and <b> reservation </ b>.
 * @autor Igor Kozlov
 * @version 1.0
 */
public class ReservationRoom {
    /**
     * Property - room
     */
    private Room room;
    /**
     * Property - reservation
     */
    private Reservation reservation;

    /**
     * Create new empty object
     */
    public ReservationRoom(){}

    /** Create new object
     @param reservationRoomBuilder - builder reservation room
     */
    public ReservationRoom(ReservationRoomBuilder reservationRoomBuilder){
        this.room = reservationRoomBuilder.getRoom();
        this.reservation = reservationRoomBuilder.getReservation();
    }

    /**
     * Function for get value {@link ReservationRoom#room}
     * @return value of room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Function for set value of room {@link ReservationRoom#room}
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Function for get value {@link ReservationRoom#reservation}
     * @return value of reservation
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     * Function for set value of reservation {@link ReservationRoom#reservation}
     */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationRoom that = (ReservationRoom) o;
        if (room != null ? !room.equals(that.room) : that.room != null) return false;
        return reservation != null ? reservation.equals(that.reservation) : that.reservation == null;
    }

    @Override
    public int hashCode() {
        int result = room != null ? room.hashCode() : 0;
        result = 31 * result + (reservation != null ? reservation.hashCode() : 0);
        return result;
    }
}
