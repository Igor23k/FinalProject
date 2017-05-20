package by.hotel.bean;

import by.hotel.builder.ParkingSpaceBuilder;

/**
 * The class store objects with properties
 * <b> id </ b>, <b> level </ b> and <b> reserved </ b>.
 * @autor Igor Kozlov
 * @version 1.0
 */
public class ParkingSpace {
    /**
     * Property - id
     */
    private int id;
    /**
     * Property - level
     */
    private int level;
    /**
     * Property - reserved
     */
    private byte reserved;
    /**
     * Create new empty object
     */
    public ParkingSpace(){
    }
    /** Create new object
     @param parkingSpaceBuilder - builder parking space
     */
    public ParkingSpace(ParkingSpaceBuilder parkingSpaceBuilder){
        this.id = parkingSpaceBuilder.getId();
        this.level = parkingSpaceBuilder.getLevel();
        this.reserved = parkingSpaceBuilder.getReserved();
    }

    /**
     * Function for get value {@link ParkingSpace#id}
     * @return value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Function for set value of id {@link ParkingSpace#id}
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Function for get value {@link ParkingSpace#level}
     * @return value of level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Function for set value of level {@link ParkingSpace#level}
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Function for get value {@link ParkingSpace#reserved}
     * @return value of reserved
     */
    public byte getReserved() {
        return reserved;
    }

    /**
     * Function for set value of reserved {@link ParkingSpace#reserved}
     */
    public void setReserved(byte reserved) {
        reserved = reserved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpace that = (ParkingSpace) o;
        if (level != that.level) return false;
        return reserved == that.reserved;
    }

    @Override
    public int hashCode() {
        int result = level;
        result = 31 * result + (int) reserved;
        return result;
    }
}
