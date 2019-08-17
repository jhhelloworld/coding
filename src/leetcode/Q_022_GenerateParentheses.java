package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * jh
 * 2019年08月16日  02：10
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */
public class Q_022_GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n<1){
            return result;
        }
        process(result,new StringBuilder(),n,0,0);
        return result;


    }

    public static void process(List<String> result ,StringBuilder sb,int n,int left,int right){
        if(right == n){
            result.add(sb.toString());
            return;
        }
        if(left<n){
            sb.append('(');
            process(result,sb,n,left+1,right);
            sb.delete(sb.length()-1,sb.length());

        }
        if(right<left){
            sb.append(')');
            process(result,sb,n,left,right+1);
            sb.delete(sb.length()-1,sb.length());
        }
    }

    public static void main(String[] args) {
        List<String> result =generateParenthesis(3);
        System.out.println();
    }

}