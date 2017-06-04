package by.hotel.builder;

import by.hotel.bean.Room;
import by.hotel.bean.RoomType;

/**
 * RoomBuilder.java
 * The class store objects with properties and methods.
 * This class is a template Builder.
 * @author Igor Kozlov
 * @version 1.0
 */
public class RoomBuilder {
    /**
     * Property - id
     */
    private int id;
    /**
     * Property - floor
     */
    private int floor;
    /**
     * Property - path
     */
    private String path;
    /**
     * Property - phone
     */
    private String phone;
    /**
     * Property - name
     */
    private String name;
    /**
     * Property - roomType
     */
    private RoomType roomType;

    /**  Function for set value {@link RoomBuilder#id}
     *@param id - the id to be set.
     *@return object of class RoomBuilder
     */
    public RoomBuilder id(int id) {
        this.id = id;
        return this;
    }

    /**  Function for set value {@link RoomBuilder#floor}
     *@param floor - the floor to be set.
     *@return object of class RoomBuilder
     */
    public RoomBuilder floor(int floor) {
        this.floor = floor;
        return this;
    }

    /**  Function for set value {@link RoomBuilder#phone}
     *@param phone - the phone to be set.
     *@return object of class RoomBuilder
     */
    public RoomBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    /**  Function for set value {@link RoomBuilder#path}
     *@param path - the path to be set.
     *@return object of class RoomBuilder
     */
    public RoomBuilder path(String path) {
        this.path = path;
        return this;
    }

    /**  Function for set value {@link RoomBuilder#roomType}
     *@param roomType - the roomType to be set.
     *@return object of class RoomBuilder
     */
    public RoomBuilder roomType(RoomType roomType) {
        this.roomType = roomType;
        return this;
    }

    /**  Function for set value {@link RoomBuilder#name}
     *@param name - the name to be set.
     *@return object of class RoomBuilder
     */
    public RoomBuilder name(String name){
        this.name = name;
        return this;
    }

    /**
     * Function for get value {@link RoomBuilder#id}
     * @return value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Function for get value {@link RoomBuilder#floor}
     * @return value of floor
     */
    public int getFloor() {
        return floor;
    }

    /**
     * Function for get value {@link Room#phone}
     * @return value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Function for get value {@link RoomBuilder#roomType}
     * @return value of roomType
     */
    public RoomType getRoomType() {
        return roomType;
    }

    /**
     * Function for get value {@link RoomBuilder#name}
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Function for get value {@link RoomBuilder#path}
     * @return value of path
     */
    public String getPath() {
        return path;
    }

    /**  Function for build room
     *@return object of class Room
     */
    public Room build() {
        return new Room(this);
    }
}
