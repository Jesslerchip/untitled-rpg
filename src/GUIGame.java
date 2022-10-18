import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIGame extends JFrame implements ActionListener {

    // GUI Components
    private final CardLayout cardLayout = new CardLayout();
    private final JFrame gameFrame;
    private final JPanel containerPanel;
    private final JPanel titleScreenPanel;
    private final JPanel mapPanel;
    private final JButton mapTitleButton;
    private final JButton titleNewGameButton;

    // Constructor for the game window
    GUIGame (Settings guiSettings) {

        // Frame and panel setup
        gameFrame = new JFrame("Title Screen");
        containerPanel = new JPanel();
        titleScreenPanel = new JPanel();
        mapPanel = new JPanel();

        // Button setup
        mapTitleButton = new JButton("Title");
        titleNewGameButton = new JButton("New Game");
        titleNewGameButton.addActionListener(this);
        mapTitleButton.addActionListener(this);

        // Add components to their respective panels
        titleScreenPanel.add(titleNewGameButton);
        mapPanel.add(mapTitleButton);

        // Organize panels in the containerPanel
        containerPanel.setLayout(cardLayout);
        containerPanel.add(titleScreenPanel, "TITLE");
        containerPanel.add(mapPanel, "MAP");
        cardLayout.show(containerPanel, "TITLE"); // Show the title screen first

        // Add everything to gameFrame
        gameFrame.add(containerPanel);
        gameFrame.setResizable(false);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(guiSettings.getX(), guiSettings.getY()); // Res based on user input
        gameFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == titleNewGameButton) {
            cardLayout.show(containerPanel, "MAP");
        }
        if (e.getSource() == mapTitleButton) {
            cardLayout.show(containerPanel, "TITLE");
        }
    }
}
