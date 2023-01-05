package System.GlobalShortcut.Types;

import System.Setup.Setup;

public class GlobalShortcut {
    private int keyCode;

    public GlobalShortcut(int code){
        keyCode = code;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    public void check(){
        if(Setup.getApplet().keyPressed){
            if(Setup.getApplet().keyCode==keyCode){
                shortcutEvent();
            }
        }
    }
    public void shortcutEvent(){

    }
}
