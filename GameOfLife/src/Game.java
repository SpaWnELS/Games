import javax.swing.*;
import java.awt.*;

public class Game {

    // Panel and frame
    static Frame frame;
    static Panel panel;
    static Sidebar sidebar;

    // Window
    static int W = 1000;
    static int H = 800;
    static int blockW = 10; // pixel length of each block in the grid

    // Aesthetics
    static Color backgroundColour = Color.WHITE;
    static Color gridColour = Color.BLACK;
    static boolean gridVisible = true;


    // Events
    static Timer timer;
    boolean spawnAtBeginning = false;
    static boolean pause = false;
    static int fps = 5;

    // Game
    static boolean[][] grid = new boolean[W / blockW][H / blockW];

    /**
     * Called upon initialisation of the game.
     * Randomly sets some squares in grid to true.
     **/
    private void spawn() {
        if (spawnAtBeginning) {
            for (int x=0; x<grid.length; x++) {
                for (int y=0; y<grid[0].length; y++) {
                    grid[x][y] = Math.random() < 0.1;
                }
            }
            spawnAtBeginning = false;
        }
    }

    private void update() {

        if (!pause) {
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    if (willBeAlive(row, col)) grid[row][col] = true;
                    else grid[row][col] = false;
                }
            }
        }

        panel.repaint();
    }

    private boolean willBeAlive(int row, int col) {
        boolean alive = isAlive(row, col);
        int neighbours = countNeighbours(row, col);

        if (neighbours == 3) return true;
        if (neighbours == 2 && alive) return true;
        else return false;
    }
    
    private boolean isAlive(int row, int col) {
        row = (row + grid.length) % grid.length;
        col = (col + grid[0].length) % grid[0].length;

        return grid[row][col];
    }

    private int countNeighbours(int row, int col) {
        int neighbours = 0;
        for (int i=-1; i<2; i++) {
            for (int j=-1; j<2; j++) {
                if (isAlive(row+i, col+j)) neighbours++;
            }
        }
        if (isAlive(row, col)) neighbours--;

        return neighbours;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.spawn();

        frame = new Frame();
        panel = new Panel();
        sidebar = new Sidebar();
        frame.add(panel);
        panel.add(sidebar.button);
        panel.add(sidebar.slider);
        panel.add(sidebar.label);

        Events events = new Events(panel);
        panel.addMouseMotionListener(events);
        panel.addMouseListener(events);

        timer = new Timer(1000 / game.fps, e -> game.update());
        timer.start();
    }
}
