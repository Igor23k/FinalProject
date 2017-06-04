package by.hotel.service.validator;

import by.hotel.service.exception.IncorrectNameRoleException;
import by.hotel.service.exception.IncorrectRightRoleException;

import java.util.Map;

/**
 * ValidatorRole.java
 * Class contain  methods to validate.
 * validate - main method to validate parameters.
 * validateNameRole - validate name role.
 * validateRight - validate rights.
 * @version 2.0
 * @author Igor Kozlov
 */
public class ValidatorRole extends AbstractValidator{
    /**
     * Validate parameters.
     * @param data - the param that needed to validate.
     * @return boolean value.
     * @throws IncorrectRightRoleException if right is incorrect
     * @throws IncorrectNameRoleException if name role is incorrect
     */
    public boolean validate(Map<String, String[]> data) throws IncorrectRightRoleException, IncorrectNameRoleException {
        if (validateNameRole(data.get("nameRole")[0]) & validateRight(data.get("update")[0]) & validateRight(data.get("delete")[0])
                &validateRight(data.get("insert")[0]) & validateRight(data.get("create")[0]) & validateRight(data.get("select")[0])
                &validateRight(data.get("drop")[0]) & validateRight(data.get("grant")[0])){
            return true;
        }
        return false;
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectNameRoleException if right is incorrect
     */
    private boolean validateNameRole(String nameRole) throws IncorrectNameRoleException {
        if (nameRole.length() > 3 & nameRole.length() < 50) {
            return true;
        }
        throw new IncorrectNameRoleException("Incorrect name role!");
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectRightRoleException if name role is incorrect
     */
    private boolean validateRight(String right)throws IncorrectRightRoleException {
        if(Integer.parseInt(right) == 0 | Integer.parseInt(right) == 1){
            return true;
        }
        throw new IncorrectRightRoleException("Incorrect right role!");
    }
}
