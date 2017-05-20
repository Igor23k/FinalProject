package by.hotel.bean;

import by.hotel.builder.ReservationBuilder;

import java.sql.Date;

/**
 * The class store objects with properties
 * <b> id </ b>, <b> dateIn </ b>, <b> dateOut </ b>,
 * <b> costAdditionalServices </ b>, <b> user </ b> and <b> discount </ b>.
 * @autor Igor Kozlov
 * @version 1.0
 */
public class Reservation {
    /**
     * Property - id
     */
    private int id;
    /**
     * Property - costAdditionalServices
     */
    private int costAdditionalServices;
    /**
     * Property - dateIn
     */
    private Date dateIn;
    /**
     * Property - dateOut
     */
    private Date dateOut;
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
        this.costAdditionalServices = reservationBuilder.getCostAdditionalServices();
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
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Function for get value {@link Reservation#dateIn}
     * @return value of date In
     */
    public Date getDateIn() {
        return dateIn;
    }

    /**
     * Function for set value of date In {@link Reservation#dateIn}
     */
    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    /**
     * Function for get value {@link Reservation#dateOut}
     * @return value of date Out
     */
    public Date getDateOut() {
        return dateOut;
    }

    /**
     * Function for set value of date Out {@link Reservation#dateOut}
     */
    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    /**
     * Function for get value {@link Reservation#costAdditionalServices}
     * @return value of Cost Additional Services
     */
    public int getCostAdditionalServices() {
        return costAdditionalServices;
    }

    /**
     * Function for set value of Cost Additional Services {@link Reservation#costAdditionalServices}
     */
    public void setCostAdditionalServices(int costAdditionalServices) {
        this.costAdditionalServices = costAdditionalServices;
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
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        if (costAdditionalServices != that.costAdditionalServices) return false;
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
        result = 31 * result + costAdditionalServices;
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
    }
}
