import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.lang.Character;

/**
 * AllPermutationsFromAPhoneNumber
 */
public class AllPermutationsFromAPhoneNumber {

    String[] alphaArr = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {

        String num = "234";

        List<String> result = new ArrayList<>();
        char[] data = new char[num.length()];
        new AllPermutationsFromAPhoneNumber().printAllPermutationsFromAPhoneNumber(num.toCharArray(), 0, data, num.length());

    }

    public void printAllPermutationsFromAPhoneNumber(char[] number, int curr_digit, char[] output, int numberSize){

        if(curr_digit == numberSize){
            System.out.println(output);
            return;
        }

        int index = Character.getNumericValue(number[curr_digit]);
        for(int i =0; i<alphaArr[index].length() ; i++){
            
            output[curr_digit] = alphaArr[index].charAt(i);
            printAllPermutationsFromAPhoneNumber(number, curr_digit+1, output, numberSize);

            if(number[curr_digit] == 0 || number[curr_digit] == 1 ){
                return;
            }

        }
    }

}