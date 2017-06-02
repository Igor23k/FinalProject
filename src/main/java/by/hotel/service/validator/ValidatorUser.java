package by.hotel.service.validator;

import by.hotel.service.exception.*;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ValidatorUser.java
 * Class contain  methods to validate.
 * validate - main method to validate parameters.
 * validatePassportNumber - validate passport number.
 * validateUserName - validate user's name.
 * validateUserSurName - validate user's surname.
 * validateMobilePhone - validate mobile phone.
 * validatePassword - validate password.
 * validateLogin - validate login.
 * validateEmail - validate email.
 * @version 2.0
 * @autor Igor Kozlov
 */
public class ValidatorUser extends AbstractValidator {
    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectUserNameException if user's name is incorrect.
     * @throws IncorrectPassportNumberException if passport number is incorrect
     * @throws IncorrectPasswordException if password is incorrect
     * @throws IncorrectLoginException if login is incorrect
     * @throws IncorrectMobilePhoneException if mobile phone is incorrect
     * @throws IncorrectUserSurnameException if user' surname is incorrect
     * @throws IncorrectUserEmailException if user's email is incorrect
     */
    public boolean validate(Map<String, String[]> data) throws IncorrectUserNameException, IncorrectPassportNumberException, IncorrectPasswordException, IncorrectLoginException, IncorrectMobilePhoneException, IncorrectUserSurnameException,IncorrectUserEmailException {
        if (validatePassportNumber(data.get("passportNumber")[0])
                & validateUserName(data.get("name")[0])
                & validateUserSurName(data.get("surname")[0])
                & validateMobilePhone(data.get("mobilePhone")[0])
                & validatePassword(data.get("password")[0])
                & validateLogin(data.get("login")[0])
                & validateEmail(data.get("email")[0])) {
            return true;
        }
        return false;
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectPassportNumberException if user's name is incorrect.
     */
    private boolean validatePassportNumber(String passportNumber) throws IncorrectPassportNumberException {
        if (passportNumber.length() < 15 & passportNumber.length() > 5) {
            return true;
        }
        throw new IncorrectPassportNumberException("Incorrect passport number!");
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectUserNameException if passport number is incorrect
     */
    private boolean validateUserName(String userName) throws IncorrectUserNameException {
        if (userName.length() > 3 & userName.length() < 45) {
            return true;
        }
        throw new IncorrectUserNameException("Incorrect user name!");
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectUserSurnameException if user' surname is incorrect
     */
    private boolean validateUserSurName(String userSurName) throws IncorrectUserSurnameException {
        if (userSurName.length() < 45 & userSurName.length() > 3) {
            return true;
        }
        throw new IncorrectUserSurnameException("Incorrect user surname!");
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectMobilePhoneException if mobile phone is incorrect
     */
    private boolean validateMobilePhone(String mobilePhone) throws IncorrectMobilePhoneException {
        if (mobilePhone.length() < 15 & mobilePhone.length() >= 7) {
            return true;
        }
        throw new IncorrectMobilePhoneException("Incorrect mobile phone!");
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectPasswordException if password is incorrect
     */
    private boolean validatePassword(String password) throws IncorrectPasswordException {
        if (password.length() >= 8){
            return true;
        }
        throw new IncorrectPasswordException("Incorrect password!");
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectLoginException if login is incorrect
     */
    private boolean validateLogin(String login) throws IncorrectLoginException {
        if (login.length() > 5 & login.length() < 50) {
            return true;
        }
        throw new IncorrectLoginException("Incorrect login!");
    }

    /**
     * Validate parameters.
     * @return boolean value.
     * @throws IncorrectUserEmailException if user's email is incorrect
     */
    private boolean validateEmail(String email) throws IncorrectUserEmailException {
        Pattern p = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");
        Matcher m = p.matcher(email);
        if (m.matches()){
            return true;
        }
        throw new IncorrectUserEmailException("Incorrect email!");
    }

}
