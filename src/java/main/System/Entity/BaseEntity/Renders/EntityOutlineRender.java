package System.Entity.BaseEntity.Renders;

import System.Entity.BaseEntity.Entity;
import System.Scene.Scene;
import System.Setup.Setup;
import processing.core.PApplet;

public class EntityOutlineRender extends EntityRender {
    public EntityOutlineRender(){

    }
    public void render(Entity e){
        PApplet applet = Setup.getApplet();
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        float camX = currentScene.getCamera().getCamX();
        float camY = currentScene.getCamera().getCamY();
        applet.noFill();
        applet.stroke(0,0,255);
        applet.rect(e.getX()+camX,e.getY()+camY,e.getW(),e.getH());
    }
}
