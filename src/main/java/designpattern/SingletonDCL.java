package designpattern;

import static designpattern.SingletonDCL.getSingletonDCL;

/**
 * Created by feng on 2017/5/8.
 */
public class SingletonDCL
{
    private static volatile SingletonDCL singletonDCL;

    private SingletonDCL(){}

    public static SingletonDCL getSingletonDCL(){
        if(singletonDCL == null){
            synchronized (SingletonDCL.class){
                if (singletonDCL == null){
                    singletonDCL = new SingletonDCL();
                }
            }
        }
        return singletonDCL;
    }

    public static void main(String[] args)
    {
        for(int i=0; i<10; i++){
            new ThreadDemo3().run();
        }
    }
}


class ThreadDemo3 implements Runnable{

    @Override public void run()
    {
        System.out.println(getSingletonDCL());
    }
}
