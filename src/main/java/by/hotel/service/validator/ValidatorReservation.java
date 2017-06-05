package by.hotel.service.validator;

import by.hotel.service.exception.IncorrectAcceptedException;
import by.hotel.service.exception.IncorrectDateException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * ValidatorReservation.java
 * Class contain  methods to validate.
 * validate - main method to validate parameters.
 * validateDate - validate date.
 * validateUnsignedIntDigit - validate cost additional services.
 * @version 2.0
 * @author Igor Kozlov
 */
public class ValidatorReservation extends AbstractValidator {

    /**
     * Field - DATE_FORMAT
     */
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Validate parameters.
     * @param data - the param that needed to validate.
     * @return boolean value.
     * @throws IncorrectDateException if date is incorrect
     * @throws IncorrectAcceptedException if cost is incorrect
     * @throws NumberFormatException if cost is incorrect
     */
    public boolean validate(Map<String, String[]> data) throws IncorrectDateException, IncorrectAcceptedException,NumberFormatException {
        if (validateDate(data.get("dateIn")[0]) & validateDate(data.get("dateOut")[0])
                & validateUnsignedIntDigit(data.get("accepted")[0])) {
            return true;
        }
        return false;
    }
    /**
     * Validate date.
     * @return boolean value.
     * @throws IncorrectDateException if date is incorrect
     */
    private boolean validateDate(String date) throws IncorrectDateException {
        try {
            return DATE_FORMAT.format(DATE_FORMAT.parse(date)).equals(date);
        } catch (ParseException ex) {
            throw new IncorrectDateException("Incorrect date!");
        }
    }
    /**
     * Validate accepted.
     * @return boolean value.
     * @throws IncorrectAcceptedException if accepted is negative
     * @throws NumberFormatException if accepted is incorrect
     */
    private boolean validateUnsignedIntDigit(String digit) throws IncorrectAcceptedException,NumberFormatException {
        if (ValidatorNumber.validate(digit)) {
            if (Integer.parseInt(digit) >= 0) {
                return true;
            }
            throw new IncorrectAcceptedException("Negative accepted!");
        }
        throw new NumberFormatException("Wrong data");
    }
}
