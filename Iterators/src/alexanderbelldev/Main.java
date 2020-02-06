package alexanderbelldev;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        // for each example

        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(i);
        }

        //traverse with iterator
        Iterator<Integer> iterator = integerList.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println("Iterator value:: " + i);
        }
        /* traverse with enhanced for
        only iterator will allow collection to be modified during iteration */
        for (Integer i : integerList) {
            System.out.println("Iterator value:: " + i);
        }

        //example of modifying collection

        for (Integer i : integerList) {
            System.out.println(i);
       //     integerList.remove(i); // throws exception
        }

        Iterator<Integer> it = integerList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            it.remove(); // valid here
        }

    }

}
