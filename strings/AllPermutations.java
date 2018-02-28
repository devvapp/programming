
import java.util.Arrays;

/**
 * AllPermutations
 */
public class AllPermutations {

    public static void main(String[] args) {

        String str = "AB";
        char[] data = new char[2];
        new AllPermutations().printAllPermutations(str, data, 0);

    }

    public void printAllPermutations(String str, char[] data, int index){

        if(str == null){
            return;
        }
        int size = str.length();

        for(int i =0; i<size ; i++){
            data[index] = str.charAt(i);
            if(index==size-1){
                System.out.println(data);
            } else {
                printAllPermutations(str, data, index+1);
            }
        }
    }
}