package designpattern;

/**
 * Created by feng on 2017/5/8.
 */
public class SingletonSample
{
    private static SingletonSample singletonSample;

    static {
        singletonSample = new SingletonSample();
    }

    public static synchronized SingletonSample getSingletonSample(){
        return singletonSample;
    }

    private SingletonSample(){
    }

    public static void main(String[] args)
    {
        System.out.println(getSingletonSample());
        System.out.println(getSingletonSample());
        System.out.println(getSingletonSample());
        System.out.println(getSingletonSample());
        System.out.println(getSingletonSample());
    }
}
