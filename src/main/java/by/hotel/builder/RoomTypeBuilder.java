package by.hotel.builder;

import by.hotel.bean.RoomType;

/**
 * RoomTypeBuilder.java
 * The class store objects with properties and methods.
 * This class is a template Builder.
 * @author Igor Kozlov
 * @version 1.0
 */
public class RoomTypeBuilder {
    /**
     * Property - id
     */
    private int id;

    /**
     * Property - roomsCount
     */
    private int roomsCount;

    /**
     * Property - bedsCount
     */
    private int bedsCount;

    /**
     * Property - costPerDay
     */
    private float costPerDay;

    /**
     * Property - additionalInfo
     */
    private String additionalInfo;

    /**
     * Property - path
     */
    private String path;

    /**
     * Property - bathroomsCount
     */
    private int bathroomsCount;

    /**
     * Property - size
     */
    private int size;

    public RoomTypeBuilder id(int id){
        this.id = id;
        return this;
    }

    /**  Function for set value {@link RoomTypeBuilder#roomsCount}
     *@param roomsCount - the roomsCount to be set.
     *@return object of class RoomTypeBuilder
     */
    public RoomTypeBuilder roomsCount(int roomsCount){
        this.roomsCount = roomsCount;
        return this;
    }

    /**  Function for set value {@link RoomTypeBuilder#bedsCount}
     *@param bedsCount - the bedsCount to be set.
     *@return object of class RoomTypeBuilder
     */
    public RoomTypeBuilder bedsCount(int bedsCount){
        this.bedsCount = bedsCount;
        return this;
    }

    /**  Function for set value {@link RoomTypeBuilder#costPerDay}
     *@param costPerDay - the costPerDay to be set.
     *@return object of class RoomTypeBuilder
     */
    public RoomTypeBuilder costPerDay(float costPerDay){
        this.costPerDay = costPerDay;
        return this;
    }

    /**  Function for set value {@link RoomTypeBuilder#additionalInfo}
     *@param additionalInfo - the additionalInfo to be set.
     *@return object of class RoomTypeBuilder
     */
    public RoomTypeBuilder additionalInfo(String additionalInfo){
        this.additionalInfo = additionalInfo;
        return this;
    }

    /**  Function for set value {@link RoomTypeBuilder#bathroomsCount}
     *@param bathroomsCount - the bathroomsCount to be set.
     *@return object of class RoomTypeBuilder
     */
    public RoomTypeBuilder bathroomsCount(int bathroomsCount){
        this.bathroomsCount = bathroomsCount;
        return this;
    }

    /**  Function for set value {@link RoomTypeBuilder#path}
     *@param path - the path to be set.
     *@return object of class RoomTypeBuilder
     */
    public RoomTypeBuilder path(String path){
        this.path = path;
        return this;
    }

    /**  Function for set value {@link RoomTypeBuilder#size}
     *@param size - the size to be set.
     *@return object of class RoomTypeBuilder
     */
    public RoomTypeBuilder size(int size){
        this.size = size;
        return this;
    }

    /**
     * Function for get value {@link RoomTypeBuilder#id}
     * @return value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Function for get value {@link RoomTypeBuilder#roomsCount}
     * @return value of roomsCount
     */
    public int getRoomsCount() {
        return roomsCount;
    }

    /**
     * Function for get value {@link RoomTypeBuilder#bedsCount}
     * @return value of bedsCount
     */
    public int getBedsCount() {
        return bedsCount;
    }

    /**
     * Function for get value {@link RoomTypeBuilder#costPerDay}
     * @return value of costPerDay
     */
    public float getCostPerDay() {
        return costPerDay;
    }

    /**
     * Function for get value {@link RoomTypeBuilder#additionalInfo}
     * @return value of additionalInfo
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Function for get value {@link RoomTypeBuilder#bathroomsCount}
     * @return value of bathroomsCount
     */
    public int getBathroomsCount() {
        return bathroomsCount;
    }

    /**
     * Function for get value {@link RoomTypeBuilder#size}
     * @return value of size
     */
    public int getSize() {
        return size;
    }

    /**  Function for build room type
     *@return object of class RoomType
     */
    public RoomType build(){
        return new RoomType(this);
    }
}
