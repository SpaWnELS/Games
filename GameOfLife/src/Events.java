import java.awt.event.*;

public class Events implements ActionListener, MouseListener, MouseMotionListener {

    Panel panel;

    public Events(Panel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Game.timer.stop();
        changeState(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Game.timer.start();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        changeState(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    private void changeState(MouseEvent e) {

        if (0 <= e.getX() && e.getX() < Game.W && 0 <= e.getY() && e.getY() < Game.H) {
            int x = (e.getX() - Game.xOffset) / Game.blockW;
            int y = (e.getY() - Game.yOffset) / Game.blockW;

            if (0 <= x && x < Game.grid.length && 0 <= y && y < Game.grid[0].length) {
                if (!Game.grid[x][y]) Game.grid[x][y] = true;
            }

            this.panel.repaint();
        }
    }
}
