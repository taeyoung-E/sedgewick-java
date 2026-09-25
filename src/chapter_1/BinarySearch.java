package chapter_1;

public class BinarySearch {
    public static int binarySedgewick(int key,int[] arr){ //Returns the index
        int low = 0, high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(key == arr[mid])
                return mid;
            else if(key < arr[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
