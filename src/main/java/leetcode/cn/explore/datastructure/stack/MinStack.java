package leetcode.cn.explore.datastructure.stack;


import java.util.Stack;

/**
 * edited by AndersonKim
 * at 2019/2/12
 */
public class MinStack {
    //入栈的所有元素
    private Stack<Integer> s1 = new Stack<>();
    //入栈以来所有的最小值
    private Stack<Integer> s2 = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {}

    public void push(int x) {
        s1.push(x);
        //peek类似pop，前者不删除栈顶元素，后者删除栈顶元素
        if (s2.isEmpty() || s2.peek() >= x) s2.push(x);
    }

    //需要注意的是出栈是当前栈的最小元素的时候如何确定最小元素
    public void pop() {
        // Cannot write like the following:
        // if (s2.peek() == s1.peek()) s2.pop();
        // s1.pop();
        int x = s1.pop();
        if (s2.peek() == x) s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }
}
