package game.entity.component;

import java.awt.Rectangle;

import game.GamePanel;
import game.ILogicFrameListener;
import game.manager.GridManager;

public abstract class PositionComponent implements ILogicFrameListener {
    protected int posX;
    protected int posY;
    protected GamePanel gamePanel;
    protected boolean stopped;
    
    public PositionComponent(GamePanel gamePanel, int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.gamePanel = gamePanel;
        this.stopped = false;
    }


    @Override
    public void updateLogicFrame() {
        if (!stopped) {
            move();
        } 
    }

    public abstract void move();
    
    
    public int getPosX() {
        return posX;
    }
    
    
    public int getPosY() {
        return posY;
    }
    
    @Override
    public String toString() {
        return "(" + posX + ", " + posY + ")";
    }
    
    public abstract Rectangle getCoillderBox();
    
}