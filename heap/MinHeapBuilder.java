//package

import java.lang.Integer;

/**
 * MinHeapBuilder - A complete Binary tree with minimum values at its root.
 */
public class MinHeapBuilder {

    private int[] heap;
    private int maxSize;
    private int heapSize;

    public MinHeapBuilder(int size){
        this.maxSize=size;
        this.heap = new int[size];
        this.heapSize = 0;
    }

    /**
     * Get the parent Index
     */
    public int getParentIndex(int index){
        return (index-1)/2;
    }

    /**
     * Get the left child index
     */
    public int getLeftChildIndex(int index){
        return (2*index+1);
    }

    /**
     * Get the right child index
     */
    public int getRightChildIndex(int index){
        return (2*index+2);
    }

    /**
     * This method will insert a key into the heap
     */
    public void insertKey(int key){
        if(heapSize==maxSize){
            System.out.println("Heap reached it maximum size limit, no more insertions possible. key - " + key);
            return;
        }
        int currentIndex = heapSize++;
        heap[currentIndex] = key;
        
        int parentIndex = getParentIndex(currentIndex);

        while(currentIndex != 0 && heap[parentIndex] > heap[currentIndex]){
            //Swap Parent and child
            int temp = heap[parentIndex];
            heap[parentIndex] = heap[currentIndex];
            heap[currentIndex] = temp;

            //Make current index to parent index
            currentIndex = parentIndex;
            parentIndex = getParentIndex(currentIndex);
        }


    }

    /**
     * Replace key at an index and heapify
     */
    public void replaceSmallerKeyAtIndex(int currentIndex, int newKey){

        if(heap[currentIndex] < newKey){
            System.out.println("Cannot replace "+heap[currentIndex]+" with "+ newKey + " as the value is higher");
            return ; 
        }
        heap[currentIndex] = newKey;

        int parentIndex = getParentIndex(currentIndex);

        while(currentIndex != 0 && heap[parentIndex] > heap[currentIndex]){
            //Swap Parent and child
            int temp = heap[parentIndex];
            heap[parentIndex] = heap[currentIndex];
            heap[currentIndex] = temp;

            //Make current index to parent index
            currentIndex = parentIndex;
            parentIndex = getParentIndex(currentIndex);
        }
    }

    /** 
     * This method will get the minimum value from the heap
     */
    public int getMin(){
        if(heapSize>0){
            return heap[0];
        }
        else return Integer.MAX_VALUE;
    }

    /**
     * This method will extract minimum value from the heap and heapify the leftout heap
     */
    public int extractMin(){
        if(heapSize<=0){
            return Integer.MAX_VALUE;
        }
        if(heapSize==1){
            return heap[heapSize--];
        }

        // Store the min value and replace the first index key with 
        // last index key and heapify to rearrange the heap.
        int minKey = heap[0];
        heap[0] = heap[heapSize-1];
        heapSize--;

        heapify(0);

        return minKey;
    }

    /**
     * This method will delete a key at index from the heap 
     */
    public void deleteKeyAtIndex(int index){
        replaceSmallerKeyAtIndex(index, Integer.MIN_VALUE);
        extractMin();
    }

    /**
     * This method will min heapify the sub tree when a root index is provided
     */
    public void heapify(int index){

        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        int minIndex = index;

        //Check to see whild child has the minimum key value than the parent key
        if(leftChildIndex < heapSize && heap[leftChildIndex] < heap[index]){
            minIndex = leftChildIndex;
        } else if (rightChildIndex < heapSize && heap[rightChildIndex] < heap[index]){
            minIndex = rightChildIndex;
        }

        if(minIndex!=index){
            //Swap Parent and minimum key child index
            int temp = heap[index];
            heap[index] = heap[minIndex];
            heap[minIndex] = temp;
            
            //Recursively call the heapify method again 
            heapify(minIndex);
        }
        
    }

    public void printHeap(){
        for(int i = 0 ; i < heapSize ; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
                

    public static void main(String[] args) {
        MinHeapBuilder minHeapBuilder = new MinHeapBuilder(8);
        
        minHeapBuilder.insertKey(1);
        minHeapBuilder.insertKey(3);
        minHeapBuilder.insertKey(6);
        minHeapBuilder.insertKey(5);
        minHeapBuilder.insertKey(9);
        minHeapBuilder.insertKey(8);
        minHeapBuilder.insertKey(4);
        minHeapBuilder.insertKey(7);
        minHeapBuilder.insertKey(0);
        minHeapBuilder.insertKey(2);
        System.out.println("After Inserting value");
        minHeapBuilder.printHeap();


        minHeapBuilder.deleteKeyAtIndex(1);
        System.out.println("After Deleting value at index");
        minHeapBuilder.printHeap();

        minHeapBuilder.insertKey(0);
        minHeapBuilder.insertKey(2);
        System.out.println("After Deleting value at index and then inserting");
        minHeapBuilder.printHeap();

        System.out.println("Minimum value in the heap - " + minHeapBuilder.getMin());
        System.out.println("Extracted Minimum value from the heap - " + minHeapBuilder.extractMin());
        System.out.println("After extracting minimum from the heap");
        minHeapBuilder.printHeap();


        minHeapBuilder.replaceSmallerKeyAtIndex(2, 0);
        System.out.println("After replacing a key at an index");
        minHeapBuilder.printHeap();

    }
    
}