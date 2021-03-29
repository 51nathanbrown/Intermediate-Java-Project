// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
// nor will I accept the actions of those who do.
// -- Nathan Brown (bnathan)

package towerofhanoi;

import java.util.Observable;
/**
 * creates a HanoiSolver object
 * @author Nathan Brown (bnathan)
 * @version 2020.10.20
 */
public class HanoiSolver extends Observable {
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;
    /**
     * instantiates HanoiSolver object
     * @param diskCount number of disks per tower
     */
    public HanoiSolver(int diskCount) {
        this.numDisks = diskCount;
        this.left = new Tower(Position.LEFT);
        this.middle = new Tower(Position.MIDDLE);
        this.right = new Tower(Position.RIGHT);
    }
    /**
     * returns number of disks in problem
     * @return int number of disks
     */
    public int disks() {
        return this.numDisks;
    }
    /**
     * returns tower in certain position
     * @param pos position of tower
     * @return Tower to return
     */
    public Tower getTower(Position pos) {
        switch(pos) {
            case LEFT:
                return this.left;
            case RIGHT:
                return this.right;
            case MIDDLE:
                return this.middle;
            default:
                return this.middle;
        }
    }
    /**
     * returns string representation of towers and disks
     * @return String disk's width on each tower
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.left.toString());
        result.append(this.middle.toString());
        result.append(this.right.toString());
        return result.toString();
    }
    /**
     * moves disk from one tower to another
     * @param source tower to be moved from
     * @param destination tower to be moved to
     */
    private void move(Tower source, Tower destination) {
        Disk mover = source.pop();
        destination.push(mover);
        this.setChanged();
        this.notifyObservers(destination.position());
    }
    /**
     * recursive method that solves tower of hanoi problem
     * @param currentDisks number of disks on tower
     * @param startPole pole that starts with the disks
     * @param tempPole pole that neither starts with or ends with the disks
     * @param endPole pole that ends with the disks
     */
    private void solveTowers(int currentDisks, 
        Tower startPole, Tower tempPole, Tower endPole) {
        if (currentDisks == 1) {
            this.move(startPole, endPole);
        }
        else if (currentDisks > 1) {
            this.solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            this.solveTowers(1, startPole, tempPole, endPole);
            this.solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }
    /**
     * method that calls the recursive method and provides parameters 
     */
    public void solve() {
        this.solveTowers(this.numDisks, this.right, this.middle, this.left);
    }
}
