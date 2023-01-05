package System.Entity.BaseEntity.Renders;

import System.Entity.BaseEntity.Entity;
import System.Scene.Scene;
import System.Setup.Setup;
import System.TextureLoader.TextureLoader;
import processing.core.PApplet;
import processing.core.PImage;

public class EntityImageStaticRender extends EntityRender {
    public String texturePath;
    public boolean useCamera = true;
    public EntityImageStaticRender(){

    }
    public void render(Entity e){
        PApplet applet = Setup.getApplet();
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        float camX = 0;
        float camY = 0;
        if(!useCamera){
            camX = 0;
            camY = 0;
        }
        applet.fill(255);
        PImage tex = TextureLoader.getTexture(texturePath);
        if(tex!=null) {
            applet.image(tex, e.getX() + camX, e.getY() + camY, e.getW(), e.getH());
        }else{
            applet.fill(0);
            applet.rect(e.getX() + camX, e.getY() + camY, e.getW(), e.getH());
            applet.fill(255,0,255);
            applet.rect(e.getX() + camX, e.getY() + camY, e.getW()/2, e.getH()/2);
            applet.rect(e.getX()+e.getW()/2 + camX, e.getY()+e.getH()/2 + camY, e.getW()/2, e.getH()/2);
        }
    }
}
