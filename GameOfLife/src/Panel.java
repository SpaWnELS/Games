import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    
    public Panel() {
        setSize(Game.W, Game.H);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Game.backgroundColour);
        drawGrid(g);
    }

    /**
     * Draws the grid on the screen.
     * Fills the grid if @param Game.Game.gridVisible is true.
     * @param g Graphics object
     */
    private void drawGrid(Graphics g) {
        g.setColor(Game.gridColour);

        // Draw Game.grid
        if (Game.gridVisible) {
            for (int x=0; x<=Game.grid.length; x++) {
                g.drawLine(Game.xOffset + x * Game.blockW, Game.yOffset,
                        x * Game.blockW + Game.xOffset, Game.H - Game.yOffset);
            }
            for (int y=0; y<=Game.grid[0].length; y++) {
                g.drawLine(Game.xOffset, Game.yOffset + y * Game.blockW,
                        Game.W - Game.xOffset, y * Game.blockW + Game.yOffset);
            }
        }

        // Fill Game.grid
        for (int x=0; x<Game.grid.length; x++) {
            for (int y=0; y<Game.grid[0].length; y++) {
                if (Game.grid[x][y]) {
                    g.fillRect(x * Game.blockW + Game.xOffset, y * Game.blockW + Game.yOffset,
                            Game.blockW, Game.blockW);
                }
            }
        }
    }
}
