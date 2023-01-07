package Game.Scenes.GameScene;

import Game.Entites.Earth.Earth;
import Game.Entites.Player.Player;
import System.Scene.Scene;
import System.Setup.Setup;

public class GameScene extends Scene {
    public Earth earth;
    public GameScene(){
        super();
    }
    public void onStartup(){
        name = "gameScene";
    }
    public void onSwitch(){
        addEntity(new Player(250,250));
        earth = (Earth) addEntity(new Earth(500,500));
    }
    public void everyFrame(){
        Setup.getApplet().background(0);
    }
}
