/**
 * Created by dell on 2017/1/10.
 */
public class Java8Tester
{
    public static void main(String[] args)
    {
        /*Java8Tester java8Tester = new Java8Tester();
        MathOperation<Integer> addOperation = (Integer a, Integer b) -> (a + b);
        MathOperation<Integer> subtraction = (a, b) -> a-b;
        System.out.println(java8Tester.operate(1, 2, addOperation));
        System.out.println(java8Tester.operate(1, 2, subtraction));*/
        System.out.println((Integer)129==(Integer)129);
    }

    interface MathOperation<T> {
        int operation(T a, T b);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
