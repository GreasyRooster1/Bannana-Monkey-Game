package System.Scene.SystemScenes;

import System.Scene.Scene;
import System.Setup.Setup;
import processing.core.PApplet;
import processing.core.PConstants;

public class DebugScene extends Scene {
    public DebugScene(){
        super();
        name = "System.debugScene";
    }
    public void onSwitch(){
        setBackgroundScene(Setup.getSceneManager().getPreviousScene());
    }
    public void everyFrame(){
        PApplet applet = Setup.getApplet();
        applet.textAlign(PConstants.RIGHT);
        applet.textSize(13);
        applet.text("FPS: "+applet.frameRate,0,0);
    }
}
