package by.hotel.builder;

import by.hotel.bean.Discount;
import by.hotel.bean.Reservation;
import by.hotel.bean.User;

import java.sql.Date;

/**
 * ReservationBuilder.java
 * The class store objects with properties and methods.
 * This class is a template Builder.
 * <b> id </ b>, <b> dateIn </ b>, <b> dateOut </ b>,
 * <b> costAdditionalServices </ b>, <b> user </ b> and <b> discount </ b>.
 * @autor Igor Kozlov
 * @version 1.0
 */
public class ReservationBuilder {
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

    /**  Function for set value {@link ReservationBuilder#id}
     *@param id - the id to be set.
     *@return object of class ReservationBuilder
     */
    public ReservationBuilder id(int id){
        this.id = id;
        return this;
    }

    /**  Function for set value {@link ReservationBuilder#id}
     *@param user - the user to be set.
     *@return object of class ReservationBuilder
     */
    public ReservationBuilder user(User user){
        this.user = user;
        return this;
    }

    /**  Function for set value {@link ReservationBuilder#id}
     *@param dateIn - the dateIn to be set.
     *@return object of class ReservationBuilder
     */
    public ReservationBuilder dateIn(Date dateIn){
        this.dateIn = dateIn;
        return this;
    }

    /**  Function for set value {@link ReservationBuilder#dateOut}
     *@param dateOut - the dateOut to be set.
     *@return object of class ReservationBuilder
     */
    public ReservationBuilder dateOut(Date dateOut){
        this.dateOut = dateOut;
        return this;
    }

    /**  Function for set value {@link ReservationBuilder#costAdditionalServices}
     *@param costAdditionalServices - the costAdditionalServices to be set.
     *@return object of class ReservationBuilder
     */
    public ReservationBuilder costAdditionalServices(int costAdditionalServices){
        this.costAdditionalServices = costAdditionalServices;
        return this;
    }

    /**  Function for set value {@link ReservationBuilder#discount}
     *@param discount - the discount to be set.
     *@return object of class ReservationBuilder
     */
    public ReservationBuilder discount(Discount discount){
        this.discount = discount;
        return this;
    }

    /**
     * Function for get value {@link ReservationBuilder#id}
     * @return value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Function for get value {@link ReservationBuilder#dateIn}
     * @return value of date In
     */
    public Date getDateIn() {
        return dateIn;
    }

    /**
     * Function for get value {@link ReservationBuilder#dateOut}
     * @return value of date Out
     */
    public Date getDateOut() {
        return dateOut;
    }

    /**
     * Function for get value {@link ReservationBuilder#user}
     * @return value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Function for get value {@link ReservationBuilder#costAdditionalServices}
     * @return value of Cost Additional Services
     */
    public int getCostAdditionalServices() {
        return costAdditionalServices;
    }

    /**
     * Function for get value {@link ReservationBuilder#discount}
     * @return value of discount
     */
    public Discount getDiscount() {
        return discount;
    }

    /**  Function for build reservation
     *@return object of class Reservation
     */
    public Reservation build(){
        return new Reservation(this);
    }
}
