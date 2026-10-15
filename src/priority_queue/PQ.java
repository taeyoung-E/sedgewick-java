package priority_queue;

//Priority Queue with array implementation, Min Queue implementation, 0 indexed

public class PQ {
    private int[] priorityQueue;
    private int size;

    public PQ(int containerSize){
        priorityQueue = new int[containerSize];
        size = 0;
    }

    public void swap(int[] arr,int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public void insert(int value){
        if(size == priorityQueue.length){
            System.out.println("The PQ is full");
            return;
        }
        priorityQueue[size++] = value;
        heapifyUp();
    }

    public int poll(){
        if(size == 0){
            System.out.println("Nothing to take out");
            return -1;
        }
        int value = priorityQueue[0];
        heapifyDown();
        return value;
    }


    private void heapifyDown(){
        priorityQueue[0] = priorityQueue[size - 1];
        size--;

        int currentIdx = 0;
        while(currentIdx * 2 + 1 < size){
            int leftIdx = 2 * currentIdx + 1;
            int rightIdx = 2 * currentIdx + 2;

            int smallerChildIdx = leftIdx;

            if(rightIdx < size && priorityQueue[rightIdx] < priorityQueue[leftIdx]){
                smallerChildIdx = rightIdx;
            }

            if(priorityQueue[currentIdx] > priorityQueue[smallerChildIdx]){
                swap(priorityQueue,currentIdx,smallerChildIdx);
                currentIdx = smallerChildIdx;
            }
            else{
                break;
            }

        }
    }

    private void heapifyUp(){
        int currentIdx = size - 1;

        while(currentIdx > 0){
            int parentIdx = (currentIdx - 1) / 2;
            if(priorityQueue[currentIdx] < priorityQueue[parentIdx]){
                swap(priorityQueue,currentIdx,parentIdx);
                currentIdx = parentIdx;
                continue;
            }
            else{
                break;
            }
        }
    }
}
