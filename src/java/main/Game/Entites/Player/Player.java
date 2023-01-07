package Game.Entites.Player;

import Game.Entites.Banana.Banana;
import Game.Entites.Earth.Earth;
import Game.Scenes.GameScene.GameScene;
import System.Entity.BaseEntity.Entity;
import System.Setup.Setup;
import processing.core.PApplet;

import static java.lang.Math.atan2;
import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;
import static processing.core.PApplet.abs;


public class Player extends Entity {
    private boolean isThrowing = false;
    private float speed = 0.03F;
    public Player(float xa, float ya) {
        super(xa, ya);
        setRender(new PlayerRender());
        setW(32);
        setH(32);
    }
    public void everyFrame(){
        movement();
        throwBananas();
    }
    public void movement(){
        if(isThrowing){return;}
        Earth earth = ((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).earth;
        float targetDir = (float) atan2(Setup.getMouseY()- earth.getY(),Setup.getMouseX()- earth.getX());
        float currentDirFromEarth = (float) atan2(getY()- earth.getY(),getX()- earth.getX());
        float dirFromEarth = currentDirFromEarth;
        if(abs(currentDirFromEarth-targetDir)>=speed) {
            if (currentDirFromEarth < targetDir) {
                dirFromEarth += speed;
            }
            if (currentDirFromEarth > targetDir) {
                dirFromEarth -= speed;
            }
        }
        float distanceFromEarth = earth.getW()/2+getH()/2;
        float newX = earth.getX()+cos(dirFromEarth)*distanceFromEarth;
        float newY = earth.getY()+sin(dirFromEarth)*distanceFromEarth;
        setX(newX);
        setY(newY);
    }
    public void throwBananas(){
        PApplet applet = Setup.getApplet();
        if(applet.mousePressed){
            isThrowing = true;
        }else{
            if(isThrowing){
                throwBanana();
            }
            isThrowing = false;
        }
        if(isThrowing){
            float dir = (float) atan2(Setup.getMouseY()-getY(),Setup.getMouseX()-getX());
            float mag = PApplet.dist(getX(),getY(),Setup.getMouseX(),Setup.getMouseY());
            float lineLength = 50;
            float lineX = getX()+cos(dir)*lineLength;
            float lineY = getY()+sin(dir)*lineLength;
            applet.stroke(0,0,255);
            applet.line(getX(),getY(),lineX,lineY);
            applet.stroke(0);
        }
    }

    private void throwBanana() {
        float dir = (float) atan2(Setup.getMouseY()-getY(),Setup.getMouseX()-getX());
        float mag = PApplet.dist(getX(),getY(),Setup.getMouseX(),Setup.getMouseY())/50;
        float d = 50;
        Banana b = new Banana(getX()+cos(dir)*d,getY()+sin(dir)*d);
        b.setXvel(cos(dir)*mag);
        b.setYvel(sin(dir)*mag);
        Setup.getSceneManager().getSceneByName("gameScene").addEntity(b);
    }
}
