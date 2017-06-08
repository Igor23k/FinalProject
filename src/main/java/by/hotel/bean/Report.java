package by.hotel.bean;

import by.hotel.builder.ReportBuilder;

import java.util.ArrayList;
import java.util.List;
/**
 * Report.java
 * The class store objects with properties.
 * @author Igor Kozlov
 * @version 1.0
 */
public class Report<T> {
    /**
     * Property - room
     */
    private String year;
    /**
     * Property - room
     */
    private List<T> data;

    /**
     * Create new empty object
     */
    public Report(){
        super();
    }

    /** Create new object
     @param reportBuilder - builder report
     */
    public Report(ReportBuilder reportBuilder){
        this.year = reportBuilder.getYear();
    }

    /**
     * Function for get value {@link Report#year}
     * @return value of year
     */
    public String getYear() {
        return year;
    }

    /**
     * Function for set value of id {@link Report#year}
     * @param year - the year to be set.
     */
    public void setYear(String year) {
        this.year = year;
    }
    /**
     * Function for add data
     * @param value - the value to be added to data.
     */
    public void addItem(T value){
        if(data == null){
            data = new ArrayList<>();
        }
        data.add(value);
    }
    /**
     * Function for get value {@link Report#data}
     * @return value of data
     */
    public List<T> getData() {
        return data;
    }
}
