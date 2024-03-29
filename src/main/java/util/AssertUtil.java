package util;

public class AssertUtil {
    public static void isTrue(boolean b,String message){
        if (b) {
            throw new RuntimeException(message);
        }
    };
}
