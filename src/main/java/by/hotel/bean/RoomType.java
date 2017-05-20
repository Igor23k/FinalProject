package by.hotel.bean;

import by.hotel.builder.RoomTypeBuilder;

/**
 * The class store objects with properties
 * <b> id </ b>, <b> roomsCount </ b>, <b> bedsCount </ b>,
 * <b> bathroomsCount </ b>, <b> size </ b>, <b> size </ b> and <b> additionalInfo </ b>.
 * @autor Igor Kozlov
 * @version 1.0
 */

public class RoomType {
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
     * Property - bathroomsCount
     */
    private int bathroomsCount;
    /**
     * Property - size
     */
    private int size;
    /**
     * Property - costPerDay
     */
    private float costPerDay;
    /**
     * Property - additionalInfo
     */
    private String additionalInfo;

    /**
     * Create new empty object
     */
    public RoomType() {
    }

    /** Create new object
     @param roomTypeBuilder - builder room type
     */
    public RoomType(RoomTypeBuilder roomTypeBuilder){
        this.id = roomTypeBuilder.getId();
        this.roomsCount = roomTypeBuilder.getRoomsCount();
        this.bedsCount = roomTypeBuilder.getBedsCount();
        this.costPerDay = roomTypeBuilder.getCostPerDay();
        this.additionalInfo = roomTypeBuilder.getAdditionalInfo();
        this.bathroomsCount = roomTypeBuilder.getBathroomsCount();
        this.size = roomTypeBuilder.getSize();
    }

    /**
     * Function for get value {@link RoomType#id}
     * @return value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Function for set value of id {@link RoomType#id}
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Function for get value {@link RoomType#roomsCount}
     * @return value of roomsCount
     */
    public int getRoomsCount() {
        return roomsCount;
    }

    /**
     * Function for set value of roomsCount {@link RoomType#roomsCount}
     */
    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    /**
     * Function for get value {@link RoomType#bedsCount}
     * @return value of bedsCount
     */
    public int getBedsCount() {
        return bedsCount;
    }

    /**
     * Function for set value of bedsCount {@link RoomType#bedsCount}
     */
    public void setBedsCount(int bedsCount) {
        this.bedsCount = bedsCount;
    }

    /**
     * Function for get value {@link RoomType#costPerDay}
     * @return value of costPerDay
     */
    public float getCostPerDay() {
        return costPerDay;
    }

    /**
     * Function for set value of costPerDay {@link RoomType#costPerDay}
     */
    public void setCostPerDay(float costPerDay) {
        this.costPerDay = costPerDay;
    }

    /**
     * Function for get value {@link RoomType#additionalInfo}
     * @return value of additionalInfo
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Function for set value of additionalInfo {@link RoomType#additionalInfo}
     */
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * Function for get value {@link RoomType#bathroomsCount}
     * @return value of bathroomsCount
     */
    public int getBathroomsCount() {
        return bathroomsCount;
    }

    /**
     * Function for set value of bathroomsCount {@link RoomType#bathroomsCount}
     */
    public void setBathroomsCount(int bathroomsCount) {
        this.bathroomsCount = bathroomsCount;
    }

    /**
     * Function for get value {@link RoomType#size}
     * @return value of size
     */
    public int getSize() {
        return size;
    }

    /**
     * Function for set value of size {@link RoomType#size}
     */
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomType roomType = (RoomType) o;
        if (roomsCount != roomType.roomsCount) return false;
        if (bedsCount != roomType.bedsCount) return false;
        if (bathroomsCount != roomType.bathroomsCount) return false;
        if (size != roomType.size) return false;
        if (Float.compare(roomType.costPerDay, costPerDay) != 0) return false;
        return additionalInfo.equals(roomType.additionalInfo);
    }

    @Override
    public int hashCode() {
        int result = roomsCount;
        result = 31 * result + bedsCount;
        result = 31 * result + bathroomsCount;
        result = 31 * result + size;
        result = 31 * result + (costPerDay != +0.0f ? Float.floatToIntBits(costPerDay) : 0);
        result = 31 * result + additionalInfo.hashCode();
        return result;
    }
}
