package System.Entity.BaseEntity;

import System.Camera.Camera;
import System.Entity.BaseEntity.Renders.EntityRender;
import System.Setup.Setup;
import System.Util.Utils;
import processing.core.PApplet;

public class Entity {
    private float x,y;
    private float w,h;
    private float size;
    private float xvel,yvel,friction;
    private boolean mouseDownLast;
    private boolean dead;
    private boolean[] keysDown = new boolean[1000];
    private float px,py;
    public boolean isUI,isBackground;
    private float life;
    private float decay;
    private final float ID=Setup.getApplet().random(-99999,99999);
    private EntityRender entityRender;
    private boolean isPaused;
    public Entity(float xa, float ya){
        isUI=false;
        isPaused = false;
        x = xa;
        y = ya;
        xvel = 0;
        yvel = 0;
        size = 100;
        entityRender = new EntityRender();
        mouseDownLast = false;
        dead = false;
        decay=0;
        life=100;
        onStartup();
    }
    public void update(){
        if(!isPaused) {
            checkLife();
            move();
            events();
        }
        render();
    }

    void render(){
        entityRender.render(this);
    }
    void move(){
        px = x;
        py = y;
        velocity();
    }
    void checkLife(){
        if(life<=0){
            kill();
        }else{
            life-=decay;
        }
    }

    void velocity(){
        x+=xvel;
        y+=yvel;
        xvel*=friction;
        yvel*=friction;
    }

    private void events() {
        everyFrame();
        PApplet applet = Setup.getApplet();
        Camera c = Setup.getSceneManager().getCurrentScene().getCamera();
        if(applet.mousePressed){
            whileClick(applet.mouseButton);
        }
        if(!applet.mousePressed&&mouseDownLast){
            onClick(applet.mouseButton);
        }
        if(applet.keyPressed){
            whileKey(applet.key);
        }
        if(Utils.collision(x+c.getCamX(),y+c.getCamY(),w,h,applet.mouseX,applet.mouseY,1,1)){
            whileMouseHover();
        }
        if(Utils.collision(x+c.getCamX(),y+c.getCamY(),w,h,applet.mouseX,applet.mouseY,1,1)&&!applet.mousePressed&&mouseDownLast){
            onMouseRelease(applet.mouseButton);
        }
        if(Utils.mouseCollision(this)){
            onMouseClickedSelf(applet.mouseButton);
        }
        mouseDownLast = applet.mousePressed;
    }

    public void onStartup(){}
    public void everyFrame(){}
    public void whileClick(int button){

    }
    public void onClick(int button){

    }
    public void onMouseClickedSelf(int button){

    }
    public void whileKey(char key){

    }
    public void onKey(char key){

    }
    public void whileMouseHover(){

    }
    public void onMouseRelease(int button){
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
        this.w = size;
        this.h = size;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getXvel() {
        return xvel;
    }

    public void setXvel(float xvel) {
        this.xvel = xvel;
    }

    public float getYvel() {
        return yvel;
    }

    public void setYvel(float yvel) {
        this.yvel = yvel;
    }

    public void setFriction(float friction) {
        this.friction = friction;
    }

    public float getFriction() {
        return friction;
    }

    public void setRender(EntityRender entityRender) {
        this.entityRender = entityRender;
    }

    public EntityRender getRender() {
        return entityRender;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public float getH() {
        return h;
    }

    public void setH(float h) {
        this.h = h;
    }

    public float getDeltaX() {
        return x-px;
    }
    public float getDeltaY() {
        return y-py;
    }

    public boolean isDead() {
        return dead;
    }

    public void kill() {
        dead = true;
    }
    public void revive() {
        dead = false;
    }
    public void setDead(boolean b) {
        dead = b;
    }


    public float getLife() {
        return life;
    }

    public void setLife(float life) {
        this.life = life;
    }

    public void setDecay(float decay) {
        this.decay = decay;
    }
    public float setDecay() {
        return decay;
    }

    public float getID() {
        return ID;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }
}
