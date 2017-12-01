//package

import java.lang.Math;

/**
 * OneEditDistance
 */
public class OneEditDistance {


    public static boolean isOneEditDistance(String x, String y){
        
        if(x==null && y == null){
            return false;
        }

        int xsize = x.length();
        int ysize = y.length();

        //If the lengths vary more than one return false;
        if(Math.abs(xsize-ysize)>1){
            return false;
        }

        int i=0;
        int j=0;
        int count=0;
        while(i<xsize && j<ysize){

            //If both the characters are same them move forward
            if(x.charAt(i)==y.charAt(j)){
                i++;
                j++;
            }else{
                count++;
                if(count>1){
                    return false;
                }

                if(xsize>ysize){
                    i++;
                } else if(xsize<ysize){
                    j++;
                } else{
                    i++;
                    j++;
                }
            }
        }

        if(i<xsize || j<ysize){
            return false;
        }
        if(count == 1){
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(isOneEditDistance("abcd", "acc"));
        System.out.println(isOneEditDistance("abcc", "acc"));
    }
    
}