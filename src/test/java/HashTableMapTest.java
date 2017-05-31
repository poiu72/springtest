import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

/**
 * Created by feng on 2017/5/29.
 */
public class HashTableMapTest
{
//    FutureTask futureTask = new FutureTask();

    public static void main(String[] args)
    {
//        testHashMap();

        Map map = new HashMap();

        map.put(null, null);
        map.put(null, "aaa");

        map.put(1, null);
        map.put(2, null);
        map.put(3, null);
        System.out.println(map);

    }

    public static void testHashMap(){
        Map map = new HashMap();
        Random random = new Random();
        int bound = 10000000;
        long start = System.currentTimeMillis();
        for(int i=0; i<bound; i++){
            int randomInt = random.nextInt(bound);
            map.put(randomInt, randomInt);
        }
        long end = System.currentTimeMillis();
        System.out.println("HashMap --" + (end-start));

        start = System.currentTimeMillis();
        map = Collections.synchronizedMap( new HashMap());
        for(int i=0; i<bound; i++){
            int randomInt = random.nextInt(bound);
            map.put(randomInt, randomInt);
        }
        end = System.currentTimeMillis();
        System.out.println("synchronizedMap HashMap --" + (end-start));

        start = System.currentTimeMillis();
        map = new ConcurrentHashMap();
        for(int i=0; i<bound; i++){
            int randomInt = random.nextInt(bound);
            map.put(randomInt, randomInt);
        }
        end = System.currentTimeMillis();
        System.out.println("ConcurrentHashMap --" + (end-start));

       /* 10000000
        HashMap --11547
        synchronizedMap HashMap --5962
        ConcurrentHashMap --8183

        HashMap --12516
synchronizedMap HashMap --7846
ConcurrentHashMap --10785

        */
    }
}
