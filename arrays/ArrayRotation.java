public class ArrayRotation{


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};

        ArrayRotation ar = new ArrayRotation();
        ar.rotateArray(arr, 3);
        ar.printArray(arr);
    }
    
    /**
     * Print array elements
     */
    public void printArray(int[] arr){
    	for(int i=0; i<arr.length; i++){
    		System.out.print(arr[i] + " ");
    	}
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

}