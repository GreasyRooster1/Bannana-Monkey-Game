package System.Scene;

import System.Camera.Camera;
import System.Entity.BaseEntity.Entity;
import System.Logging.Logger;
import System.Setup.Setup;
import System.TextureLoader.Texture;
import System.TextureLoader.TextureLoader;
import processing.core.PApplet;

import java.util.Set;

import static System.TextureLoader.TextureLoader.getTextures;

public class Scene {
    private boolean isActive;
    public String name;
    private int backgroundColor;
    private Camera camera;
    private boolean isPaused;
    private Scene backgroundScene;
    public Entity[] entities = {};
    public Scene(){
        isActive = false;
        name = "[Scene.name]";
        camera = new Camera();
        onStartup();
        camera.update();
    }

    public void update(){
        if(backgroundScene!=null){
            backgroundScene.update();
        }
        if(!isPaused) {
            camera.update();
            everyFrame();
        }
        Setup.getApplet().fill(backgroundColor);
        if(Setup.getApplet().alpha(backgroundColor)!=0) {
            Setup.getApplet().rect(-10, -10, 600, 600);
        }
        updateAllEntities();
        updateTextures();
    }

    public void everyFrame(){}
    public void onStartup(){}
    public void onSwitch() {}
    public void onSetBackground(){}
    public void onSetToBackground(){}
    public void updateAllEntities(){
        Entity[] ui ={};
        Entity[] backgronud ={};
        Entity[] normal ={};
        for(Entity e:entities){
            if(!e.isDead()) {
                if(e.isBackground) {
                    backgronud = (Entity[]) PApplet.append(backgronud,e);
                    continue;
                }
                if(e.isUI) {
                    ui = (Entity[]) PApplet.append(ui,e);
                    continue;
                }
                normal = (Entity[]) PApplet.append(normal,e);
            }
        }
        for (Entity e : backgronud) {
            e.update();
        }
        for (Entity e : normal) {
            e.update();
        }
        for (Entity e : ui) {
            e.update();
        }


        Entity[] out = {};
        for (Entity e : entities) {
            if(!e.isDead()){
                out = (Entity[]) PApplet.append(out,e);
            }
        }
        entities=out;
    }
    public static void updateTextures(){
        for(Texture t : getTextures()){
            t.update();
        }
    }

    public Entity addEntity(Entity e){
        entities = (Entity[]) PApplet.append(entities,e);
        return  e;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Camera getCamera() {
        return camera;
    }

    public void killAll(){
        for (Entity e : entities) {
            e.kill();
        }

    }

    public void setBackgroundColor(float r,float g,float b) {
        this.backgroundColor = Setup.getApplet().color(r,g,b);
    }
    public void setBackgroundColor(float r,float g,float b,float a) {
        this.backgroundColor = Setup.getApplet().color(r,g,b,a);
    }
    public void setBackgroundColor(float r,float a) {
        this.backgroundColor = Setup.getApplet().color(r,a);
    }
    public void setBackgroundColor(float r) {
        this.backgroundColor = Setup.getApplet().color(r);
    }
    public int getBackgroundColor(){
        return backgroundColor;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
        for(Entity e:entities){
            e.setPaused(isPaused);
        }
    }

    public void setBackgroundScene(Scene bs) {
        if(bs==null) {
            if(backgroundScene!=null) {
                backgroundScene.setPaused(false);
                backgroundScene = null;
                return;
            }
            return;
        }
        if(bs.getClass()==this.getClass()){
            return;
        }
        this.backgroundScene = bs;
        bs.setPaused(true);
        syncCamera(bs);
        onSetBackground();
        bs.onSetToBackground();
    }
    public void setBackgroundScene(String str) {
        Scene bs = Setup.getSceneManager().getSceneByName(str);
        setBackgroundScene(bs);
    }

    public void syncCamera(Scene s){
        getCamera().setCamX(s.getCamera().getCamX());
        getCamera().setCamY(s.getCamera().getCamY());
    }
}
