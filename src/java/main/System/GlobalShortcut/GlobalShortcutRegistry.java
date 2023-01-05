package System.GlobalShortcut;

import System.GlobalShortcut.Types.GlobalShortcut;
import System.Scene.Scene;
import System.Setup.Setup;

import static processing.core.PApplet.append;

public class GlobalShortcutRegistry {
    private static GlobalShortcut[] shortcuts = {};
    public static void registerShortcut(GlobalShortcut s) {
        shortcuts = (GlobalShortcut[]) append(shortcuts,s);
    }
    public static GlobalShortcut[] getShortcuts(){
        return shortcuts;
    }
}
