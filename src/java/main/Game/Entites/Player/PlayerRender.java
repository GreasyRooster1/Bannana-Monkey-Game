package Game.Entites.Player;

import Game.Entites.Earth.Earth;
import Game.Scenes.GameScene.GameScene;
import System.Entity.BaseEntity.Entity;
import System.Entity.BaseEntity.Renders.EntityRender;
import System.Scene.Scene;
import System.Setup.Setup;
import processing.core.PApplet;

import static processing.core.PApplet.atan2;
import static processing.core.PConstants.CENTER;

public class PlayerRender extends EntityRender {
    public void render(Entity e){
        PApplet applet = Setup.getApplet();
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        float camX = currentScene.getCamera().getCamX();
        float camY = currentScene.getCamera().getCamY();
        Setup.getApplet().fill(0,255,0);
        applet.pushMatrix();
        applet.rectMode(CENTER);
        Setup.getApplet().translate(e.getX()+camX,e.getY()+camY);
        Earth earth = ((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).earth;
        Setup.getApplet().rotate(atan2(e.getY()- earth.getY(),e.getX()- earth.getX()));
        applet.rect(0,0,e.getW(),e.getH());
        applet.popMatrix();
    }
}
