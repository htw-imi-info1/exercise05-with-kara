import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MasterKara here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CopyKara extends Kara
{
    /**
     *
     *
     */

    public void act() 
    {

        ArrayList<Boolean> leafRow = checkLeft();
        layRight(leafRow);
        if (treeFront()){
            Greenfoot.stop();
            return;
        }
        move();

        // walk to the left and store in the leafRow variable wether you found a leaf or not
        // walk back to middle
        // walk to the right and use leafRow to decide wether to put a leaf or not

    }

    public  ArrayList<Boolean> checkLeft(){
        turnLeft();
        ArrayList<Boolean> leafRow = new ArrayList<Boolean>();
        while(!treeFront()){
            move();
            leafRow.add(onLeaf());
            /* ersetzt: 
            if(onLeaf())
                leafRow.add(true);
            else
                leafRow.add(false);
                */
                
        }
        walkBack(leafRow.size());

        turnLeft();
        return leafRow;
    }

    public void layRight( ArrayList<Boolean> leafRow){
        turnRight();
        for(Boolean leafHere : leafRow){
            move();
            if(leafHere)
                putLeaf();
        }
        walkBack(leafRow.size());
        turnRight();

    }

    public void walkBack(int length){
        turnLeft();turnLeft();
        move(length);}
}