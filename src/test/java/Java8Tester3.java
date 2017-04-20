import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by dell on 2017/1/10.
 */
public class Java8Tester3
{
    public static void main(String[] args)
    {
//构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例
        final Car car = Car.create( Car::new );
        final List< Car > cars = Arrays.asList(car);
        System.out.println(car);
//静态方法引用：它的语法是Class::static_method，实例
        cars.forEach(Car::collide);
//特定类的任意对象的方法引用：它的语法是Class::method实例
        cars.forEach( Car::repair );
//特定对象的方法引用：它的语法是instance::method实例
        final Car police = Car.create( Car::new );
        cars.forEach( police::follow );

        PrintStream out = System.out;
        System.out.println(out);
        List names = new ArrayList();
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
        names.forEach(out::println);
    }

    public static class Car {
        public static Car create( final Supplier< Car > supplier ) {
            return supplier.get();
        }

        public static void collide( final Car car ) {
            System.out.println( "Collided " + car.toString() );
        }

        public void follow( final Car another ) {
            System.out.println( "Following the " + another.toString() );
        }

        public void repair() {
            System.out.println( "Repaired " + this.toString() );
        }
    }
}

