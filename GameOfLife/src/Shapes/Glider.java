package Shapes;

public class Glider implements Spawnable {

    int[][] alive = {
            {1, 0},
            {2, 1},
            {0, 2},
            {1, 2},
            {2, 2}
    };

    public Glider(boolean[][] grid, int x, int y) {
        spawn(grid, x, y, this.alive);
    }
}
