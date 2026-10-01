package sorting;

//Basically the idea of using two pointer to flush out both array when it's sorted

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,7,1,75,2,5,8,10,6,2,7,8,2,463,6809,13,7};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void mergeSort(int[] arr){
        if(arr.length == 1)
            return;
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for(int i = 0; i < mid; i++){ //Left arr copy
            left[i] = arr[i];
        }

        for(int j = mid; j < arr.length; j++){//Right arr copy
            right[j - mid] = arr[j];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left,right,arr);
    }

    public static void merge(int[] left, int[] right, int[] arr){
        int leftP = 0, rightP = 0, originP = 0;
        while(leftP < left.length && rightP < right.length){
            if(left[leftP] < right[rightP]){
                arr[originP++] = left[leftP++];
            }
            else{
                arr[originP++] = right[rightP++];
            }
        }

        while(leftP < left.length){
                arr[originP++] = left[leftP++];
        }

        while(rightP < right.length){
                arr[originP++] = right[rightP++];
            }
    }
}
