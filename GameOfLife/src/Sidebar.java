import javax.swing.*;
import java.awt.*;

public class Sidebar {
    JButton button;
    int buttonX, buttonY, buttonW, buttonH;
    JSlider slider;
    int sliderX, sliderY, sliderW, sliderH;
    JLabel label;
    int labelX, labelY, labelW, labelH;

    public Sidebar() {
        Font font = new Font("Dialog", Font.PLAIN, Game.W / 70);
        // Pause button
        buttonW = Game.W / 10;
        buttonH = Game.H / 15;
        buttonX = Game.W - (int) Math.ceil(1.5 * buttonW);
        buttonY = Game.H / 3;

        button = new JButton("Pause");
        button.setFont(font);
        button.setBounds(buttonX, buttonY, buttonW, buttonH);
        button.setVisible(true);
        button.addActionListener(e -> {
            Game.pause = !Game.pause;
            if (Game.pause) button.setText("Resume");
            else button.setText("Pause");
        });

        // FPS slider
        sliderW = Game.W / 7;
        sliderH = Game.H / 10;
        sliderX = buttonX - (sliderW - buttonW) / 2;
        sliderY = buttonY + buttonH * 3;
        slider = new JSlider(JSlider.HORIZONTAL, 1, 30, Game.fps);
        slider.setBounds(sliderX, sliderY, sliderW, sliderH);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setVisible(true);
        slider.addChangeListener(e -> {
            Game.fps = slider.getValue();
            Game.timer.setDelay(1000 / Game.fps);
            label.setText("FPS: " + Game.fps);
        });

        // Slider label
        labelW = Game.W / 10;
        labelH = Game.H / 15;
        labelX = buttonX - (labelW - buttonW) / 2;
        labelY = sliderY - labelH;
        label = new JLabel("FPS: " + Game.fps, SwingConstants.CENTER);
        label.setBounds(labelX, labelY, labelW, labelH);
        label.setVisible(true);
        label.setFont(font);
        label.setOpaque(true);
        label.setBackground(Color.WHITE);

    }
}
