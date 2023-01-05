package System.TextureLoader;

import System.Logging.Logger;
import System.TextureLoader.Animation.AnimationTexture;
import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;
import java.util.Objects;

public class TextureLoader {
    static String assetsPath = new File(System.getProperty("user.dir")).getAbsolutePath()+"\\";
    private static Texture[] textures = {};
    public static PImage getTexture(String name){
        PImage tex = null;
        for(Texture t:textures){
            if(t.getName().equals(name)){
                tex = t.getTexture();
            }
        }
        if(tex==null){
            return getTexture("other.missing");
        }
        return tex;
    }
    public static Texture getTextureClass(String name){
        PImage tex = null;
        for(Texture t:textures){
            if(t.getName().equals(name)){
                return t;
            }
        }
        return null;
    }
    public static AnimationTexture getAnimationClass(String name){
        PImage tex = null;
        for(Texture t:textures){
            if(Objects.equals(t.getName(), name)){
                if(t.getClass() == AnimationTexture.class){
                    return (AnimationTexture) t;
                }
            }
        }
        return getAnimationClass("other.missingAnim");
    }
    public static Texture registerTexture(String img, String name){
        Texture a = new Texture(assetsPath+img,name);
        Logger.log(assetsPath,"system");
        textures = (Texture[]) PApplet.append(textures,new Texture(img,name));
        Logger.log("Texture "+img+" added to the texture loader as "+name,"system");
        return a;
    }
    public static AnimationTexture registerAnimation(String img, String name){
        AnimationTexture a = new AnimationTexture(assetsPath+img,name);
        textures = (Texture[]) PApplet.append(textures,a);
        Logger.log("Animation "+img+" added to the texture loader as "+name,"system");
        return a;
    }
    public static Texture[] getTextures(){
        return textures;
    }
}
