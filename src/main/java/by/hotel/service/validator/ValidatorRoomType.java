package by.hotel.service.validator;

import by.hotel.service.exception.*;

import java.util.Map;

/**
 * ValidatorRoomType.java
 * Class contain  methods to validate.
 * validate - main method to validate parameters.
 * validateRoomsCountDigit - validate rooms count.
 * validateBedsCountDigit - validate beds count.
 * validateBathroomsCountDigit - validate bathrooms count.
 * validateSizeDigit - validate size.
 * validateCostPerDayDigit - validate cost per day.
 * validateAdditionalInfo - validate additional info.
 * @version 2.0
 * @autor Igor Kozlov
 */
public class ValidatorRoomType extends AbstractValidator{
    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectRoomBathroomsException if room bathrooms is incorrect
     * @throws IncorrectRoomsCountException if rooms count is incorrect
     * @throws IncorrectRoomBedsException if room beds is incorrect
     * @throws IncorrectRoomSizeException if room size is incorrect
     * @throws IncorrectCostException if room cost is incorrect
     * @throws IncorrectRoomAdditionalInfoException if room additional info is incorrect
     */
    public boolean validate(Map<String, String[]> data) throws IncorrectRoomBathroomsException, IncorrectRoomsCountException, IncorrectRoomBedsException, IncorrectRoomSizeException, IncorrectCostException, IncorrectRoomAdditionalInfoException {
        if (validateRoomsCountDigit(data.get("roomsCount")[0])
                & validateBedsCountDigit(data.get("bedsCount")[0])
                & validateBathroomsCountDigit(data.get("bathroomsCount")[0])
                & validateSizeDigit(data.get("size")[0])
                & validateAdditionalInfo(data.get("additionalInfo")[0])
                & validateCostPerDayDigit(data.get("costPerDay")[0])){
            return true;
        }
        return false;
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectRoomsCountException if rooms count is incorrect
     */
    private boolean validateRoomsCountDigit(String digit) throws IncorrectRoomsCountException {
        if(Integer.parseInt(digit) >= 0 & Integer.parseInt(digit) <= 5){
            return true;
        }
        throw new IncorrectRoomsCountException("Incorrect rooms count!");
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectRoomBedsException if room beds is incorrect
     */
    private boolean validateBedsCountDigit(String digit) throws IncorrectRoomBedsException {
        if(Integer.parseInt(digit) >= 0 & Integer.parseInt(digit) <= 7){
            return true;
        }
        throw new IncorrectRoomBedsException("Incorrect beds count!");
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectRoomBathroomsException if room bathrooms is incorrect
     */
    private boolean validateBathroomsCountDigit(String digit) throws IncorrectRoomBathroomsException {
        if(Integer.parseInt(digit) >= 0 & Integer.parseInt(digit) <= 3){
            return true;
        }
        throw new IncorrectRoomBathroomsException("Incorrect bathrooms count!");
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectRoomSizeException if room size is incorrect
     */
    private boolean validateSizeDigit(String digit) throws IncorrectRoomSizeException {
        if(Integer.parseInt(digit) >= 0 & Integer.parseInt(digit) <= 200){
            return true;
        }
        throw new IncorrectRoomSizeException("Incorrect room size!");
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectCostException if room cost is incorrect
     */
    private boolean validateCostPerDayDigit(String digit) throws IncorrectCostException {
        if(Float.parseFloat(digit) >= 0 & Float.parseFloat(digit) <= 100000){
            return true;
        }
        throw new IncorrectCostException("Incorrect room cost!");
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectRoomAdditionalInfoException if room additional info is incorrect
     */
    private boolean validateAdditionalInfo(String info) throws IncorrectRoomAdditionalInfoException {
        if (info.length() > 15 & info.length() < 85) {
            return true;
        }
        throw new IncorrectRoomAdditionalInfoException("Incorrect additional room info!");
    }
}
