package zjj.oa.utils;

import java.io.Serializable;

public class OAUtils {

    public static String array2String(Serializable[] ids) {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<ids.length; i++) {
            if (i == ids.length - 1) {
                sb.append(ids[i]);
            }else{
                sb.append(ids[i]+ ",");
            }
        }
        return sb.toString();
    }

}
