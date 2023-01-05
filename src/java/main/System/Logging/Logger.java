package System.Logging;

public class Logger {
    private static String currentLoggingType = "all";

    public static void log(String message,String type){
        if(currentLoggingType=="all") {
            formatAndSendLog(message,type);
            return;
        }
        if(currentLoggingType=="system"&&type=="system") {
            formatAndSendLog(message,type);
            return;
        }
        if(currentLoggingType=="game"&&type=="game") {
            formatAndSendLog(message,type);
            return;
        }
        if(currentLoggingType=="logger"&&type=="logger") {
            formatAndSendLog(message,type);
            return;
        }
        if(currentLoggingType=="required"&&type=="required") {
            formatAndSendLog(message,type);
            return;
        }
        if(type=="info") {
            formatAndSendLog(message,type);
        }
        if(type=="error") {
            formatAndSendLog(message,type);
        }
        if(type=="warn") {
            formatAndSendLog(message,type);
        }
    }
    private static void formatAndSendLog(String message, String type){
        if(type=="error"||type=="warn"||type=="info") {
            System.out.println("[" + type.toUpperCase() + "] "+message);
        }else{
            System.out.println("[INFO:" + type.toUpperCase() + "] "+message);
        }
    }
    public void setCurrentLoggingType(String l){
        currentLoggingType = l;
        log("switched logging type to "+l,"logger");
    }
}
