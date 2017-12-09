//package


/**
 * MatrixRotation
 */
public class MatrixRotation {

    
    public static void main(String[] args) {
        
        int[][] arr = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9,  10, 11, 12},
            {13, 14, 15, 16}
           };

           MatrixRotation mr = new MatrixRotation();
           mr.printArray(arr);

           //int[][] output = mr.rotateNxNMatrixBy90ClockwiseNewArray(arr);
           //mr.printArray(output, output.length);


           //mr.rotateNxNMatrixBy90ClockwiseInplaceSwapAndTranspose(arr);
           //mr.printArray(arr);
           //mr.rotateNxNMatrixBy90AntiClockwiseInplaceTransposeAndSwap(arr);
           //mr.printArray(arr);

           //mr.rotateNxNMatrixBy180(arr);
           //mr.printArray(arr);

           mr.rotateNxNMatrixBy90ClockwiseInplaceSwap(arr);
           mr.printArray(arr);
    }

    public void printArray(int[][] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++ ){
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * This method will rotate a matrix using extra memory.
     * 
     * Time complexity O(nxn)
     * 
     */
    public int[][] rotateNxNMatrixBy90ClockwiseNewArray(int[][] arr){
        int n = arr.length;
        int[][] output = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++ ){
                output[j][n-1-i] = arr[i][j];
            }
        }
        return output;
    }

    /**
     * This method will rotate a NxN matrix 90 degrees in clock wise 
     */
    public void rotateNxNMatrixBy90ClockwiseInplaceSwapAndTranspose(int[][] arr){
        int n = arr.length;
        swapInMiddle(arr);
        transpose(arr);
    }


    /**
     * This method will rotate a NxN matrix 90 degrees in anti clock wise 
     */
    public void rotateNxNMatrixBy90AntiClockwiseInplaceTransposeAndSwap(int[][] arr){
        int n = arr.length;
        transpose(arr);
        swapInMiddle(arr);
    }

    /**
     * This method performs a transpose of matrix
     */
    public void transpose(int[][] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++ ){
                swap(arr, i, j);
            }
        }
    }

    /**
     * swap method to swap elements 
     */
    public void swap(int[][] arr, int i, int j){
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    /**
     * This method will swap the array elements from middle of the array
     */
    public void swapInMiddle(int[][] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int k=0,j=n-1; k<j && k<n/2 ; j--,k++){
                int temp = arr[k][i];
                arr[k][i] = arr[j][i];
                arr[j][i] = temp;
            }
        }

    }

    /**
     * This method will always have 4 pointers and swap all the 4 pointers at a time
     */
    public void rotateNxNMatrixBy90ClockwiseInplaceSwap(int[][] arr){
        int n = arr.length;
        for(int i=0; i<n/2; i++){
            for(int j=i; j<n-i-1; j++ ){
                
                //Store all four cell values
                int a = arr[i][j];
                int b = arr[j][n-1-i];
                int c = arr[n-1-i][n-1-j];
                int d = arr[n-1-j][i];

                //Now swap each cell values;
                arr[j][n-1-i] = a;
                arr[n-1-i][n-1-j] = b;
                arr[n-1-j][i] = c;
                arr[i][j] = d;
            }
        }
    }


    /**
     * This method will rotate the array in 180 degrees
     * Time complexity - O(n*n)
     */
    public void rotateNxNMatrixBy180(int[][] arr){
        int n = arr.length;
        for(int i=0, j=n-1; i<n/2 && j>=0; i++, j--){
            for(int k=0; k<n; k++ ){
                int temp = arr[i][k];
                arr[i][k] = arr[j][n-k-1];
                arr[j][n-k-1] = temp;
            }
        }
    }

}