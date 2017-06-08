package by.hotel.bean;

/**
 * Report.java
 * The class store objects with properties.
 * @author Igor Kozlov
 * @version 1.0
 */
public class RoomReport extends FinancialReport{
    /**
     * Property - room
     */
    private String roomName;

    /**
     * Function for get value {@link RoomReport#roomName}
     * @return value of roomName
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Function for set value of id {@link RoomReport#roomName}
     * @param roomName - the roomName to be set.
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
