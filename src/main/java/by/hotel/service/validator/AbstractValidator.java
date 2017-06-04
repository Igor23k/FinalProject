package by.hotel.service.validator;

import java.util.Map;

/**
 * AbstractValidator.java
 * Class contain common method to validators.
 * validate - method to validate parameters.
 * @version 2.0
 * @author Igor Kozlov
 */
public abstract class AbstractValidator {
    /**
     * Validate parameters.
     * @param data - the param that needed to validate.
     * @return boolean value.
     * @throws Exception if parameters is incorrect
     */
    public abstract boolean validate(Map<String, String[]> data) throws Exception;
}
