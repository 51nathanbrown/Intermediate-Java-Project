// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
// nor will I accept the actions of those who do.
// -- Nathan Brown (bnathan)

package towerofhanoi;

import cs2.Shape;
import java.awt.Color;
import java.util.Random;
/**
 * creates disk object
 * @author Nathan Brown (bnathan)
 * @version 2020.10.20
 *
 */
public class Disk extends Shape implements Comparable<Disk> {
    /**
     * instantiates disk object
     * @param width width of disk
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        Random gen = new Random();
        int color1 = gen.nextInt(256);
        int color2 = gen.nextInt(256);
        int color3 = gen.nextInt(256);
        Color background = new Color(color1, color2, color3);
        this.setBackgroundColor(background);
    }
    /**
     * compares widths of 2 disks
     * @param otherDisk disk to be compared
     * @return int difference between widths
     */
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        return this.getWidth() - otherDisk.getWidth();
    }
    /**
     * returns width as a string
     * @return String disk width
     */
    public String toString() {
        return Integer.toString(this.getWidth());
    }
    /**
     * determines if 2 objects are equal
     * @param obj object to be compared to
     * @return boolean true if equal, false if not
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        return (this.getWidth() == ((Shape)obj).getWidth());
    }
}
