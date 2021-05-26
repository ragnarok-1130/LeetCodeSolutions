import java.util.Stack;

public class ImplementQueueUsingStack {

    static class MyQueue {
        private Stack<Integer> s1, s2;

        /**
         * 是否已翻转
         */
        private boolean flag = false;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (flag) {
                // 已翻转时先翻转再入栈  保证入栈时顺序永远是反的
                if (s2.empty()) {
                    //
                    while (!s1.empty()) {
                        s2.add(s1.pop());
                    }
                    s2.add(x);
                } else {
                    while (!s2.empty()) {
                        s1.add(s2.pop());
                    }
                    s1.add(x);
                }
                flag = false;
            } else {
                if (s2.empty()) {
                    s1.add(x);
                } else {
                    s2.add(x);
                }
            }

        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (s1.empty() && s2.empty()) {
                return -1;
            }
            if (!flag) {
                // 未翻转则进行一次翻转
                if (s2.empty()) {
                    while (!s1.empty()) {
                        s2.add(s1.pop());
                    }
                } else {
                    while (!s2.empty()) {
                        s1.add(s2.pop());
                    }
                }
                flag = true;
            }
            return s1.empty() ? s2.pop() : s1.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (s1.empty() && s2.empty()) {
                return -1;
            }
            if (!flag) {
                // 未翻转则进行一次翻转
                if (s2.empty()) {
                    while (!s1.empty()) {
                        s2.add(s1.pop());
                    }
                } else {
                    while (!s2.empty()) {
                        s1.add(s2.pop());
                    }
                }
                flag = true;
            }
            int val;
            if (s1.empty()) {
                val = s2.pop();
                s2.push(val);
            } else {
                val = s1.pop();
                s1.push(val);
            }
            return val;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return s1.empty() && s2.empty();
        }
    }
}
