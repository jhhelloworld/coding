package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * jh
 * 2019年05月10日  15：23
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */

public class Q_017_LetterCombinationsOfAPhoneNumber {
    public static String getMap(char number) {
        switch (number) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
             case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits == null || digits.length()==0){
            return result;
        }
        process(result,digits,0,new StringBuilder());
        return result;

    }

    private static void process(List<String> result,String digits,int index,StringBuilder sb){
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }
        char[] chars = getMap(digits.charAt(index)).toCharArray();
        for(char c:chars){
            sb.append(c);
            process(result,digits,index+1,sb);
            sb.delete(sb.length()-1,sb.length());
        }


    }

    public static void main(String[] args) {
        List<String> result = letterCombinations("23");
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(sb.delete(1,2).toString());
    }



}

































