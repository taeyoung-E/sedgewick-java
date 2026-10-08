package sorting;

public class Review {
    public static void main(String[] args) {

    }

    public void selectionSort(int[] arr){ //Pivots to initial index and swaps eliminating search range
        for(int i = 0; i < arr.length - 1; i++){
            int minIdx = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIdx])
                    minIdx = j;
            }
            swap(arr,i,minIdx);
        }
    }

    public static void swap(int[] arr,int index1, int index2){ //Method for swapping
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public void bubbleSort(int[] arr){ // Outer acts as a restraint after sorting is complete, inner repeats swapping process
        for(int i = 0; i < arr.length - 1; i++)
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
    }

    public void insertionSort(int[] arr){ // Keeps swapping by gradually increasing the range
        for(int i = 1; i < arr.length; i++){
            int temp = i;
            while(temp > 0 && arr[temp] < arr[temp - 1]){
                swap(arr,temp,temp - 1);
                temp--;
            }
        }
    }

    public void mergeSort(int[] arr){ // Partitions the array until only 1 element is left
        if(arr.length <= 1)
            return;
        int mid = arr.length / 2;
        /*
        Easy way to think of size allocation for left and right is
        [0,mid) for left and [mid,size) so left.size = mid; , right.size = length - mid;
         */

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for(int i = 0; i < mid; i++){
            left[i] = arr[i];
        }

        for(int j = mid; j < arr.length; j++){
            right[j - mid] = arr[j];
        }

        mergeSort(left);
        mergeSort(right);
        merge(arr,left,right);
    }

    private void merge(int[] original, int[] left, int[] right){ // Adds back the partitioned arrays by using two pointer
        int index = 0, leftP = 0, rightP = 0;
        while(leftP < left.length && rightP < right.length){
            if(left[leftP] < right[rightP]){
                original[index++] = left[leftP++];
            }
            else{
                original[index++] = right[rightP++];
            }
        }

        while(leftP < left.length){
            original[index++] = left[leftP++];
        }

        while(rightP < right.length){
            original[index++] = right[rightP++];
        }
    }

    public void quickSort(int[] arr,int start,int end){
        if(start >= end)
            return;
        int pivot = partition(arr,start,end);
        quickSort(arr,start,pivot - 1);
        quickSort(arr,pivot + 1,end);
    }

    public int partition(int[] arr,int start,int end){
        int left = start, right = end - 1; // Value 1 before the pivot

        while(left < right)
        {
            if(arr[left] > arr[end])
            {
                while(arr[right] > arr[end] && right > left)
                {
                    right--;
                }
                Review.swap(arr,left,right);
            }
            if(left == right) break;
            left++;
        }
        if(arr[left] > arr[end])
        {
            Review.swap(arr,left,end);
            return left;
        }
        else
        {
            left++;
            Review.swap(arr,left,end);
            return left;
        }
    }
}
