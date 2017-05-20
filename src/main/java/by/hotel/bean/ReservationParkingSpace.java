package by.hotel.bean;

import by.hotel.builder.ReservationParkingSpaceBuilder;

/**
 * The class store objects with properties
 * <b> reservation </ b> and <b> parkingSpace </ b>.
 * @autor Igor Kozlov
 * @version 1.0
 */
public class ReservationParkingSpace {
    /**
     * Property - reservation
     */
    private Reservation reservation;
    /**
     * Property - parkingSpace
     */
    private ParkingSpace parkingSpace;

    /**
     * Create new empty object
     */
    public ReservationParkingSpace(){}

    /** Create new object
     @param reservationParkingSpaceBuilder - builder reservationParkingSpaceBuilder
     */
    public ReservationParkingSpace(ReservationParkingSpaceBuilder reservationParkingSpaceBuilder){
        this.reservation = reservationParkingSpaceBuilder.getReservation();
        this.parkingSpace = reservationParkingSpaceBuilder.getParkingSpace();
    }

    /**
     * Function for get value {@link ReservationParkingSpace#reservation}
     * @return value of reservation
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     * Function for set value of reservation {@link ReservationParkingSpace#reservation}
     */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    /**
     * Function for get parkingSpace {@link ReservationParkingSpace#parkingSpace}
     * @return value of id
     */
    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    /**
     * Function for set value of parkingSpace {@link ReservationParkingSpace#parkingSpace}
     */
    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationParkingSpace that = (ReservationParkingSpace) o;
        if (reservation != null ? !reservation.equals(that.reservation) : that.reservation != null) return false;
        return parkingSpace != null ? parkingSpace.equals(that.parkingSpace) : that.parkingSpace == null;
    }

    @Override
    public int hashCode() {
        int result = reservation != null ? reservation.hashCode() : 0;
        result = 31 * result + (parkingSpace != null ? parkingSpace.hashCode() : 0);
        return result;
    }
}
