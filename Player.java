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
 * The Player class contains a constructor for the player object, and contains methods which
 * are associated with the movement of the player. In addition, some methods act as setters and
 * getters for the location of the player, and the type of room the player is in. Other methods
 * return messages if certain types of rooms are nearby.
 */
public class Player {
    private Room currentRoom; //current location of the player

    /**
     * The Player constructor constructs a Player, by taking a room in as a parameter, and making
     * it the current room which the player is in.
     *
     * @param currentRoom
     */
    Player(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * This method determines if a player can move to a given room based on whether or not it is
     * in the list of adjacent rooms.
     *
     * @param destination
     * @return
     */
    public boolean canMoveTo(Room destination){
        return currentRoom.isAdjacent(destination);
    }

    /**
     * This method updates the current location of the player to the given room.
     *
     * @param newRoom
     */
    public void changeRoom(Room newRoom){
        currentRoom = newRoom;
    }

    /**
     * This method returns the arraylist of rooms that are adjacent to the player.
     *
     * @return
     */
    public ArrayList<Room> getAdjacentRoomsToPlayer(){
        return currentRoom.getAdjacentRooms();
    }

    /**
     * This method returns the location of the player by getting and returning the current room the
     * player is in.
     *
     * @return
     */
    public Room getCurrentRoom(){
        return currentRoom;
    }

    /**
     * This method determines whether a dragon is near the player by scanning the arraylist of
     * adjacent rooms for a dragon.
     *
     * @param d
     * @return
     */
    public boolean isDragonNearby(Dragon d){
        for(int i = 0; i < currentRoom.getAdjacentRooms().size(); i++){
            if(d.getCurrentRoom().equals(currentRoom.getAdjacentRooms().get(i))){
                return true;
            }
        }
        return false;
    }

    /**
     * This method determines whether a portal is nearby by scanning the types of rooms
     * that are within the arraylist of adjacent rooms to see if any of them are portal rooms.
     *
     * @return
     */
    public boolean isPortalNearby() {
        for (int i = 0; i < currentRoom.getAdjacentRooms().size(); i++) {
            if (currentRoom.getAdjacentRooms().get(i).getType() == RoomType.PORTAL) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method determines whether the treasure room is nearby by scanning the types of rooms
     * that are within the arraylist of adjacent rooms to see if any of them are treasure rooms.
     *
     * @return
     */
    public boolean isTreasureNearby(){
        for (int i = 0; i < currentRoom.getAdjacentRooms().size(); i++) {
            if (currentRoom.getAdjacentRooms().get(i).getType() == RoomType.TREASURE) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method determines if a player should teleport based on whether the player's
     * current room is a portal room or not.
     *
     * @return
     */
    public boolean shouldTeleport(){
        return currentRoom.getType() == RoomType.PORTAL;
    }
}
