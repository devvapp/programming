import java.lang.Math;
import java.lang.Integer;

class MinimumDistance 
{
    int minDist(int arr[], int n, int x, int y) 
    {
        int i, j;
        int min_dist = Integer.MAX_VALUE;
        for (i = 0; i < n; i++) 
        {
            for (j = i + 1; j < n; j++) 
            {
                if ((x == arr[i] && y == arr[j]
                    || y == arr[i] && x == arr[j])
                    && min_dist > Math.abs(i - j)) 
                    min_dist = Math.abs(i - j);
            }
        }
        return min_dist;
    }


    /**
     * Finding minimum distance between x and y.
     * Considering the array size will always be more than 1
     */
    public int minimumDistance(int arr[], int n, int x, int y){
        int si = 0;
        int ei = si-1;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i<n; i++){
            //We can separate below loop
            if(arr[i]==x){
                si = i;
                int k = si+1;
                while(k<n){
                    if(arr[k] == x){
                        si=k;
                    } else if (arr[k] == y){
                        ei=k;
                        min = Math.min(min, ei-si);
                        si=k;
                        k++;
                        break;
                    }
                    k++;
                }
                i=k;
            } else if(arr[i]==y){
                si = i;
                int k = si+1;
                while(k<n){
                    if(arr[k] == y){
                        si=k;
                    } else if (arr[k] == x){
                        ei=k;
                        min = Math.min(min, ei-si);
                        si=k;
                        k++;
                        break;
                    }
                    k++;
                }
                i=k;
            }
        }
        return min;
    }
 
    public static void main(String[] args) 
    {
        MinimumDistance min = new MinimumDistance();
        int arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        int n = arr.length;
        int x = 3;
        int y = 6;
 
        System.out.println("Minimum distance between " + x + " and " + y 
                + " is " + min.minDist(arr, n, x, y));

        System.out.println("Minimum distance between " + x + " and " + y 
                + " is " + min.minimumDistance(arr, n, x, y));
    }
}