package imooc.utils;

import java.util.UUID;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/06
 **/
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
