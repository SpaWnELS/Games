package Shapes;

public abstract class Shape {
    public abstract void spawn(boolean[][] grid, int x, int y);

    public Shape(boolean[][] grid, int x, int y) {
        spawn(grid, x, y);
    }
}
