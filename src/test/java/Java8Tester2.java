import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by dell on 2017/1/10.
 */
public class Java8Tester2
{
    public static void main(String args[]){
       /* List names = new ArrayList<>();
        names.add("Google");
        names.add("Runoob");
        Consumer consumer = System.out::println;
        names.forEach(consumer);
        for(Object o: names){
            System.out.println(o);
        }

        Function function ;*/

    }

}

//http://colobu.com/2014/10/28/secrets-of-java-8-functional-interface/
//interface Foo<T> { void m(T arg); }
//interface Bar<T> { void m(T arg); }
//@FunctionalInterface
//interface FooBar<T> extends Foo, Bar<T> {}

//interface Foo { void m(String arg); }
//interface Bar<T> { void m(T arg); }
//interface FooBar<T> extends Foo, Bar<T> {}

//interface X { void m() throws IOException; }
//interface Y { void m() throws EOFException; }
//interface Z { void m() throws ClassNotFoundException; }
//@FunctionalInterface
//interface XY extends X, Y {}
//@FunctionalInterface
//interface XYZ extends X, Y, Z {}

//interface G1 {
//    <E extends Exception> Object m() throws E;
//}
//interface G2 {
//    <F extends Exception> String m() throws Exception;
//}
//@FunctionalInterface
//interface G extends G1, G2 {}


//interface I {
//    void foo();
//}
//interface J {
//    void foo();
//}
//public class Z {
//    public static void main(String[] args) {
//        Object o = (I & J)()->{};
//    }
//}

