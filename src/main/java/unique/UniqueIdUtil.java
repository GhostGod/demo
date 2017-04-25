package unique;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyang on 2017/4/24.
 */
public class UniqueIdUtil {
    static int sequence = 1000;
    public static synchronized int increment(){
        if(sequence>9999){
            sequence = 0;
        }
        return sequence++;
    }

    public static String generateId(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHssmm");
        String date = sdf.format(new Date());
        String id = "0123456789"+date+increment();
        return id;
    }

    public static void main(String[] args){
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<1000;i++){
            String key = generateId();
            Integer count = map.get(key);
            if(count == null){
                map.put(key,1);
            }else{
                map.put(key,count+1);
            }
        }
        for(Map.Entry<String,Integer> e : map.entrySet()){
            if(e.getValue()>1){
                System.out.println(e.getKey()+"--"+e.getValue());
            }
        }
        System.out.println("无重复");
    }
}
