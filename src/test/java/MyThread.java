/**
 * Created by feng on 2017/5/22.
 */
public class MyThread extends Thread
{
    private String value1;
    private String value2;

    public void run()
    {
        value1 = "通过成员变量返回数据";
        value2 = "通过成员方法返回数据";
    }
    public static void main(String[] args) throws Exception
    {
//        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        MyThread thread = new MyThread();
        thread.start();
        thread.join(); // 用于子线程执行完成才返回
        /*while(thread.value1==null || thread.value2==null){
            System.out.println("Thread.sleep(100)");
            Thread.sleep(100);
        }*/
        System.out.println("value1:" + thread.value1);
        System.out.println("value2:" + thread.value2);

    }
}