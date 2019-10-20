package leetcode;

import java.util.Stack;

/**
 * jh
 * 2019年09月04日  22：55
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
public class Q_155_MinStack {
    /** initialize your data structure here. */

    private  Stack<Integer> data;
    private Stack<Integer> min;
    public Q_155_MinStack() {
        this.data = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int x) {
        //注意判空！！！
        if(data.isEmpty()){
            data.push(x);
            min.push(x);
        }else {
            if(x<min.peek()){
                min.push(x);
            }else {
                min.push(min.peek());
            }
            data.push(x);
        }

    }

    public void pop() {
        data.pop();
        min.pop();

    }

    public int top() {
        return data.peek();

    }

    public int getMin() {
        return min.peek();

    }
}