import java.util.Arrays;
import java.util.List;

/**
 * Created by giraffissimo on 06.11.2018.
 */
class Solution {
    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs.length == 1){
            return strs[0];
        }
        for(int i = 0; i < strs.length; i++){
            String checkResult = "";
            for(int j = i + 1; j <= strs.length - 1; j++) {
                checkResult = checkTwoWords(strs[i], strs[j]);
                if(!checkResult.isEmpty() && (result.isEmpty() || checkResult.length() <= result.length())){
                    result = checkResult;
                } else {
                    return checkResult.isEmpty() ? "" : result;
                }
            }
        }
        return result;
    }

    public static String checkTwoWords(String wordA, String wordB){
        String result = "";
        List<String> letters = Arrays.asList(wordA.split(""));
        int letterIndex = 0;
        for(String letter: letters) {
            if(wordB.startsWith(result + letter) && letterIndex <= wordB.length()) {
                result += letter;
            } else {
                break;
            }
            letterIndex++;
        }
        return result;
    }

    public static void main(String[] args) {
        //String[] array = {"dogy", "do", "racecar","car", "dogydjy", "racuecup", "dog"};
        //String[] array = {"flower", "flow", "flight"};
        String[] array = {"acc","aaa","aaba"};
        //String[] array = {"baab","bacb","b","cbc"};
        System.out.println(longestCommonPrefix(array));
    }
}