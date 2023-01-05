package System.Registers;

import System.Logging.Logger;
import System.Scene.Scene;
import System.Scene.SceneManager;
import System.Scene.SystemScenes.DebugScene;
import System.Scene.SystemScenes.DefaultScene;
import System.Setup.Setup;

public class SceneRegistry {

    public static void registerScenes() {
        registerScene(new DefaultScene());
        registerScene(new DebugScene());
    }

    private static void registerScene(Scene scene) {
        Setup.getSceneManager().incomingScene(scene);
    }

}
