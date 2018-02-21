//package

/**
 * StringReverse
 */
public class StringReverse {

    public static void main(String[] args) {
        StringReverse sr = new StringReverse();   
        String str = "eeksforgeeks";
        int res = sr.secondMostOccuringCharacted(str); 
        System.out.println(res);
    }
    

    public int secondMostOccuringCharacted(String str){
        
        
        int[] count = new int[256];
        for(int i = 0; i< str.length(); i++){
            count[str.charAt(i)]++;
        }
        int first = 0;
        int second = first;
        for(int i =1 ; i< 256 ; i++){

            if(count[first]<count[i]){
                second = first;
                first = i;
            }
        }
        return second;
    }

}