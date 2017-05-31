import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by feng on 2017/5/22.
 */
public class CallableTest
{
    public static void main(String[] args)
            throws ExecutionException, InterruptedException
    {
        MyCallerble myCallerble1 = new MyCallerble("A", 5000);
        MyCallerble myCallerble2 = new MyCallerble("B", 2000);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        System.out.println(new Date());
        Future future1 = executorService.submit(myCallerble1);
        Future future2 = executorService.submit(myCallerble2);

        System.out.println("future1---->" + String.valueOf(future1.get()));
        System.out.println("future2---->" + future2.get());

        executorService.shutdown();
    }

    static class MyCallerble implements Callable{
        private String oid;
        private long sleepMillis;

        public MyCallerble(String oid, long sleepMillis){
            this.oid = oid;
            this.sleepMillis = sleepMillis;
        }

        @Override public String call()
                throws Exception
        {
            Thread.sleep(sleepMillis);
            System.out.println(new Date());
            return oid + "任务返回值";
        }
    }
}
