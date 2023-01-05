package System.Setup;

import System.GlobalShortcut.GlobalShortcutRegistry;
import System.GlobalShortcut.Types.GlobalShortcut;
import System.Logging.Logger;
import System.Registers.SceneRegistry;
import System.Scene.SceneManager;
import System.TextureLoader.Texture;
import System.Time.Time;
import processing.core.PApplet;

import static System.TextureLoader.TextureLoader.getTextures;

public class Setup {
    private static PApplet pAppletInstance;
    private static SceneManager sceneManager;

    public static void start(PApplet pai) {
        Logger.log("Setup received start","info");
        pAppletInstance = pai;
        sceneManager = new SceneManager();
        SceneRegistry.registerScenes();
        Game.Registry.SceneRegistry.registerScenes();
        Game.Startup.begin();
        sceneManager.postSetup();
    }

    public static SceneManager getSceneManager() {
        return sceneManager;
    }

    public static PApplet getApplet(){
        return pAppletInstance;
    }

    public static float getMouseX(){
        return pAppletInstance.mouseX-sceneManager.getCurrentScene().getCamera().getCamX();
    }
    public static float getMouseY(){
        return pAppletInstance.mouseY-sceneManager.getCurrentScene().getCamera().getCamY();
    }
    static void updateShortcuts(){
        for(GlobalShortcut g: GlobalShortcutRegistry.getShortcuts()){
            g.check();
        }
    }

    public static void execution(){
        Time.updateTime();
        sceneManager.renderCurrentScene();
        updateShortcuts();
        Time.afterFrame();
    }
}
