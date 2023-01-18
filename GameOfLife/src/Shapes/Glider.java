package Shapes;

public class Glider extends Shape {

    public Glider(boolean[][] grid, int x, int y) {
        super(grid, x, y);
    }

    public void spawn(boolean[][] grid, int x, int y) {
        int[][] alive = {
                {x, y},
                {x + 1, y},
                {x + 2, y + 1},
                {x, y + 2},
                {x + 1, y + 2},
                {x + 2, y + 2}
        };

        for (int[] cell : alive) {
            cell[0] = (cell[0] + grid.length) % grid.length;
            cell[1] = (cell[1] + grid[0].length) % grid[0].length;

            grid[cell[0]][cell[1]] = true;
        }
    }
}
