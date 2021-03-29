// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
// nor will I accept the actions of those who do.
// -- Nathan Brown (bnathan)

package towerofhanoi;
/**
 * Creates Tower object
 * @author Nathan Brown (bnathan)
 * @version 2020.10.20
 */
public class Tower extends LinkedStack<Disk> {
    private Position position;
    /**
     * instantiates tower object
     * @param param position of tower
     */
    public Tower(Position param) {
        super();
        this.position = param;
    }
    /**
     * returns position of tower
     * @return Position
     */
    public Position position() {
        return this.position;
    }
    @Override public void push(Disk disk) {
        if (this.size() == 0 || this.peek().compareTo(disk) > 0) {
            super.push(disk);
        }
        else if (disk == null) {
            throw new IllegalArgumentException();
        }
        else {
            throw new IllegalStateException();
        }
    }
}
