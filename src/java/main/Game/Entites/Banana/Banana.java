package Game.Entites.Banana;

import Game.Entites.Earth.Earth;
import Game.Scenes.GameScene.GameScene;
import System.Entity.BaseEntity.Entity;
import System.Setup.Setup;
import System.Util.Collision;
import processing.core.PApplet;

import static java.lang.Math.atan2;
import static processing.core.PApplet.*;

public class Banana extends Entity {
    private float mass = 1;
    private boolean frozen = false;
    public Banana(float xa, float ya) {
        super(xa, ya);
        setRender(new BananaRender());
        setSize(15);
        setFriction(1);
        setLife(1);
        setDecay(-1);
    }
    public void everyFrame(){
        gravity();
        checkCollision();
    }
    void gravity(){
        if(frozen){
            setXvel(0);
            setYvel(0);
            return;
        }
        Earth earth = ((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).earth;
        float dir = (float) atan2(earth.getY()-getY(),earth.getX()-getX());
        float gravConst = 1;
        float mag = (earth.getMass()*mass)/pow(PApplet.dist(getX(),getY(),earth.getX(),earth.getY()),2);
        setXvel(getXvel()+cos(dir)*mag);
        setYvel(getYvel()+sin(dir)*mag);
    }
    void checkCollision(){
        Earth earth = ((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).earth;
        if(Collision.circle(this,earth)&&getLife()>3){
            frozen = true;
        }
    }
}
