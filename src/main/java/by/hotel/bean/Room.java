package by.hotel.bean;

/**
 * Room.java
 * The class store objects with properties
 * <b> id </ b>, <b> floor </ b>, <b> path </ b>,
 * <b> phone </ b>, <b> name </ b> and <b> roomType </ b>.
 * @autor Igor Kozlov
 * @version 1.0
 */
import by.hotel.builder.RoomBuilder;

public class Room {
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

    /**
     * Create new empty object
     */
    public Room(){}

    /** Create new object
     @param roomBuilder - builder room
     */
    public Room(RoomBuilder roomBuilder){
        this.id = roomBuilder.getId();
        this.path = roomBuilder.getPath();
        this.name = roomBuilder.getName();
        this.floor = roomBuilder.getFloor();
        this.phone = roomBuilder.getPhone();
        this.roomType = roomBuilder.getRoomType();
    }

    /**
     * Function for get value {@link Room#id}
     * @return value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Function for set value of id {@link Room#id}
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Function for get value {@link Room#roomType}
     * @return value of roomType
     */
    public RoomType getRoomType() {
        return roomType;
    }

    /**
     * Function for set value of roomType {@link Room#roomType}
     */
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    /**
     * Function for get value {@link Room#floor}
     * @return value of floor
     */
    public int getFloor() {
        return floor;
    }

    /**
     * Function for set value of floor {@link Room#floor}
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

    /**
     * Function for get value {@link Room#phone}
     * @return value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Function for set value of phone {@link Room#phone}
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Function for get value {@link Room#name}
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Function for set value of name {@link Room#name}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Function for get value {@link Room#path}
     * @return value of path
     */
    public String getPath() {
        return path;
    }

    /**
     * Function for set value of path {@link Room#path}
     */
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        if (floor != room.floor) return false;
        if (!phone.equals(room.phone)) return false;
        if (!name.equals(room.name)) return false;
        return roomType != null ? roomType.equals(room.roomType) : room.roomType == null;
    }

    @Override
    public int hashCode() {
        int result = floor;
        result = 31 * result + phone.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (roomType != null ? roomType.hashCode() : 0);
        return result;
    }
}
