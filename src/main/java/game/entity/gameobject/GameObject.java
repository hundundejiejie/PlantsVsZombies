package game.entity.gameobject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import game.GamePanel;
import game.ILogicFrameListener;
import game.entity.component.HealthComponent;
import game.entity.component.PositionComponent;
import game.entity.gameobject.WorkStatus.WorkState;
import game.manager.GridManager;

/**
 * @author hundun
 * Created on 2020/08/29
 */
public abstract class GameObject implements ILogicFrameListener {
    
    public static Font healthBarFont = new Font(Font.SERIF, Font.PLAIN, (int) (GridManager.GRID_HEIGHT * 0.1));
    public static Font positionFont = new Font(Font.SERIF, Font.PLAIN, (int) (GridManager.GRID_HEIGHT * 0.1));
    
    protected final String registerName;
    public static final int NO_SUBTYPE_INDEX = 0;
    private int subTypeId = NO_SUBTYPE_INDEX;
    protected ImageIcon selfImageIcon;
    protected final GamePanel gamePanel;
    private boolean highLight = false;
    protected Color coillderBoxColor = Color.WHITE;
    protected final String instanceName;
    private static int instanceCounter = 0;
    protected Spirit spirit;
    
    public GameObject(GamePanel gamePanel, String registerName) {
        super();
        this.gamePanel = gamePanel;
        this.registerName = registerName;
        this.instanceName = registerName + "【" + String.valueOf(instanceCounter++) + "】";
    }

    public String getRegisterName() {
        return registerName;
    }
    
    public abstract PositionComponent getPositionComponent();
    public abstract HealthComponent getHealthComponent();
    
    
//    public GamePanel getGamePanel() {
//        return gamePanel;
//    }
    
    protected ImageIcon getSpiritImageIcon() {
        return spirit.getImage(getSubTypeId());
    }
    
    public void drawSelf(Graphics g) {
        if (spirit != null) {
            ImageIcon imageIcon = getSpiritImageIcon();
            g.drawImage(imageIcon.getImage(), this.getPositionComponent().getPosX(), this.getPositionComponent().getPosY() - imageIcon.getIconHeight(), null);
        }
        if (GamePanel.DRAW_DEBUG_BOX) {
            Color last = g.getColor();
            g.setColor(coillderBoxColor);
            
            // draw coillderBox
            Rectangle coillderBox = getPositionComponent().getCoillderBox();
            if (highLight) {
                g.draw3DRect((int)coillderBox.getX(), (int)coillderBox.getY(), (int)coillderBox.getWidth(), (int)coillderBox.getHeight(), true);
            } else {
                g.drawRect((int)coillderBox.getX(), (int)coillderBox.getY(), (int)coillderBox.getWidth(), (int)coillderBox.getHeight());
            }
            // draw positionComponent pos
            int r = 4;
            g.fillOval(getPositionComponent().getPosX() - r, getPositionComponent().getPosY() - r, r * 2, r * 2);
            
            g.setFont(positionFont);
            int drawPosX = getPositionComponent().getPosX();
            int drawPosY = getPositionComponent().getPosY() - coillderBox.height + positionFont.getSize();
            g.drawString(getPositionComponent().toString(), drawPosX, drawPosY);
            
            
            

            g.setColor(last);
            
            
        }
    }
    
    
    
    @Override
    public String toString() {
        return instanceName + getPositionComponent().toString();
    }
    
    public void setHighLight(boolean highLight) {
        this.highLight = highLight;
    }

    
    
    @Override
    public void updateLogicFrame() {
        if (wantMove()) {
            getPositionComponent().updateLogicFrame();
        }
    }

    protected abstract boolean wantMove();

    public int getSubTypeId() {
        return subTypeId;
    }
    
    public void setSubTypeId(int subTypeId) {
        this.subTypeId = subTypeId;
    }
    

}
