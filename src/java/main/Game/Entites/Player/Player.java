package Game.Entites.Player;

import Game.Entites.Moon.Earth;
import Game.Scenes.GameScene.GameScene;
import System.Entity.BaseEntity.Entity;
import System.Setup.Setup;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static processing.core.PApplet.sin;

public class Player extends Entity {
    public Player(float xa, float ya) {
        super(xa, ya);
        setRender(new PlayerRender());
        setW(32);
        setH(32);
    }
    public void everyFrame(){
        movement();
    }
    public void movement(){
        Earth earth = ((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).earth;
        float dirFromEarth = (float) atan2(Setup.getMouseY()- earth.getY(),Setup.getMouseX()- earth.getX());
        float distanceFromEarth = earth.getW()/2+getH()/2;
        float newX = (float) (earth.getX()+cos(dirFromEarth)*distanceFromEarth);
        float newY = earth.getY()+sin(dirFromEarth)*distanceFromEarth;
        setX(newX);
        setY(newY);
    }
}
