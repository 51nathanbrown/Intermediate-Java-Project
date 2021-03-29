// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
// nor will I accept the actions of those who do.
// -- Nathan Brown (bnathan)

package towerofhanoi;

import java.util.Observable;

import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

public class PuzzleWindow implements Observer {
    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;
    public final int DISK_GAP = 0;
    public final static int DISK_HEIGHT = 10;
    public final int POLE_HEIGHT = 100;
    public final int POLE_WIDTH = 5;
    public final int DISK_WIDTH_CHANGE = 10;
    public final int POLE_Y = 100;
    public final int POLE_X = 200;
    public final int POLE_SPACE = 100;
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        this.game.addObserver(this);
        window = new Window("Tower of Hanoi");
        this.left = new Shape(POLE_X, POLE_Y, POLE_WIDTH, POLE_HEIGHT);
        this.middle = new Shape(POLE_X + POLE_SPACE, POLE_Y, POLE_WIDTH, POLE_HEIGHT);
        this.right = new Shape(POLE_X + POLE_SPACE * 2, POLE_Y, POLE_WIDTH, POLE_HEIGHT);
        for (int i = 0; i < this.game.disks(); i++) {
            this.game.getTower(Position.RIGHT).push(new Disk(DISK_WIDTH_CHANGE*(this.game.disks() + 1 - i) + this.POLE_WIDTH + 10));
            this.window.addShape(this.game.getTower(Position.RIGHT).peek());
            moveDisk(Position.RIGHT);
        }
        this.window.addShape(this.left);
        this.window.addShape(this.middle);
        this.window.addShape(this.right);
        Button solveButton = new Button("Solve");
        this.window.addButton(solveButton, WindowSide.SOUTH);
        solveButton.onClick(this, "clickedSolve");
    }
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }
    private void moveDisk(Position position) {
        Disk currentDisk = this.game.getTower(position).peek();
        Shape currentPole;
        switch(position) {
            case LEFT:
                currentPole = this.left;
                break;
            case RIGHT:
                currentPole = this.right;
                break;
            case MIDDLE:
                currentPole = this.middle;
                break;
            default:
                currentPole = this.middle;
                break;
        }
        int x = currentPole.getX();
        int y = currentPole.getY() + this.POLE_HEIGHT - (this.game.getTower(position).size() * (PuzzleWindow.DISK_HEIGHT + this.DISK_GAP));
        currentDisk.moveTo(x - (currentDisk.getWidth() - this.POLE_WIDTH) / 2, y - (this.DISK_GAP));
    }
    @Override
    public void update(Observable o, Object obj) {
        if (obj.getClass() == Position.class) {
            moveDisk((Position)obj);
        }
        sleep();
    }
}
