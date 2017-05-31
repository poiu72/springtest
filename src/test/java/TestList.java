/**
 * Created by feng on 2017/5/29.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestList
{
    public static final int N = 50000000;

    public static List values;

    static {
        Integer vals[] = new Integer[N];
        Random r = new Random();

        for (int i = 0, currval = 0; i < N; i++) {
            vals[i] = new Integer(currval);
            currval += r.nextInt(100) + 1;
        }

        values = Arrays.asList(vals);
    }

    static long timeList(List lst)
    {
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            int index = Collections.binarySearch(lst, values.get(i));
            if (index != i)
                System.out.println("***错误***");
        }
        return System.currentTimeMillis() - start;
    }

    static long reverseList(List lst)
    {
        long start = System.currentTimeMillis();
        Collections.reverse(lst);
        return System.currentTimeMillis() - start;
    }

    public static void main(String args[])
    {
//        System.out.println("ArrayList消耗时间--" + timeList(new ArrayList(values)));
//        System.out.println("LinkedList消耗时间--" + timeList(new LinkedList(values)));

//     50000000   ArrayList reverse--57
//Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//        at java.util.LinkedList.addAll(LinkedList.java:424)
//        at java.util.LinkedList.addAll(LinkedList.java:387)
//        at java.util.LinkedList.<init>(LinkedList.java:119)
        System.out.println("ArrayList reverse--" + reverseList(new ArrayList(values)));
//        System.out.println("LinkedList reverse--" + reverseList(new LinkedList(values)));
    }
}
