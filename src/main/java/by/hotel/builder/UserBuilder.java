package by.hotel.builder;

import by.hotel.bean.Role;
import by.hotel.bean.User;

/**
 * UserBuilder.java
 * The class store objects with properties and methods.
 * This class is a template Builder.
 * @author Igor Kozlov
 * @version 1.0
 */
public class UserBuilder {
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

    /**  Function for set value {@link UserBuilder#id}
     *@param id - the id to be set.
     *@return object of class UserBuilder
     */
    public UserBuilder id(int id){
        this.id = id;
        return this;
    }

    /**  Function for set value {@link UserBuilder#name}
     *@param name - the name to be set.
     *@return object of class UserBuilder
     */
    public UserBuilder name(String name){
        this.name = name;
        return this;
    }

    /**  Function for set value {@link UserBuilder#surname}
     *@param surname - the surname to be set.
     *@return object of class UserBuilder
     */
    public UserBuilder surname(String surname){
        this.surname = surname;
        return this;
    }

    /**  Function for set value {@link UserBuilder#mobilePhone}
     *@param mobilePhone - the mobilePhone to be set.
     *@return object of class UserBuilder
     */
    public UserBuilder mobilePhone(String mobilePhone){
        this.mobilePhone = mobilePhone;
        return this;
    }

    /**  Function for set value {@link UserBuilder#login}
     *@param login - the login to be set.
     *@return object of class UserBuilder
     */
    public UserBuilder login(String login){
        this.login = login;
        return this;
    }

    /**  Function for set value {@link UserBuilder#passportNumber}
     *@param passportNumber - the passportNumber to be set.
     *@return object of class UserBuilder
     */
    public UserBuilder passportNumber(String passportNumber){
        this.passportNumber = passportNumber;
        return this;
    }

    /**  Function for set value {@link UserBuilder#email}
     *@param email - the email to be set.
     *@return object of class UserBuilder
     */
    public UserBuilder email(String email){
        this.email = email;
        return this;
    }

    /**  Function for set value {@link UserBuilder#password}
     *@param password - the password to be set.
     *@return object of class UserBuilder
     */
    public UserBuilder password(String password){
        this.password = password;
        return this;
    }

    /**  Function for set value {@link UserBuilder#role}
     *@param role - the role to be set.
     *@return object of class UserBuilder
     */
    public UserBuilder role(Role role){
        this.role = role;
        return this;
    }

    /**  Function for set value {@link UserBuilder#banned}
     *@param banned - the role to be set.
     *@return object of class UserBuilder
     */
    public UserBuilder banned(Integer banned){
        this.banned = banned;
        return this;
    }

    /**
     * Function for get value {@link UserBuilder#banned}
     * @return value of banned
     */
    public Integer getBanned() {
        return banned;
    }

    /**
     * Function for get value {@link UserBuilder#id}
     * @return value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Function for get value {@link UserBuilder#name}
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Function for get value {@link UserBuilder#surname}
     * @return value of surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Function for get value {@link UserBuilder#email}
     * @return value of email
     */
    public String getEmail() {return email;}

    /**
     * Function for get value {@link UserBuilder#mobilePhone}
     * @return value of mobilePhone
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Function for get value {@link UserBuilder#login}
     * @return value of login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Function for get value {@link UserBuilder#passportNumber}
     * @return value of passportNumber
     */
    public String getPassportNumber() {
        return passportNumber;
    }

    /**
     * Function for get value {@link UserBuilder#password}
     * @return value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Function for get value {@link UserBuilder#role}
     * @return value of role
     */
    public Role getRole() {
        return role;
    }

    /**  Function for build user
     *@return object of class User
     */
    public User build(){
        return new User(this);
    }
}
