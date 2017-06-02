package by.hotel.service.validator;

import java.util.Map;

/**
 * AbstractValidator.java
 * Class contain common method to validators.
 * validate - method to validate parameters.
 * @version 2.0
 * @autor Igor Kozlov
 */
public abstract class AbstractValidator {
    /**
     * Validate parameters.
     * @return boolean value.
     * @throws Exception if parameters is incorrect
     */
    public abstract boolean validate(Map<String, String[]> data) throws Exception;
}
