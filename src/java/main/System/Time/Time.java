package System.Time;

import java.time.Clock;

public class Time {
    static Clock clock = Clock.systemDefaultZone();
    public static float deltaTime=0;
    private static float lastFrame=0;
    public static void updateTime(){
        deltaTime=millis()-lastFrame;
    }
    public static void afterFrame(){
        lastFrame = millis();
    }

    private static long millis() {
        return clock.millis();
    }
}
