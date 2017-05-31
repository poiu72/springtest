package designpattern;

import static designpattern.SingletonDCL.getSingletonDCL;

/**
 * Created by feng on 2017/5/8.
 */
public class SingletonStaticNested
{
    private static class SingletionHolder {
        private static final SingletonStaticNested singletonStaticNested = new SingletonStaticNested();
    }

    private SingletonStaticNested(){}

    public static SingletonStaticNested getSingletonStaticNested(){
        return SingletionHolder.singletonStaticNested;
    }

    static class ThreadDemo3 implements Runnable{

        @Override public void run()
        {
            System.out.println(getSingletonStaticNested());
        }
    }


    public static void main(String[] args)
    {
        for(int i=0; i<20; i++){
            new ThreadDemo3().run();
        }
    }

}
