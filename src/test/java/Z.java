/**
 * http://colobu.com/2014/10/28/secrets-of-java-8-functional-interface/
 * Created by dell on 2017/1/10.
 */
public class Z {
    public static void main(String[] args) {
//        Object o = (I & J) () -> {};
    }
}
interface I {
    void foo();
}
//@FunctionalInterface
interface J {
    void foo();
    void bar();
}