package System.Util;

import System.Entity.BaseEntity.Entity;

import static processing.core.PApplet.sqrt;

public class Collision {
    static boolean rect(float r1x, float r1y, float r1w, float r1h, float r2x, float r2y, float r2w, float r2h){
        if (r1x + r1w >= r2x &&    // r1 right edge past r2 left
                r1x <= r2x + r2w &&    // r1 left edge past r2 right
                r1y + r1h >= r2y &&    // r1 top edge past r2 bottom
                r1y <= r2y + r2h) {    // r1 bottom edge past r2 top
            return true;
        }
        return false;
    }
    static boolean rect(Entity e, Entity e1){
        return rect(e.getX(),e.getY(),e.getW(),e.getH(),e1.getX(),e1.getY(),e1.getW(),e.getH());
    }
    static boolean circle(float c1x, float c1y, float c1r, float c2x, float c2y, float c2r) {

        // get distance between the circle's centers
        // use the Pythagorean Theorem to compute the distance
        float distX = c1x - c2x;
        float distY = c1y - c2y;
        float distance = sqrt( (distX*distX) + (distY*distY) );

        // if the distance is less than the sum of the circle's
        // radii, the circles are touching!
        if (distance <= c1r+c2r) {
            return true;
        }
        return false;
    }
    public static boolean circle(Entity e, Entity e1){
        return circle(e.getX(),e.getY(),e.getW()/2,e1.getX(),e1.getY(),e1.getW()/2);
    }
}
