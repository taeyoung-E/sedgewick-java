package chapter_1;

public class BinaryMain {
    public static void main(String[] args){
        int[] sorted = {1,2,3,33,100};

        System.out.println(BinarySearch.binarySedgewick(100,sorted));
        System.out.println(BinarySearch.binarySedgewick(1000,sorted));
    }
}
