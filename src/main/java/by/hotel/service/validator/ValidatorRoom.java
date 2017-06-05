package by.hotel.service.validator;

import by.hotel.service.exception.*;

import java.util.Map;

/**
 * ValidatorRoom.java
 * Class contain  methods to validate.
 * validate - main method to validate parameters.
 * validateNameRoom - validate name room.
 * validatePhone - validate phone.
 * validatePath - validate path.
 * @version 2.0
 * @author Igor Kozlov
 */
public class ValidatorRoom extends AbstractValidator {
    /**
     * Validate parameters.
     * @param data - the param that needed to validate.
     * @return boolean value.
     * @throws IncorrectRoomNameException if room name is incorrect
     * @throws IncorrectRoomPhoneNumberException if room phone is incorrect
     */
    public boolean validate(Map<String, String[]> data) throws IncorrectRoomNameException, IncorrectRoomPhoneNumberException {
        if (validateNameRoom(data.get("name")[0]) & validatePhone(data.get("phone")[0])) {
            return true;
        }
        return false;
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectRoomNameException if room name is incorrect
     */
    private boolean validateNameRoom(String nameRole) throws IncorrectRoomNameException {
        if (nameRole.length() <= 45 & nameRole.length() >= 5) {
            return true;
        }
        throw new IncorrectRoomNameException("Incorrect room name!");
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectRoomPhoneNumberException if room phone is incorrect
     */
    private boolean validatePhone(String phone) throws IncorrectRoomPhoneNumberException {
        if (phone.length() <= 45 & phone.length() > 5) {
            return true;
        }
        throw new IncorrectRoomPhoneNumberException("Incorrect room phone number!");
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectRoomPathException if room path is incorrect
     */
    private boolean validatePath(String path) throws IncorrectRoomPathException {
        if (path.length() <= 200 & path.length() > 5) {
            return true;
        }
        throw new IncorrectRoomPathException("Incorrect room path!");
    }
}
