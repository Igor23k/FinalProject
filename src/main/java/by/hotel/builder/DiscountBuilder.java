package by.hotel.builder;

import by.hotel.bean.Discount;

/**
 * DiscountBuilder.java
 * The class store objects with properties and methods.
 * This class is a template Builder.
 * @author Igor Kozlov
 * @version 1.0
 */
public class DiscountBuilder {
    /**
     * Property - id
     */
    private int id;

    /**
     * Property - discount's name
     */
    private String name;

    /**  Function for set value {@link DiscountBuilder#id}
     *@param id - the id to be set.
     *@return object of class DiscountBuilder
     */
    public DiscountBuilder id(int id){
        this.id = id;
        return this;
    }

    /**  Function for set value {@link DiscountBuilder#name}
     *@param name - the name to be set.
     *@return object of class DiscountBuilder
     */
    public DiscountBuilder name(String name){
        this.name = name;
        return this;
    }

    /**
     * Function for get value {@link DiscountBuilder#id}
     * @return value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Function for get value {@link DiscountBuilder#name}
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**  Function for build discount
     *@return object of class Discount
     */
    public Discount build(){
        return new Discount(this);
    }
}
