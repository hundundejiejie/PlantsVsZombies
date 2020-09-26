package game.mod.pvz.plant;

import game.GamePanel;
import game.entity.bullet.template.Explosion;
import game.entity.gameobject.Spirit;
import game.entity.gameobject.WorkStatus.WorkState;
import game.entity.plant.PlantModel;
import game.entity.plant.PlantModelBuilder;
import game.entity.plant.template.MinePlant;
import game.mod.pvz.PvzMod;
import game.mod.pvz.bullet.PotetoMineExplosionBuilder;
import game.utils.ImageLoadTool;

/**
 * @author hundun
 * Created on 2020/09/24
 */
public class PotetoMineBuilder extends PlantModelBuilder {
    public static final String NAME = "poteto_mine";
    public final String modName = PvzMod.NAME;
    
    @Override
    protected PlantModel start() {
        PlantModel model;
        model = new PlantModel(NAME, MinePlant.class);
        model.spirit = new Spirit(ImageLoadTool.loadOnePlantImage(modName, model.registerName, WorkState.IDLE))
                .build(WorkState.WORK_READY, ImageLoadTool.loadOnePlantImage(modName, model.registerName, WorkState.WORK_READY))
                .build(WorkState.WORKING, ImageLoadTool.loadOnePlantImage(modName, model.registerName, WorkState.WORKING))
                ;
        model.plantCost = 25;
        return model;
    }

    @Override
    protected void build(PlantModel model) {
        model.fightData
                .buildBullet(PotetoMineExplosionBuilder.NAME)
                .buildSelfGridAttackRange()
                .buildDefaultPlantAttackLoop();
        model.fightData.attackColdDownFrameNum = GamePanel.LOGICAL_FRAME_NUM_PER_SECOND * 4;
        model.fightData.bulletStartOffsetX = - 0;
        model.fightData.bulletStartOffsetY = 0;
    }

}
