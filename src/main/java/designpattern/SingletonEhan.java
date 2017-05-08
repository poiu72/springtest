package designpattern;

/**
 * Created by feng on 2017/5/8.
 */
public class SingletonEhan
{
    private static final SingletonEhan singletonEhan = new SingletonEhan();
    private SingletonEhan(){}
    public static SingletonEhan getSingletonEhan(){
        return singletonEhan;
    }

    static class ThreadDemo implements Runnable{

        @Override public void run()
        {
            System.out.println(getSingletonEhan());
        }
    }

    public static void main(String[] args)
    {
        for(int i=0; i<10; i++){
            new ThreadDemo().run();
        }
    }

}
