package leetcode;


import javax.lang.model.element.NestingKind;
import java.util.Stack;

/**
 * jh
 * 2019年09月04日  20：03
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 */
public class Q_150_EvaluateReversePolishNotation {
    //思路：利用栈
    public int evalRPN(String[] tokens) {
        //第一次提交忘记
        if(tokens.length==1){
            return Integer.valueOf(tokens[0]);
        }
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for(int i = 0;i<tokens.length;i++ ){
            String s = tokens[i];
            if(!isSymble(s)){
                stack.push(Integer.valueOf(s));
            }else {
                int a = stack.pop();
                int b = stack.pop();
                //注意a,b的顺序
                result = jisuan(b,a,s);
                stack.push(result);
            }
        }
        return result;


    }



    public boolean isSymble(String s){
        if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")){
            return true;
        }
        return false;
    }

    public int jisuan(int a ,int b,String s){

        switch (s){
            case  "+":{
                return a+b;
            }
            case "-":{
                return a-b;
            }
            case "*":{
                return a*b;
            }
            case "/":{
                return a/b;
            }
        }
        return 0;
    }


    //更直观的代码

    public int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
            if(s.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }else if(s.equals("-")){
                stack.push(-stack.pop()+stack.pop());
            }else if(s.equals("*")){
                stack.push(stack.pop()*stack.pop());
            }else if(s.equals("/")){
                int a = stack.pop();
                stack.push(stack.pop()/a);
            }else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}



































