package System.Entity.BaseEntity.Renders;

import System.Entity.BaseEntity.Entity;
import System.Scene.Scene;
import System.Setup.Setup;
import processing.core.PApplet;

public class EntityTransparentRender extends EntityRender{
    public float transparency;
    public EntityTransparentRender(){

    }
    public void render(Entity e){
        PApplet applet = Setup.getApplet();
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        float camX = currentScene.getCamera().getCamX();
        float camY = currentScene.getCamera().getCamY();
        applet.noStroke();
        applet.fill(0,transparency);
        applet.rect(e.getX()+camX,e.getY()+camY,e.getW(),e.getH());
    }
}
