package Game.Entites.Banana;

import System.Entity.BaseEntity.Entity;
import System.Entity.BaseEntity.Renders.EntityRender;
import System.Scene.Scene;
import System.Setup.Setup;
import processing.core.PApplet;

public class BananaRender extends EntityRender {
    public void render(Entity e){
        PApplet applet = Setup.getApplet();
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        applet.fill(255,255,0);
        preRendering(e);
        float camX = currentScene.getCamera().getCamX();
        float camY = currentScene.getCamera().getCamY();
        applet.ellipse(e.getX()+camX,e.getY()+camY,e.getW(),e.getH());
    }
}
