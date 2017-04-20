import redis.clients.jedis.Jedis;

/**
 * Created by dell on 2017/1/20.
 */
public class RedisTest
{
    public static void main(String[] args)
    {
        Jedis jedis = new Jedis("localhost", 6379);
        long start = System.currentTimeMillis();
        jedis.select(2);
        String hkey_categry[] = new String []{"hkey_categry1", "hkey_categ2", "key_hash_categ3"};
        for(int i=0; i<1_000; i++){
            Long isSuccess = jedis.hset(hkey_categry[i%hkey_categry.length] + i, hkey_categry[i%hkey_categry.length], String.valueOf(i));
            if(isSuccess==1){
                System.out.println(String.format("key->%s, field->%s, value->%s", hkey_categry[i%hkey_categry.length], hkey_categry[i%hkey_categry.length] + i, String.valueOf(i)));
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("consume milli seconds --> " + (end - start));
    }
}
