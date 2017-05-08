package designpattern;

import static designpattern.SingletonSample2.getSingletonSample;

/**
 * Created by feng on 2017/5/8.
 */
public class SingletonSample2
{
    private static SingletonSample2 singletonSample;


    public static synchronized SingletonSample2 getSingletonSample(){
        if(singletonSample == null){
            singletonSample = new SingletonSample2();
        }
        return singletonSample;
    }

    public static void main(String[] args)
    {
        for(int i=0; i<10; i++){
            ThreadDemo2 threadDemo = new ThreadDemo2();
            threadDemo.run();
        }
    }
}

class ThreadDemo2 implements Runnable{

    @Override public void run()
    {
        System.out.println(getSingletonSample());
    }
}