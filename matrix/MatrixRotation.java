
/**
 * 
 */
public class MatrixRotation{


    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] arr1 = arr.clone();
        int[][] arr2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        MatrixRotation rotation = new MatrixRotation();
        //rotation.printMatrix(arr1);
        //rotation.printMatrix(rotation.rotateNxNMatrix90ReturningNewMatrix(arr1));
        //rotation.printMatrix(arr2);
        //rotation.printMatrix(rotation.rotateMxNMatrix90ReturningNewMatrix(arr2));

        //arr1 = arr.clone();
        //rotation.printMatrix(arr1);
        //rotation.rotate90AntiClockwiseInplace(arr1);
        //rotation.printMatrix(arr1);


        arr1 = arr.clone();
        rotation.printMatrix(arr1);
        rotation.rotate90ClockwiseInplace(arr1);
        rotation.printMatrix(arr1);
    }

    public void printMatrix(int[][] arr){
        for(int i =0; i<arr.length; i++){
            for(int j =0;j<arr[0].length; j++){
                System.out.printf("%5d",arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] rotateNxNMatrix90ReturningNewMatrix(int[][] arr){
        int[][] rot = new int[arr.length][arr[0].length];
        
        int n = arr.length;
        int ri = 0;
        int rj = n-1;

        int i = 0;
        int j = 0;

        while(i<n){
            while(j<n){
                rot[ri][rj] = arr[i][j];
                ri++;
                j++;
            }
            rj--;
            i++;
            j=0;
            ri=0;
        }
        return rot;
    }

    public int[][] rotateMxNMatrix90ReturningNewMatrix(int[][] arr){
        int[][] rot = new int[arr[0].length][arr.length];

        int n = arr.length;
        int m = arr[0].length;
        int ri = 0;
        int rj = n-1;

        int i = 0;
        int j = 0;

        while(i<n){
            while(j<m){
                rot[ri][rj] = arr[i][j];
                ri++;
                j++;
            }
            rj--;
            i++;
            j=0;
            ri=0;
        }
       
        return rot;
    }

    public void rotate90AntiClockwiseInplace(int[][] arr){
        int n = arr.length;

        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){

                int temp = arr[i][j];
                arr[i][j]=arr[j][n-i-1];
                arr[j][n-i-1]=arr[n-i-1][n-j-1];
                arr[n-i-1][n-j-1]=arr[n-j-1][i];
                arr[n-j-1][i] = temp;
            }
        }
    }

    public void rotate90ClockwiseInplace(int[][] arr){
        int n = arr.length;

        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){

                int a = arr[i][j];
                int b = arr[j][n-i-1];
                int c = arr[n-i-1][n-j-1];
                int d = arr[n-j-1][i];
                
                arr[j][n-i-1]=a;
                arr[n-i-1][n-j-1]=b;
                arr[n-j-1][i] = c;
                arr[i][j]=d;
                
            }
        }
    }

    public void rotate180Inplace(int[][] arr){
        int n = arr.length;
        for(int i=0; i<n/2; i++){
            for(int j=0; j<n; j++ ){
                int temp = arr[i][j];
                arr[i][j] = arr[n-i-1][n-j-1];
                arr[n-i-1][n-j-1] = temp;
            }
        }
    }

    public void rotateSpiralInplace(int[][] arr){
        int n = arr.length;
        int i = 0;
        int j = 1;

        while(true){

            int temp = arr[arr[i].length-1];
            while(j<n){
                arr[i][j]=arr[i][j-1];
                j++;
            }

            while(){
                
            }
            
        }

    }
    
}