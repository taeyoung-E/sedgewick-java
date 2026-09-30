package sorting;

import java.util.Arrays;

public class InsertionSort { //Ascending Order
    public static void main(String[] args) {
        int[] arr = {3,7,1,75,2,5,8};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void swap(int[] arr,int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int curr = i;
            while(curr != 0 && arr[curr] < arr[curr - 1]){
                swap(arr,curr,curr - 1);
                curr--;
            }
        }
    }
}
