package by.hotel.service.validator;

import by.hotel.service.exception.IncorrectDiscountNameException;

import java.util.Map;

/**
 * ValidatorDiscount.java
 * Class contain  methods to validate.
 * validate - main method to validate parameters.
 * validateNameDiscount - validate discount name.
 * @version 2.0
 * @autor Igor Kozlov
 */
public class ValidatorDiscount extends AbstractValidator {
    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectDiscountNameException if discount name is incorrect
     */
    public boolean validate(Map<String, String[]> data) throws IncorrectDiscountNameException {
        if (validateNameDiscount(data.get("name")[0])) {
            return true;
        }
        return false;
    }

    /**
     * Validate nameDiscount.
     * @return boolean value.
     * @throws IncorrectDiscountNameException if discount name is incorrect
     */
    private boolean validateNameDiscount(String nameDiscount) throws IncorrectDiscountNameException {
        if (nameDiscount.length() < 45 & nameDiscount.length() > 3) {
            return true;
        }
        throw new IncorrectDiscountNameException("Incorrect discount name!");
    }
}
