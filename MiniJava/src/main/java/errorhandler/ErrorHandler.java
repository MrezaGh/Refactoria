package errorhandler;

/**
 * Created by Alireza on 6/28/2015.
 */
public final class ErrorHandler {
    public static boolean hasError = false;

    private ErrorHandler(){
        /*Private Constructor will prevent
         * the instantiation of this class directly
         * so this is a Utility class*/
    }

    public static void printError(String msg) {
        hasError = true;
        System.out.println(msg);
    }
}
