import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ImplementStackUsingQueue {

    static class MyStack {

        /**
         * 使用两个队列实现先进后出
         */
        private Queue<Integer> q1, q2;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            // 初始化队列
            q1 = new ArrayBlockingQueue<>(100);
            q2 = new ArrayBlockingQueue<>(100);
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            if (q1.isEmpty()) {
                q1.add(x);
                while (!q2.isEmpty()) {
                    // 将另一个队列所有值移动到此队列  使得最后进入的元素位于队列第一个  实现先进后出
                    q1.add(q2.poll());
                }
            } else {
                // q2为空时
                q2.add(x);
                while (!q1.isEmpty()) {
                    // 将另一个队列所有值移动到此队列  使得最后进入的元素位于队列第一个  实现先进后出
                    q2.add(q1.poll());
                }
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (q1.isEmpty() && q2.isEmpty()) {
                return -1;
            }
            if (q1.isEmpty()) {
                return q2.poll();
            } else {
                return q1.poll();
            }
        }

        /**
         * Get the top element.
         */
        public int top() {
            if (q1.isEmpty() && q2.isEmpty()) {
                return -1;
            }
            int val = this.pop();
            this.push(val);
            return val;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

}
