package Game.Entites.Earth;

import System.Entity.BaseEntity.Entity;

public class Earth extends Entity {
    private float mass = 5000;
    public Earth(float xa, float ya) {
        super(xa, ya);
        setRender(new EarthRender());
        setW(150);
        setH(150);
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }
}
