import System.Entity.BaseEntity.Entity;
import System.Logging.Logger;
import System.Setup.Setup;
import processing.core.PApplet;

public class Base extends PApplet {

    public void settings() {
        size(500, 500);
    }
    public void setup(){
        Setup.start(this);
    }

    public void draw() {
        Setup.execution();
    }

    public static void main(String... args) {
        PApplet.main("Base");
    }

    public void keyReleased(){
        for (Entity e : Setup.getSceneManager().getCurrentScene().entities) {
            e.onKey(key);
        }
    }
}
