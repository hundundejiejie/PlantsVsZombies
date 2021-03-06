package game.ui;
import javax.swing.*;

/**
 * Created by Armin on 6/25/2016.
 */
public class GameWindow extends JFrame {

    public final static String RESOURCE_FOLDER = "./data/resources/";
    
    
	private GamePanel gamePanel;
	
    
    private GameWindow() {
        this.setLocationRelativeTo(null);
    }

    public static GameWindow fightWindow() {
        GameWindow gameWindow = new GameWindow();
        gameWindow.setSize(1012, 785);
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameWindow.setLayout(null);

        gameWindow.setGamePanel();

        
        gameWindow.setResizable(false);
        gameWindow.setVisible(true);
        return gameWindow;
    }

	private void setGamePanel() {
		gamePanel = new GamePanel(true);
        gamePanel.setLocation(0, 0);
        getLayeredPane().add(gamePanel, Integer.valueOf(0));
	}

	

    public static GameWindow menuWindow() {
        GameWindow gameWindow = new GameWindow();
        Menu menu = new Menu();
        menu.setLocation(0, 0);
        gameWindow.setSize(1012, 785);
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameWindow.getLayeredPane().add(menu, new Integer(0));
        menu.repaint();
        gameWindow.setResizable(false);
        gameWindow.setVisible(true);
        return gameWindow;
    }

    private static GameWindow gameWindow;

    public static void intoFightWindow() {
        gameWindow.dispose();
        gameWindow = fightWindow();
    }

    public static void main(String[] args) {
        gameWindow = fightWindow();
    }
    public GamePanel getGamePanel() {
    	return gamePanel;
    }
}
