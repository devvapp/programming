//package

import java.util.Arrays;

/**
 * Sorting Algorithms
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


    /**
     * Binary Insertion Sort - Mix of insertion sort and binary search. 
     * Find the location of the element to insert using binary search
     * and move one element to right and then insert the element.
     * 
     * In normal insertion, sort it takes O(i) (at ith iteration) in worst case. 
     * We can reduce it to O(logi) by using binary search.
     * 
     * Time complexity - Its still O(n*n)
     * Space complexity - O(1)
     * 
     */
    public void binaryInsertionSort(int[] arr){

        for(int i = 1; i<arr.length ; i++){
            int key = arr[i];

            // Find location to insert using binary search
            int j = Math.abs(Arrays.binarySearch(arr, 0, i, key)+1);
            
            //Shifting array to one location right
            System.arraycopy(arr, j, arr, j+1, i-j);

            //Placing element at its correct location
            arr[j] = key;
        }
    }

    /**
     * Quick sort - Quick sort follows merge sorts divide and conquer method.
     * 
     * Use when you want to search an array fast without extra memory allocations, 
     * unlike merge sort which requires extra space and is useful in sorting linked list
     * 
     * Time complexity - O(nLogn)
     * Space complexity - O(1)
     */
    public void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    /**
     * Recursively method for quick sort
     */
    public void quickSort(int[] arr, int low, int high){
        if(low<high){
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    /**
     * 
     */
    public int partition(int[] arr, int low, int high){

        /*
            Pivot can be chose in following ways - 
            1. Pick first element as pivot.
            2. Pick last element as pivot
            3. Pick a random element as pivot.
            4. Pick median as pivot.

            Lets choose second option
        */
        int pivot = arr[high];
        
        int i = low - 1;

        for(int j=low; j<high ; j++){
            if(arr[j] <= pivot){
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // swap arr[i+1] and arr[high]
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    /**
     * Merge sort - Divide and conquer
     * 
     * Useful in sorting linked list
     * 
     * Time complexity - O(NlogN)
     * Space complexity - O(N)
     */
    public void mergeSort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    /**
     * Sort recursively and merge
     */
    public void sort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low+high)/2;

            //First sort and then merge
            sort(arr, low, mid);
            sort(arr, mid+1, high);

            merge(arr, low, mid, high);
        }
    }

    /**
     * Merge
     */
    public void merge(int[] arr, int low, int mid, int high){
        
        //First copy the elements from low to mid and mid+1 to high into a temp array

        int n1 = mid-low+1;
        int n2 = high-mid;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        //Copy elements to arr1 and arr2
        for(int i = 0; i<n1 ; i++){
            arr1[i] = arr[low+i];
        }
        for(int j = 0; j<n2 ; j++){
            arr2[j] = arr[mid+1+j];
        }

        int i = 0; 
        int j = 0;
        int k = low;

        //Now iterate both arrays
        while(i<n1 && j<n2){
            if(arr1[i]<=arr2[j]){
                arr[k]=arr1[i];
                i++;
            } else {
                arr[k]=arr2[j];
                j++;
            }
            k++;
        }

        //Copy left over elements from both
        while(i<n1){
            arr[k]=arr1[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=arr2[j];
            j++;
            k++;
        }

    }

    /**
     * Bubble sort - 
     * 
     * Time complexity - 
     * Space complexity - 
     */
    public void bubbleSort(int[] arr){
        
    }

    /**
     * Heap sort - 
     * 
     * Time complexity - 
     * Space complexity - 
     */
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