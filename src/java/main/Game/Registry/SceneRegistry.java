package Game.Registry;

import Game.Scenes.GameScene.GameScene;
import System.Scene.Scene;
import System.Setup.Setup;

public class SceneRegistry {
    public static void registerScenes() {
        register(new GameScene());
    }
    static void register(Scene s){
        Setup.getSceneManager().incomingScene(s);
    }
}
