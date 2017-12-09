//package


/**
 * PrintMatrixSpiral
 */
public class PrintMatrixSpiral {

    

    public static void main(String[] args) {
        int[][] arr = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9,  10, 11, 12}
            //,{13, 14, 15, 16}
           };

           PrintMatrixSpiral pms = new PrintMatrixSpiral();
           pms.printSpiral(arr);
    }


    /**
     * Print matrix in spiral form 
     * Time complexity - O(n)
     */
    public void printSpiral(int[][] arr){

        int n = arr.length;
        int m = arr[0].length;

        int x = 0;
        int y = 0;

        while(x<=n/2 && y<m-x){

            int i = x;
            int j = i;
            while(j<m-1-x){
                System.out.printf("%4d", arr[i][j]);
                j++;
            }
            while(i<n-1-y){
                System.out.printf("%4d", arr[i][j]);
                i++;
            }
            while(j>x){
                System.out.printf("%4d", arr[i][j]);
                j--;
            }
            while(i>y){
                System.out.printf("%4d", arr[i][j]);
                i--;
            }
            x++;
            y++;
        }
        
        System.out.println();
    }

}