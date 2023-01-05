package System.GlobalShortcut.Types;

import System.Setup.Setup;

public class SceneSwitcherGlobalShortcut extends GlobalShortcut{
    private String scene;
    public SceneSwitcherGlobalShortcut(int code){
        super(code);
        scene = "System.defaultScene";
    }
    public void shortcutEvent(){
        Setup.getSceneManager().changeScene(scene);
    }

    public String getScene() {
        return scene;
    }

    public GlobalShortcut setScene(String scene) {
        this.scene = scene;
        return this;
    }
}
