package by.hotel.bean;

import by.hotel.builder.ReservationBuilder;

import java.sql.Date;

/**
 * Reservation.java
 * The class store objects with properties
 * @author Igor Kozlov
 * @version 1.0
 */
public class Reservation {
    /**
     * Property - id
     */
    private int id;
    /**
     * Property - accepted
     */
    private int accepted;
    /**
     * Property - dateIn
     */
    private String dateIn;
    /**
     * Property - dateOut
     */
    private String dateOut;
    /**
     * Property - user
     */
    private User user;
    /**
     * Property - discount
     */
    private Discount discount;

    /**
     * Create new empty object
     */
    public Reservation(){super();}

    /** Create new object
     @param reservationBuilder - builder reservation
     */
    public Reservation(ReservationBuilder reservationBuilder){
        this.id = reservationBuilder.getId();
        this.dateIn = reservationBuilder.getDateIn();
        this.dateOut = reservationBuilder.getDateOut();
        this.user = reservationBuilder.getUser();
        this.accepted = reservationBuilder.getAccepted();
        this.discount = reservationBuilder.getDiscount();
    }

    /**
     * Function for get value {@link Reservation#id}
     * @return value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Function for set value of id {@link Reservation#id}
     * @param id - the id to be set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Function for get value {@link Reservation#dateIn}
     * @return value of date In
     */
    public String getDateIn() {
        return dateIn;
    }

    /**
     * Function for set value of date In {@link Reservation#dateIn}
     * @param dateIn - the dateIn to be set.
     */
    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    /**
     * Function for get value {@link Reservation#dateOut}
     * @return value of date Out
     */
    public String getDateOut() {
        return dateOut;
    }

    /**
     * Function for set value of date Out {@link Reservation#dateOut}
     * @param dateOut - the dateOut to be set.
     */
    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    /**
     * Function for get value {@link Reservation#accepted}
     * @return value of accepted
     */
    public int getAccepted() {
        return accepted;
    }

    /**
     * Function for set value of Cost Additional Services {@link Reservation#accepted}
     * @param accepted - the accepted to be set.
     */
    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }

    /**
     * Function for get value {@link Reservation#discount}
     * @return value of discount
     */
    public Discount getDiscount() {
        return discount;
    }

    /**
     * Function for set value of discount {@link Reservation#discount}
     * @param discount - the discount to be set.
     */
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    /**
     * Function for get value {@link Reservation#user}
     * @return value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Function for set value of user {@link Reservation#user}
     * @param user - the user to be set.
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        if (accepted != that.accepted) return false;
        if (!dateIn.equals(that.dateIn)) return false;
        if (!dateOut.equals(that.dateOut)) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return discount != null ? discount.equals(that.discount) : that.discount == null;
    }

    @Override
    public int hashCode() {
        int result = dateIn.hashCode();
        result = 31 * result + dateOut.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + accepted;
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
    }
}
