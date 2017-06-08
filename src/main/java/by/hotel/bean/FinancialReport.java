package by.hotel.bean;

/**
 * DocumentObject.java
 * The class store objects with properties to create documents.
 * @author Igor Kozlov
 * @version 1.0
 */
public class FinancialReport {
    /**
     * Property - room
     */
    private int periodNumber;
    /**
     * Property - room
     */
    private int total;

    /**
     * Function for get value {@link FinancialReport#periodNumber}
     * @return value of periodNumber
     */
    public int getPeriodNumber() {
        return periodNumber;
    }

    /**
     * Function for set value of periodNumber {@link FinancialReport#periodNumber}
     * @param periodNumber - the periodNumber to be set.
     */
    public void setPeriodNumber(int periodNumber) {
        this.periodNumber = periodNumber;
    }

    /**
     * Function for get value {@link FinancialReport#total}
     * @return value of total
     */
    public int getTotal() {
        return total;
    }

    /**
     * Function for set value of total {@link FinancialReport#total}
     * @param total - the total to be set.
     */
    public void setTotal(int total) {
        this.total = total;
    }
}
