package Shapes;

public class Block implements Spawnable {

    int[][] alive = {
            {0, 0},
            {0, 1},
            {1, 0},
            {1, 1}
    };

    public Block(boolean[][] grid, int x, int y) {
        spawn(grid, x, y, this.alive);
    }
}
