package sorting;

import java.util.Arrays;

//Ascending Order Implementation
public class SelectionSort{
    public static void main(String[] args) {
        int[] arr = {3,7,1,75,2,5,8};
        System.out.println(Arrays.toString(arr));

        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int index = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[index]){
                    index = j;
                }
            }
            swap(arr,i,index);
        }
    }
}
