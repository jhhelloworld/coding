package chapter_1_stackandqueue_self;

import jdk.nashorn.internal.runtime.regexp.joni.constants.TargetInfo;

import java.util.Stack;

/**
 * @author Jianghua
 * 2018年11月01日  16：27
 */
public class Problem_01_GetMinStack {
    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }
        public void push(int newNum) {
            stackData.push(newNum);
            if(stackMin.isEmpty()){
                stackMin.push(newNum);
            }else if(newNum<=this.getmin()){
                stackMin.push(newNum);
            }

        }

        public int pop() {
            if(this.stackData.isEmpty()){
                throw new RuntimeException();
            }
            int value = stackData.pop();
            if(value == getmin()){
                stackMin.pop();
            }
            return value;
        }

        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }

    }
}