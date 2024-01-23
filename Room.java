import java.util.ArrayList;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P03 Dragon Treasure Adventure
// Course:   CS 300 Fall 2022
//
// Author:   Akshay Gona
// Email:    gona@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:  Varun Munagala, helped to debug and discuss logic for tester methods
// Online Sources:  javadocs for Room,Player,Dragon classes, and stackoverflow pages on try catch
//
///////////////////////////////////////////////////////////////////////////////

/**
 * The Room class contains constructors for the Room object and getter and setter methods for
 * specific member variables. In addition, it also contains a few private final strings which are
 * used in conjunction with the Player and Dragon Classes.
 */
public class Room {
    private static final String PORTAL_WARNING = "You feel a distortion in space nearby.\n";
    private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";
    private static int teleportLocationID; //place where all portal rooms will go to
    private final String roomDescription; //a brief description of the room
    private final ArrayList<Room> adjRooms; //arraylist that holds the rooms adjacent
    private final int ID; //unique ID for each room to identify it
    private RoomType type; //one of the four types a room could be

    /**
     * This method is the constructor for the Room Object. Takes in an integer as an ID,
     * and a description,and creates a Room Object. In addition, it also creates an empty arraylist
     * of adjacent rooms and sets the type of the room to the default, which is NORMAL.
     *
     * @param id
     * @param roomDescription
     */
    public Room(int id, String roomDescription) {
        this.ID = id;
        this.roomDescription = roomDescription;
        adjRooms = new ArrayList<Room>();
        this.type = RoomType.NORMAL;
    }

    /**
     * This method is the setter method for TeleportIDs, and it assigns a room a teleportID.
     *
     * @param teleportID
     */
    public static void assignTeleportLocation(int teleportID) {
        teleportLocationID = teleportID;
    }

    /**
     * THis method returns a Portal Warning, a message that should be returned if a portal is
     * nearby.
     *
     * @return
     */
    public static String getPortalWarning() {
        return PORTAL_WARNING;
    }

    /**
     * This method returns the teleport location ID of a given room.
     *
     * @return
     */
    public static int getTeleportationRoom() {
        return teleportLocationID;
    }

    /**
     * This method returns a Treasure warning, a message which should be returned when treasure is
     * nearby.
     *
     * @return
     */
    public static String getTreasureWarning() {
        return TREASURE_WARNING;
    }

    /**
     * Determines if the given object is equal to this room.
     * They are equal if other is a Room and their IDs are the same.
     *
     * @param other, another object to check if it is equal to this
     * @return true if the two rooms are equal, false otherwise
     * @author Michelle
     */
    @Override public boolean equals(Object other) {
        if (other instanceof Room) {
            Room otherRoom = (Room) other;
            return this.ID == otherRoom.ID;
        }
        return false;
    }

    /**
     * Returns a String representation of this room.
     *
     * @return the string representation of this room and
     * its object data field values
     * @author Michelle
     */
    @Override public String toString() {
        String s = this.ID + ": " + this.roomDescription + " (" + type + ")\n Adjacent Rooms: ";
        for (int i = 0; i < adjRooms.size(); i++) {
            s += adjRooms.get(i).ID + " ";
        }
        return s;
    }

    /**
     * This method adds a new room to an already existing arraylist of adjacent rooms.
     *
     * @param toAdd
     */
    public void addToAdjacentRooms(Room toAdd) {
        getAdjacentRooms().add(toAdd);
    }

    /**
     * This method returns the arraylist of adjacent rooms to a room.
     *
     * @return
     */
    public ArrayList<Room> getAdjacentRooms() {
        return adjRooms;
    }

    /**
     * This method returns the ID of a given room.
     *
     * @return
     */
    public int getID() {
        return this.ID;
    }

    /**
     * This method returns the room description of a given room.
     *
     * @return
     */
    public String getRoomDescription() {
        return roomDescription;
    }

    /**
     * This method returns the type of a given room.
     *
     * @return
     */
    public RoomType getType() {
        return type;
    }

    /**
     * This method checks if a given room is adjacent to another room.
     *
     * @param r
     * @return
     */
    public boolean isAdjacent(Room r) {
        for (int i = 0; i < adjRooms.size(); i++) {
            if (r.equals(adjRooms.get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method sets the type for a given room to one of the four enumerators(types).
     *
     * @param newType
     */
    public void setRoomType(RoomType newType) {
        this.type = newType;
    }
}
