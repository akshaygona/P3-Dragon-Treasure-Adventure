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
 * The DragonTreasureTester class contains a series of tester methods which test the functionality
 * of the methods written within the Room, Player, and Dragon classes. This is accomplished with
 * a series of methods specific to each of the above classes, and a main method which contains a
 * conditional that determines which method is faulty.
 *
 */
public class DragonTreasureTester {
    /**
     * This method tests all instance methods that are written within the Room class with a series
     * of conditional statements that compare predicted method outputs with actual method outputs.
     *
     * @return
     */
    public static boolean testRoomInstanceMethods() {
        try {
            ArrayList<Room> roomsList = new ArrayList<Room>();
            Room r = new Room(11, "lecture hall");
            Room d = new Room(1, "bathroom");
            roomsList.add(d);
            r.addToAdjacentRooms(d);
            if (!r.getAdjacentRooms().equals(roomsList)) {
                System.out.println("testAdjRooms or AddToAdjacentRooms failed");
                return false;
            }
            if (r.getID() != 11) {
                System.out.println("testGetID failed");
                return false;
            }
            if (!r.getRoomDescription().equals("lecture hall")) {
                System.out.println("testGetRoomDescription failed");
                return false;
            }
            if (r.getType() != RoomType.NORMAL) {
                System.out.println("testGetType failed");
                return false;
            }
            if (!r.isAdjacent(d)) {
                System.out.println("testIsAdjacent failed");
                return false;
            }
            r.setRoomType(RoomType.PORTAL);
            if (r.getType() != RoomType.PORTAL) {
                System.out.println("testSetRoomType failed");
                return false;
            }
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * This method tests all static methods that are written within the Room class with a series
     * of conditional statements that compare predicted method outputs with actual method outputs.
     *
     * @return
     */
    public static boolean testRoomStaticMethods() {
        Room.assignTeleportLocation(1);
        if (Room.getTeleportationRoom() != 1) {
            System.out.println("testAssignTeleportLocation failed");
            return false;
        }
        if (Room.getPortalWarning() != "You feel a distortion in space nearby.\n") {
            System.out.println("testGetPortalWarning failed");
            return false;
        }
        if (Room.getTreasureWarning() != "You sense that there is treasure nearby.\n") {
            System.out.println("testGetTreasureWarning failed");
            return false;
        }
        return true;
    }

    /**
     * This method tests the canMoveTo method within the Player class by testing the functionality
     * of the method written in the Player class.
     *
     * @return
     */
    public static boolean testPlayerCanMoveTo() {
        Room r = new Room(1, "laboratory");
        Player p = new Player(r);
        Room d = new Room(2,"lounge");
        r.addToAdjacentRooms(d);
        if(!p.canMoveTo(d)){
            System.out.println("testPlayerCanMoveTo failed");
            return false;
        }
        return true;
    }

    /**
     * This method tests the shouldTeleport method within the Player class by testing the
     * functionality of the method written in the Player class.
     *
     * @return
     */
    public static boolean testPlayerShouldTeleport() {
        Room r = new Room(1, "laboratory");
        Player p = new Player(r);
        r.setRoomType(RoomType.PORTAL);
        if(!p.shouldTeleport()){
            System.out.println("testPlayerShouldTeleport failed");
            return false;
        }
        return true;
    }

    /**
     * This method tests the functionality of the isPortalNearby and isTreasureNearby methods
     * written in the Player class.
     *
     * @return
     */
    public static boolean testPlayerDetectNearbyRooms() {
        Room c = new Room(6, "rando");
        Room r = new Room(1, "laboratory");
        Room d = new Room(2, "gold mine");
        r.setRoomType(RoomType.PORTAL);
        d.setRoomType(RoomType.TREASURE);
        Player p = new Player(c);
        c.addToAdjacentRooms(r);
        c.addToAdjacentRooms(d);
        if(!p.isPortalNearby()){
            System.out.println("testIsPortalNearby failed");
            return  false;
        }
        if(!p.isTreasureNearby()){
            System.out.println("testIsTreasureNearby failed");
            return false;
        }
        return true;
    }

    /**
     * This method tests the functionality of the changeRooms method in the Dragon class.
     *
     * @return
     */
    public static boolean testDragonChangeRooms() {
        Room c = new Room(6, "rando");
        Room r = new Room(1, "laboratory");
        Room d = new Room(2, "gold mine");
        Dragon varun = new Dragon(c);
        c.addToAdjacentRooms(r);
        c.addToAdjacentRooms(d);
        r.setRoomType(RoomType.PORTAL);
        varun.changeRooms();
        if(varun.getCurrentRoom() != d){
            System.out.println("testDragonChangeRooms failed");
            return false;
        }
        return true;
    }

    /**
     * The main method runs all the tester methods above through a conditional statement which
     * exits when any test trips, or doesn't work as expected.
     *
     * @param args
     */
    public static void main(String[] args) {
        if (testRoomInstanceMethods() != true || testRoomStaticMethods() != true
            || testPlayerCanMoveTo() != true || testPlayerShouldTeleport() != true
            || testPlayerDetectNearbyRooms() != true || testDragonChangeRooms() != true) {
            System.out.println("One ore more of the methods have failed");
        }
        System.out.println("all good, everything works as expected");
    }
}
