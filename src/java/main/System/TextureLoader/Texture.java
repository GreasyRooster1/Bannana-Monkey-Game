package System.TextureLoader;

import System.Setup.Setup;
import processing.core.PImage;

public class Texture{
    protected PImage texture;
    protected String name;

    public Texture(String path, String n) {
        texture = Setup.getApplet().loadImage(path);
        name = n;
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
    public void update(){}
}
