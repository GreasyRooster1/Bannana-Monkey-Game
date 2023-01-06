package Game;

import System.Logging.Logger;
import System.Setup.Setup;

public class Startup {
    public static void begin(){
        Logger.log("Game.Startup received begin...","game");
        Setup.getSceneManager().changeScene("gameScene");
    }
}
