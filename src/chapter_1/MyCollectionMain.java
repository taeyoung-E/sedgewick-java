package chapter_1;

import java.util.Iterator;

public class MyCollectionMain {
    public static void main(String[] args) {
        MyCollection test = new MyCollection(5);
        test.addValue("Apple");
        test.addValue("Banana");
        test.addValue("Roma Tomato");
        test.addValue("Onion");
        test.addValue("Peach");

        for(String s : test){
            System.out.println(s);
        }
    }
}
