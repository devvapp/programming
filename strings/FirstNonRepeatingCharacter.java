
import java.lang.Character;
import java.util.Map;
import java.util.LinkedHashMap;
import java.lang.Integer;


/**
 * FirstNonRepeatingCharacter
 */
public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        new FirstNonRepeatingCharacter().printFirstNonRepeatingCharacter("geeksforgeeks");
    }

    public void printFirstNonRepeatingCharacter(String str){

        Map<Character, Integer> countMap = new LinkedHashMap<Character, Integer>();

        for(int i = 0; i<str.length(); i++){
            Character ch = str.charAt(i);
            if(countMap.get(ch) != null){
                countMap.remove(ch);
            } else{
                countMap.put(ch, 1);
            }
        }

        char result = (char)(countMap.size() == 0 ? -1 : countMap.entrySet().iterator().next().getKey());

        System.out.println(result);
    }
}