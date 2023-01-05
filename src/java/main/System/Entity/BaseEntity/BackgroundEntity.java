package System.Entity.BaseEntity;

import System.Camera.Camera;
import System.Entity.BaseEntity.Renders.EntityRender;
import System.Setup.Setup;
import System.Util.Utils;
import processing.core.PApplet;

public class BackgroundEntity extends Entity{

    public BackgroundEntity(float xa, float ya) {
        super(xa, ya);
        isBackground = true;
    }
}
