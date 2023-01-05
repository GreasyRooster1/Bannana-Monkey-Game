package System.Entity.UI.Button;

import System.Entity.BaseEntity.Entity;
import System.Entity.BaseEntity.Renders.EntityRender;
import System.Scene.Scene;
import System.Setup.Setup;
import System.TextureLoader.TextureLoader;
import processing.core.PApplet;
import processing.core.PImage;

public class ButtonImageRender extends EntityRender {
    public String texturePath;
    public ButtonImageRender(){

    }
    public void render(Entity e1){
        Button e = (Button) e1;
        PApplet applet = Setup.getApplet();
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        applet.fill(255);
        PImage tex = TextureLoader.getTexture(texturePath);
        if(tex!=null) {
            applet.image(tex, e.getX(), e.getY(), e.getW(), e.getH());
        }else{
            applet.fill(0);
            applet.rect(e.getX(), e.getY(), e.getW(), e.getH());
            applet.fill(255,0,255);
            applet.rect(e.getX(), e.getY(), e.getW()/2, e.getH()/2);
            applet.rect(e.getX()+e.getW()/2, e.getY()+e.getH()/2, e.getW()/2, e.getH()/2);
        }
        if(!e.canClick()){
            applet.fill(0,127);
            applet.rect(e.getX(), e.getY(), e.getW(), e.getH());
        }
    }
}
