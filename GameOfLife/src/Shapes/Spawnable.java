package Shapes;

public interface Spawnable {

    default void spawn(boolean[][] grid, int x, int y, int[][] alive) {
        for (int[] cell : alive) {
            cell[0] = (x + cell[0] + grid.length) % grid.length;
            cell[1] = (y + cell[1] + grid[0].length) % grid[0].length;

            grid[cell[0]][cell[1]] = true;
        }
    }
}
