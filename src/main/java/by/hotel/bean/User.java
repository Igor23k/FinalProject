package by.hotel.bean;

import by.hotel.builder.UserBuilder;
/**
 * User.java
 * The class store objects with properties
 * @author Igor Kozlov
 * @version 1.0
 */

public class User {
    /**
     * Property - id
     */
    private int id;
    /**
     * Property - name
     */
    private String name;
    /**
     * Property - surname
     */
    private String surname;
    /**
     * Property - email
     */
    private String email;
    /**
     * Property - mobilePhone
     */
    private String mobilePhone;
    /**
     * Property - login
     */
    private String login;
    /**
     * Property - passportNumber
     */
    private String passportNumber;
    /**
     * Property - password
     */
    private String password;
    /**
     * Property - role
     */
    private Role role;

    /**
     * Property - banned
     */
    private Integer banned;

    /**
     * Create new empty object
     */
    public User(){super();}

    /** Create new object
     @param userBuilder - builder user
     */
    public User(UserBuilder userBuilder){
        this.id = userBuilder.getId();
        this.name = userBuilder.getName();
        this.surname = userBuilder.getSurname();
        this.mobilePhone = userBuilder.getMobilePhone();
        this.login = userBuilder.getLogin();
        this.passportNumber = userBuilder.getPassportNumber();
        this.password = userBuilder.getPassword();
        this.role = userBuilder.getRole();
        this.email = userBuilder.getEmail();
        this.banned = userBuilder.getBanned();
    }

    /**
     * Function for get value {@link User#id}
     * @return value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Function for set value of id {@link User#id}
     * @param id - the id to be set.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Function for get value {@link User#banned}
     * @return value of id
     */
    public Integer getBanned() {
        return banned;
    }

    /**
     * Function for set value of banned {@link User#banned}
     * @param banned - the banned to be set.
     */
    public void setBanned(Integer banned) {
        this.banned = banned;
    }

    /**
     * Function for get value {@link User#passportNumber}
     * @return value of passportNumber
     */
    public String getPassportNumber() {
        return passportNumber;
    }

    /**
     * Function for set value of passportNumber {@link User#passportNumber}
     * @param passportNumber - the passportNumber to be set.
     */
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    /**
     * Function for get value {@link User#name}
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Function for get value {@link User#login}
     * @return value of login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Function for set value of login {@link User#login}
     * @param login - the login to be set.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Function for set value of name {@link User#name}
     * @param name - the name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Function for get value {@link User#surname}
     * @return value of surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Function for get value {@link User#surname}
     * @param surname - the surname to be set.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Function for get value {@link User#mobilePhone}
     * @return value of mobilePhone
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Function for set value of mobilePhone {@link User#mobilePhone}
     * @param mobilePhone - the mobilePhone to be set.
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * Function for get value {@link User#password}
     * @return value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Function for set value of password {@link User#password}
     * @param password - the password to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Function for get value {@link User#role}
     * @return value of role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Function for set value of role {@link User#role}
     * @param role - the role to be set.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Function for get value {@link User#email}
     * @return value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Function for set value of email {@link User#email}
     * @param email - the email to be set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserFullname(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(surname);
        stringBuilder.append(" ");
        stringBuilder.append(name);
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (!name.equals(user.name)) return false;
        if (!surname.equals(user.surname)) return false;
        if (!mobilePhone.equals(user.mobilePhone)) return false;
        if (!login.equals(user.login)) return false;
        if (!passportNumber.equals(user.passportNumber)) return false;
        if (!password.equals(user.password)) return false;
        return role.equals(user.role);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + mobilePhone.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + passportNumber.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
