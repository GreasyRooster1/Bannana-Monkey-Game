package System.TextureLoader.Animation;

import System.Logging.Logger;
import System.Setup.Setup;
import System.TextureLoader.Texture;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.Objects;

public class AnimationTexture extends Texture {
    private PImage[] frames={};
    private String path;
    private int animationSpeed,length,currentFrame;
    private String playmode;
    private boolean running = true;

    public AnimationTexture(String img, String n) {
        super(img,n);
        running = true;
        playmode = "infinite";
        path = img;
        currentFrame=0;
        animationSpeed=5;
        length=0;
        resetFrames();
    }

    public void resetFrames() {
        currentFrame = 0;
        running = true;
        for(int i=1;i<=length;i++){
            frames = (PImage[]) PApplet.append(frames,Setup.getApplet().loadImage(path+"/"+i+".png"));
        }
    }

    public PImage getTexture() {
        return texture;
    }

    public void setTexture(PImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update(){
        if(Setup.getApplet().frameCount%animationSpeed==0&&running){

            texture = frames[currentFrame];
            currentFrame++;
            if(currentFrame>=length){
                if(Objects.equals(playmode, "infinite")) {
                    currentFrame = 0;
                }else if(Objects.equals(playmode, "once")){
                    running = false;
                }
            }
        }
    }

    public void setAnimationSpeed(int animationSpeed) {
        this.animationSpeed = animationSpeed;
    }
    public int getAnimationSpeed() {
        return animationSpeed;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getPlaymode() {
        return playmode;
    }

    public void setPlaymode(String playmode) {
        this.playmode = playmode;
    }
    public boolean getRunning() {
        return running;
    }

    public void setRunning(boolean r) {
        this.running = r;
    }

    public int getFrame() {
        return currentFrame;
    }

    public void setFrame(int length) {
        this.currentFrame = length;
    }
}
