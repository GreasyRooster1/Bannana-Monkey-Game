package Game.Entites.Moon;

import System.Entity.BaseEntity.Entity;

public class Earth extends Entity {
    public Earth(float xa, float ya) {
        super(xa, ya);
        setRender(new EarthRender());
        setW(150);
        setH(150);
    }
}
