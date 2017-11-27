//package

import java.util.Arrays;

/**
 * LevenshteinDistance
 */
public class LevenshteinDistance {

    public static void main(String[] args) {
        System.out.println(calculate("top", "shop"));
    }

    /**
     * <a href="https://en.wikipedia.org/wiki/Levenshtein_distance">Levenshtein Distance WIKI</a>
     * Inefficient Solution - Using Iterative memoization is a better solution refer wiki
     * Will implement other solution later.
     */
    public static int calculate(String x, String y){

        if(x.isEmpty()){
            return y.length();
        }
        if(y.isEmpty()){
            return x.length();
        }

        int cost = (x.charAt(0)==y.charAt(0) ? 0 :1);

        int substitutionCost = cost+calculate(x.substring(1), y.substring(1));

        int insertionCost = calculate(x.substring(1), y)+1;
        int deletionCost = calculate(x, y.substring(1))+1;

        return min(substitutionCost, insertionCost, deletionCost);

    }

    public static int min(int... numbers){
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }


}