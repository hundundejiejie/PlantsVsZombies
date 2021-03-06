package game.entity.bullet.template;
import java.awt.Rectangle;
import java.util.List;

import game.entity.bullet.BaseBullet;
import game.entity.bullet.BulletInstanceParams;
import game.entity.bullet.BulletModel;
import game.entity.component.BulletPositionComponent;
import game.entity.component.FightComponent;
import game.entity.component.PositionComponent;
import game.entity.gameobject.FightObject;
import game.entity.gameobject.GameObject;
import game.entity.zombie.BaseZombie;
import game.manager.GridManager;
import game.manager.ILogicFrameListener;
import game.ui.GamePanel;

/**
 * Created by Armin on 6/25/2016.
 */
public class DebuffBullect extends BaseBullet {
    //public static String NAME = "pea";
    
    public enum DebuffType {
        NONE,
        FREEZE,
        FIRE
        ;
    }
    
    public DebuffBullect(GamePanel gamePanel, BulletModel model, BulletInstanceParams params) {
        super(gamePanel, model, params);
    }


    @Override
    public void addDebuff(FightObject targetObject) {
        super.addDebuff(targetObject);
        if (getSubTypeName() != null) {
            if (getSubTypeName().equals(DebuffType.FREEZE.name())) {
                targetObject.onDebuff(DebuffType.FREEZE, GamePanel.LOGICAL_FRAME_NUM_PER_SECOND * 3);
            }
        }
        
    }

    
    @Override
    protected String getSpiritSubId() {
        return super.getSpiritSubId();
    }


    
    

}
