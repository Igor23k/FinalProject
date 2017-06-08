package by.hotel.builder;


import by.hotel.bean.Report;

/**
 * ReportBuilder.java
 * The class store objects with properties and methods.
 * This class is a template Builder.
 * @author Igor Kozlov
 * @version 1.0
 */
public class ReportBuilder<T> {
    /**
     * Property - year
     */
    private String year;

    /**  Function for set value {@link ReportBuilder#year}
     *@param year - the year to be set.
     *@return object of class ReportBuilder
     */
    public ReportBuilder year(String year){
        this.year = year;
        return this;
    }

    /**
     * Function for get value {@link ReportBuilder#year}
     * @return value of year
     */
    public String getYear() {
        return year;
    }

    /**  Function for build report
     *@return object of class Report
     */
    public Report<T> build(){
        return new Report<>(this);
    }
}
