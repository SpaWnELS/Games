package Shapes;

public class Blinker implements Spawnable {

    int[][] alive = {
            {1, 0},
            {1, 1},
            {1, 2}
    };

    public Blinker(boolean[][] grid, int x, int y) {
        spawn(grid, x, y, this.alive);
    }
}
