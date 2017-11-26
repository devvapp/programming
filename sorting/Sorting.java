//package


/**
 * InsertionSort
 */
public class Sorting {

    /**
     * Insertion Sort
     * Time complexity - O(n*n)
     * Space complexity - O(1)
     * 
     * Uses: Insertion sort is used when number of elements is small. 
     * It can also be useful when input array is almost sorted, 
     * only few elements are misplaced in complete big array.
     */
    public void insertionSort(int[] arr){
        
        //Loop from second element
        for(int i =1; i<arr.length ; i++){

            int key = arr[i];
            
            // Check from element before the key till the key is less
            // and then move each element one step forward
            int j = i-1;

            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            //Set the key value in the right place.
            arr[j+1] = key;
        }
    }


    public void binaryInsertionSort(int[] arr){

    }

    public void quickSort(int[] arr){
        
    }

    public void mergeSort(int[] arr){
        
    }

    public void bubbleSort(int[] arr){
        
    }

    public void heapSort(int[] arr){
        
    }

    /**
     * Print array method
     */
    public void printArray(int[] arr){
        for(int i =0; i< arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Sorting sorting = new Sorting();

        int[] insertionSortArr = new int[]{9,7,6,15,16,5,10,11};
        sorting.insertionSort(insertionSortArr);
        System.out.print("Insertion Sort -> ");
        sorting.printArray(insertionSortArr);

        int[] binaryInsertionSortArr = new int[]{9,7,6,15,16,5,10,11};
        sorting.binaryInsertionSort(binaryInsertionSortArr);
        System.out.print("Binary Insertion Sort -> ");
        sorting.printArray(binaryInsertionSortArr);

        int[] quickSortArr = new int[]{9,7,6,15,16,5,10,11};
        sorting.quickSort(quickSortArr);
        System.out.print("Quick Sort -> ");
        sorting.printArray(quickSortArr);
        


        int[] mergeSortArr = new int[]{9,7,6,15,16,5,10,11};
        sorting.mergeSort(mergeSortArr);
        System.out.print("Merge Sort -> ");
        sorting.printArray(mergeSortArr);


        int[] bubbleSortArr = new int[]{9,7,6,15,16,5,10,11};
        sorting.bubbleSort(bubbleSortArr);
        System.out.print("Bubble Sort -> ");
        sorting.printArray(bubbleSortArr);

        int[] heapSortArr = new int[]{9,7,6,15,16,5,10,11};
        sorting.heapSort(heapSortArr);
        System.out.print("Heap Sort -> ");
        sorting.printArray(heapSortArr);
    }
}