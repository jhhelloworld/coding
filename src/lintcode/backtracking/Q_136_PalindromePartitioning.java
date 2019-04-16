package lintcode.backtracking;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.List;

/**
 * jh
 * 2019年03月15日  10：58
 * 给定一个字符串s，将s分割成一些子串，使每个子串都是回文串。
 * 返回s所有可能的回文串分割方案。
 * 给出 s = "aab"，返回
 * [
 *   ["aa", "b"],
 *   ["a", "a", "b"]
 * ]
 */
public class Q_136_PalindromePartitioning {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>>  result = new ArrayList<>();
        List<String> allList = new ArrayList<>();




        return null;



    }


    public void dfs(String s ,int index,List<String> subset,List<List<String>> result){
        if(index == s.length()){
            result.add(new ArrayList<>(subset));
            return;
        }





    }


    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        String s = new String("he");
        System.out.println(s);
    }


}






















