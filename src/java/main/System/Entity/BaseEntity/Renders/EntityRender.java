package System.Entity.BaseEntity.Renders;

import System.Entity.BaseEntity.Entity;
import System.Scene.Scene;
import System.Setup.Setup;
import processing.core.PApplet;

public class EntityRender {
    public EntityRender(){

    }
    public void render(Entity e){
        PApplet applet = Setup.getApplet();
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        applet.fill(255);
        preRendering(e);
        float camX = currentScene.getCamera().getCamX();
        float camY = currentScene.getCamera().getCamY();
        applet.rect(e.getX()+camX,e.getY()+camY,e.getW(),e.getH());
        postRendering(e);
    }
    public void preRendering(Entity e){

    }
    public void postRendering(Entity e){

    }
}
