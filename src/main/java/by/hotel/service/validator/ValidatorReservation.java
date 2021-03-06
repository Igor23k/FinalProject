package by.hotel.service.validator;

import by.hotel.service.exception.IncorrectCostException;
import by.hotel.service.exception.IncorrectDateException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by 1 on 18.04.2017.
 */
public class ValidatorReservation extends AbstractValidator {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public boolean validate(Map<String, String[]> data) throws IncorrectDateException, IncorrectCostException,NumberFormatException {
        if (validateDate(data.get("date-in")[0]) & validateDate(data.get("date-out")[0])
                & validateUnsignedIntDigit(data.get("cost_additional_services")[0])) {
            return true;
        }
        return false;
    }

    private boolean validateDate(String date) throws IncorrectDateException {
        try {
            return DATE_FORMAT.format(DATE_FORMAT.parse(date)).equals(date);
        } catch (ParseException ex) {
            throw new IncorrectDateException("Incorrect date!");
        }
    }

    private boolean validateUnsignedIntDigit(String digit) throws IncorrectCostException,NumberFormatException {
        if (Integer.parseInt(digit) >= 0) {
            return true;
        }
        throw new IncorrectCostException("Negative cost!");
    }
}
