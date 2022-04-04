package restaurant.utils;

import static restaurant.common.ExceptionMessages.INVALID_NAME;

public class StringUtils {

    public static void nullOrEmpty(String str, String message){
        if (str == null|| str.trim().isEmpty()){
            throw  new IllegalArgumentException(message);
        }
    }
}
