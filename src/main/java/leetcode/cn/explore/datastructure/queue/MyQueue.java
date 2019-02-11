package leetcode.cn.explore.datastructure.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * edited by AndersonKim
 * at 2019/2/11
 */
public class MyQueue<T> {
    // store elements
    private List<T> data;
    // a pointer to indicate the start position
    private int p_start;
    public MyQueue() {
        data = new ArrayList<T>();
        p_start = 0;
    }
    /** Insert an element into the queue. Return true if the operation is successful. */
    public boolean enQueue(T x) {
        data.add(x);
        return true;
    };
    /** Delete an element from the queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        p_start++;
        return true;
    }
    /** Get the front item from the queue. */
    public T quitQueue() {
        return data.get(p_start);
    }
    /** Checks whether the queue is empty or not. */
    public boolean isEmpty() {
        return p_start >= data.size();
    }
}