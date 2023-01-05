package System.Entity.UI.ProgressBar;

import System.Entity.BaseEntity.Entity;
import System.Entity.UI.UIEntity;

public class ProgressBar extends UIEntity {
    private float lerp;

    public ProgressBar(float xa, float ya) {
        super(xa, ya);
        lerp = 1;
        setW(100);
        setH(50);
    }
    public void onStartup(){
        setRender(new ProgressBarRender());
    }
    public float getLerp() {
        return lerp;
    }
    public Entity setLerp(float l) {
        lerp = l;
        return this;
    }
}
