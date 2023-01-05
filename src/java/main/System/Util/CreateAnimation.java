package System.Util;

import System.TextureLoader.Animation.AnimationTexture;
import System.TextureLoader.Texture;
import System.TextureLoader.TextureLoader;

import static System.TextureLoader.TextureLoader.getAnimationClass;
import static System.TextureLoader.TextureLoader.getTextureClass;

public class CreateAnimation {
    public static AnimationTexture createAnimation(String path,String name,int length,int speed){
        TextureLoader.registerAnimation(path,name);
        AnimationTexture anim = (AnimationTexture) getAnimationClass(name);
        anim.setLength(length);
        anim.setAnimationSpeed(speed);
        anim.resetFrames();
        return anim;
    }
}
