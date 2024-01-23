import java.util.ArrayList;
import java.util.Random;

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
 * The Dragon class contains a constructor for the Dragon object, a method that returns
 * the current location of the dragon, updates the location of the dragon, and returns a String
 * that warns players of dragons that are close by.
 */
public class Dragon {
    private Room currentRoom; //current location of the dragon
    private Random randGen; //random num generator used for moving
    private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";

    /**
     * This method is the constructor for the dragon object. It takes the currentRoom parameter
     * as the current location of the dragon, and declares a random integer for use in other
     * methods.
     *
     * @param currentRoom
     */
    Dragon(Room currentRoom){
        this.currentRoom = currentRoom;
        randGen = new Random();
    }

    /**
     * This method is the setter method for the location of the dragon. The dragon cannot move to
     * portal rooms, and moves randomly to rooms that are not portal rooms. The method takes this
     * into account and moves the dragon accordingly.
     *
     */
    public void changeRooms(){
        int i = randGen.nextInt(currentRoom.getAdjacentRooms().size());
        while(currentRoom.getAdjacentRooms().get(i).getType() == RoomType.PORTAL){
            i = randGen.nextInt(currentRoom.getAdjacentRooms().size());
        }
        currentRoom = currentRoom.getAdjacentRooms().get(i);
    }

    /**
     * This method returns the current room which the dragon is in.
     *
     * @return
     */
    public Room getCurrentRoom(){
        return currentRoom;
    }

    /**
     * This method returns a warning message which tells users that a dragon is nearby.
     *
     * @return
     */
    public static String getDragonWarning(){
        return DRAGON_WARNING;
    }
}
