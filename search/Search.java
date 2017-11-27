//package

/**
 * Search algorithms
 */
public class Search {


    /**
     * LinearSearch - This will loop through all the elements in an array and return index when found
     * This will return -1 if not found.
     * 
     * Time complexity - O(n)
     * Space complexity - O(1)
     * 
     */
    public int linearSearch(int[] arr, int searchValue){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == searchValue){
                return i;
            }
        }
        return -1;
    }


    /**
     * Binary Search - Binary Search only works on sorted array
     * This will return -1 if not found.
     * 
     * Time complexity - O(logn)
     * Space complexity - O(1)
     * 
     */
    public int binarySearch(int[] arr, int low, int high, int searchValue){

        if(low<=high){
            int mid = (low+high)/2;

            if(searchValue<arr[mid]){
                return binarySearch(arr, low, mid-1, searchValue);
            } 
            if(searchValue > arr[mid]){
                return binarySearch(arr, mid+1, high, searchValue);
            }
            return mid;
        }
        return -1;
    }


    public static void main(String[] args) {

        Search search = new Search();

        int[] linearSearchArr = {21, 52, 83, 12, 6, 23, 38};
        System.out.println("Linear Search result index value for 52 -> " + search.linearSearch(linearSearchArr, 52));
        System.out.println("Linear Search result index value for 5 -> " + search.linearSearch(linearSearchArr, 5));


        int[] binarySearchArr = {2, 5, 8, 12, 16, 23, 38, 56, 91, 92};
        System.out.println("Binary Search result index value for 2 -> " + search.binarySearch(binarySearchArr, 0, binarySearchArr.length, 2));
        System.out.println("Binary Search result index value for 91 -> " + search.binarySearch(binarySearchArr, 0, binarySearchArr.length, 92));
        System.out.println("Binary Search result index value for 50 -> " + search.binarySearch(binarySearchArr, 0, binarySearchArr.length, 50));
    }
    
}