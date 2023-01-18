import javax.swing.JFrame;

public class Frame extends JFrame {

    public Frame() {
        setSize(Game.W, Game.H);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
