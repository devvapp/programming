public class ArrayRotation{


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};

        ArrayRotation ar = new ArrayRotation();
        ar.rotateArray(arr, 3);
        ar.printArray(arr);

        int[] arr2 = {1,2,3,4,5,6,7,8,9,10,11,12};
        ar.leftRotate(arr2, 2);
        ar.printArray(arr2);
    }
    
    /**
     * Print array elements
     */
    public void printArray(int[] arr){
    	for(int i=0; i<arr.length; i++){
    		System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int gcd(int a, int b){
        if(b==0){
            return a;
        } else {
            return gcd(b, a%b);
        }
    }

    /**
     * Rotate an array using gcd
     */
    public void rotateArray(int[] arr, int d){

        int n = arr.length;
        if(n<2){
            return;
        }
        int gcd = gcd(n, d);

        for(int i=0; i<gcd; i++){
            int temp = arr[i];
            int j = i;

            while(true){
                int k = j+d;
                if(k<n){
                    arr[j]=arr[k];
                    j=k;
                } else if (k>=n){
                    arr[j]=temp;
                    break;
                }
            }

        }
    }

    /**
     * For arr[] = [1, 2, 3, 4, 5, 6, 7], d =2 and n = 7
     * A = [1, 2] and B = [3, 4, 5, 6, 7]
     * Reverse A, we get ArB = [2, 1, 3, 4, 5, 6, 7]
     * Reverse B, we get ArBr = [2, 1, 7, 6, 5, 4, 3]
     * Reverse all, we get (ArBr)r = [3, 4, 5, 6, 7, 1, 2]
     */
    public void leftRotate(int arr[], int d)
    {
        int n = arr.length;
        reverseArray(arr, 0, d-1);
        reverseArray(arr, d, n-1);
        reverseArray(arr, 0, n-1);
    }
    
    public void reverseArray(int arr[], int start, int end)
    {
        int temp;
        while (start < end)
        {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}