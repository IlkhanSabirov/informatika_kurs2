package collection;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(10);
        myArrayList.add(15);
        myArrayList.add(20);
        myArrayList.add(30);

        Iterable<Integer> iterable = myArrayList;
        Iterator<Integer> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Integer value : myArrayList) {
            System.out.println(value);
        }
    }
}
