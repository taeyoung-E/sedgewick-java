package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,7,1,75,2,5,8};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++)
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] < arr[j + 1])
                    swap(arr,j,j+1);
            }
    }
}
