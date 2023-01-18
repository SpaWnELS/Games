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
                g.drawLine(x * Game.blockW, 0, x * Game.blockW, Game.H);
            }
            for (int y=0; y<=Game.grid[0].length; y++) {
                g.drawLine(0, y * Game.blockW, Game.W, y * Game.blockW);
            }
        }

        // Fill Game.grid
        for (int x=0; x<Game.grid.length; x++) {
            for (int y=0; y<Game.grid[0].length; y++) {
                if (Game.grid[x][y]) g.fillRect(x*Game.blockW, y*Game.blockW,
                        Game.blockW, Game.blockW);
            }
        }
    }
}
