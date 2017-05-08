package designpattern;

import static designpattern.SingletonSample1.getSingletonSample;

/**
 * Created by feng on 2017/5/8.
 */
public class SingletonSample1
{
    private static SingletonSample1 singletonSample = new SingletonSample1();


    public static synchronized SingletonSample1 getSingletonSample(){
        if(singletonSample == null){
            singletonSample = new SingletonSample1();
        }
        return singletonSample;
    }

    private SingletonSample1(){

    }


        public static void main(String[] args)
    {
        for(int i=0; i<10; i++){
            ThreadDemo threadDemo = new ThreadDemo();
            threadDemo.run();
        }
    }
}

class ThreadDemo implements Runnable{

    @Override public void run()
    {
        System.out.println(getSingletonSample());
    }
}
