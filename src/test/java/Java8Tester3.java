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
//���������ã������﷨��Class::new�����߸�һ���Class< T >::newʵ��
        final Car car = Car.create( Car::new );
        final List< Car > cars = Arrays.asList(car);
        System.out.println(car);
//��̬�������ã������﷨��Class::static_method��ʵ��
        cars.forEach(Car::collide);
//�ض�����������ķ������ã������﷨��Class::methodʵ��
        cars.forEach( Car::repair );
//�ض�����ķ������ã������﷨��instance::methodʵ��
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

