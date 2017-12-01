//package

import java.util.Arrays;

/**
 * LevenshteinDistance
 * <a href="https://en.wikipedia.org/wiki/Levenshtein_distance">Levenshtein Distance WIKI</a>
 */
public class LevenshteinDistance {

    public static void main(String[] args) {
        System.out.println(calculateLevenshteinDistance("top", "shop"));

        System.out.println(levenshteinDistanceUsingMemoization("abcde", "agc"));
    }

    /**
     * Inefficient Solution as we are will be calculating the same strings mulitple times
     * 
     * Time complexity - exponential 
     */
    public static int calculateLevenshteinDistance(String x, String y){

        if(x==null || x.isEmpty()){
            if(y!=null){
                return y.length();
            }
            return 0;
        }
        if(y==null || y.isEmpty()){
            return x.length();
        }

        int cost = (x.charAt(0)==y.charAt(0) ? 0 :1);

        int substitutionCost = cost+calculateLevenshteinDistance(x.substring(1), y.substring(1));

        int insertionCost = calculateLevenshteinDistance(x.substring(1), y)+1;
        int deletionCost = calculateLevenshteinDistance(x, y.substring(1))+1;

        return min(substitutionCost, insertionCost, deletionCost);

    }
    public static int min(int... numbers){
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }

    /**
     * 
     * Using Iterative memoization is a better solution
     */
    public static int levenshteinDistanceUsingMemoization(String x, String y){

        if(x==null || x.isEmpty()){
            if(y!=null){
                return y.length();
            }
            return 0;
        }
        if(y==null || y.isEmpty()){
            return x.length();
        }

        int xsize = x.length();
        int ysize = y.length();

        int[][] arr = new int[xsize+1][ysize+1];
        for(int i=0; i<xsize ; i++){
            arr[i][0] = i;
        }
        for(int j=0; j<ysize ; j++){
            arr[0][j] = j;
        }

        for(int i=0;i<xsize;i++){
            for(int j=0; j<ysize ; j++){
                if(x.charAt(i)==y.charAt(j)){
                    //If both the characters are equal then copy the the current value into diagnol location
                    arr[i+1][j+1] = arr[i][j];
                } else{
                    int replace = arr[i][j]+1;
                    int insert = arr[i][j+1]+1;
                    int delete = arr[i+1][j]+1;

                    int min = insert<delete?insert:delete;
                    min = min<replace?min:replace;

                    arr[i+1][j+1] = min;
                }
            }
        }
        return arr[xsize][ysize];

    }

}