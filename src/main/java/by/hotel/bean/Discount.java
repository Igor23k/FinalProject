package by.hotel.bean;

import by.hotel.builder.DiscountBuilder;

/**
 * Discount.java
 * The class store objects with properties
 * <b> id </ b> and <b> name </ b>.
 * @autor Igor Kozlov
 * @version 1.0
 */
public class Discount {
    /**
     * Property - id
     */
    private int id;

    /**
     * Property - discount's name
     */
    private String name;

    /**
     * Create new empty object
     */
    public Discount(){
    }

    /** Create new object
     @param discountBuilder - builder discount
     */
    public Discount(DiscountBuilder discountBuilder){
        this.id = discountBuilder.getId();
        this.name = discountBuilder.getName();
    }

    /**
     * Function for get value {@link Discount#id}
     * @return value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Function for set value of id {@link Discount#id}
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Function for get value {@link Discount#name}
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Function for set value of name {@link Discount#name}
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return name.equals(discount.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }
}
