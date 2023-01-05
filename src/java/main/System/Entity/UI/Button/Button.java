package System.Entity.UI.Button;

import System.Entity.UI.UIEntity;

public class Button extends UIEntity {
    private boolean canClick = true;
    public Button(float xa, float ya) {
        super(xa, ya);
        setW(100);
        setH(50);
    }
    public void onStartup(){
        setRender(new ButtonRender());
    }
    public void onButtonClick(int button){

    }
    public void onMouseRelease(int button){
        if(canClick) {
            onButtonClick(button);
        }
    }

    public boolean canClick() {
        return canClick;
    }

    public void setCanClick(boolean canClick) {
        this.canClick = canClick;
    }
}
