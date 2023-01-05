package System.Entity.UI;

import System.Entity.BaseEntity.Entity;

public class UIEntity extends Entity {
    protected UIEntity(float xa, float ya){
        super(xa,ya);
        isUI=true;
    }
}
