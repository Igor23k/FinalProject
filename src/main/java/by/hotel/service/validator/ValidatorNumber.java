package by.hotel.service.validator;

/**
 * ValidatorNumber.java
 * Class contain  methods to validate.
 * validate - main method to validate parameters.
 * @version 2.0
 * @author Igor Kozlov
 */
public class ValidatorNumber {
    /**
     * Validate parameters.
     * @param value - the param that needed to validate.
     * @return boolean value.
     */
    public static boolean validate(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
