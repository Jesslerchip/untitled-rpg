import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIGame extends JFrame implements ActionListener {

    // GUI Components
    private final CardLayout cardLayout = new CardLayout();
    private final JFrame gameFrame;
    private final JPanel gamePanel;
    private final JPanel titleScreenPanel;
    private final JPanel mapPanel;
    private final JButton mapTitleButton;
    private final JButton titleNewGameButton;

    // Constructor for the game window
    public GUIGame (Settings guiSettings) {

        // Frame and panel setup
        gameFrame = new JFrame("Title Screen");
        gamePanel = new JPanel();
        titleScreenPanel = new JPanel();
        mapPanel = new JPanel();

        // Button setup
        mapTitleButton = new JButton("Title");
        titleNewGameButton = new JButton("New Game");
        titleNewGameButton.addActionListener(e->cardLayout.show(gamePanel, "MAP"));
        mapTitleButton.addActionListener(e->cardLayout.show(gamePanel, "TITLE"));

        // Add components to their respective panels
        titleScreenPanel.add(titleNewGameButton);
        mapPanel.add(mapTitleButton);

        // Organize panels in the gamePanel
        gamePanel.setLayout(cardLayout);
        gamePanel.add(titleScreenPanel, "TITLE");
        gamePanel.add(mapPanel, "MAP");
        cardLayout.show(gamePanel, "TITLE"); // Show the title screen first

        // Add everything to gameFrame
        gameFrame.add(gamePanel);
        gameFrame.setResizable(false);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(guiSettings.getX(), guiSettings.getY()); // Res based on user input
        gameFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
