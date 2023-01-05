package System.Camera;

import System.Entity.BaseEntity.Entity;

public class Camera {
    private float camX,camY;
    private float camLockStartX,camLockStartY;
    Entity camLock;
    public Camera(){
        camX = 0;
        camY = 0;
        camLock = null;
    }

    public void update(){
        if(getCamLock()!=null) {
            camX -= camLock.getDeltaX();
            camY -= camLock.getDeltaY();
        }
    }

    public float getCamX() {
        return camX;
    }

    public void setCamX(float camX) {
        this.camX = camX;
    }

    public float getCamY() {
        return camY;
    }

    public void setCamY(float camY) {
        this.camY = camY;
    }

    public Entity getCamLock() {
        return camLock;
    }

    public void setCamLock(Entity c) {
        camLock = c;
        camX = 250-c.getX()-(c.getW()/2);
        camY = 250-c.getY()-(c.getH()/2);
    }
}
