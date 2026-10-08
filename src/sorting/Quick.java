package sorting;

import java.util.Arrays;
import java.util.Random;

public class Quick {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] test = new int[10];
        for(int i = 0; i < test.length; i++){
            test[i] = rand.nextInt(0,30);
        }
        System.out.println(Arrays.toString(test));
        quickSort(test,0,test.length - 1);

        System.out.println(Arrays.toString(test));

    }

    public static void quickSort(int[] arr,int start, int end){ //Using the end-value implementation
        if(start >= end)
            return;
        int pivot = partition(arr,start,end);

        quickSort(arr,start,pivot - 1);
        quickSort(arr,pivot + 1, end);
    }

    public static int partition(int[] arr,int start, int end){
        int left = start, right = end - 1;
        while(left < right){
            if(arr[left] > arr[end]){
                while(arr[right] > arr[end] && right > left){
                    --right;
                }
                Review.swap(arr,left,right);
            }
            if(left == right) break;
            left++;
        }
        if(arr[left] > arr[end]){
            Review.swap(arr,left,end);
        }
        else{
            left++;
            Review.swap(arr,left,end);
        }
        return left;
    }

    //Tomorrow, Review Quick
}
