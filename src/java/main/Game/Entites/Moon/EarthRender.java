package Game.Entites.Moon;

import System.Entity.BaseEntity.Entity;
import System.Entity.BaseEntity.Renders.EntityRender;
import System.Scene.Scene;
import System.Setup.Setup;
import processing.core.PApplet;

public class EarthRender extends EntityRender {
    public void render(Entity e){
        PApplet applet = Setup.getApplet();
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        applet.fill(200);
        preRendering(e);
        float camX = currentScene.getCamera().getCamX();
        float camY = currentScene.getCamera().getCamY();
        applet.ellipse(e.getX()+camX,e.getY()+camY,e.getW(),e.getH());
    }
}
