import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class SlidingWindowMaximum {

    /**
     * 性能拉胯版   每次移除都可能需要重新计算最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        int maxInQueue = Integer.MIN_VALUE;
        // 队列内最大值数量
        int maxNum = 1;
        int pos = 0;

        // 初始化 使当前窗口的值进入队列
        int i = 0;
        while (i < k) {
            int current = nums[i++];
            if (maxInQueue < current) {
                maxInQueue = current;
                // 重置最大值数为1
                maxNum = 1;
            } else if (maxInQueue == current) {
                maxNum++;
            }
        }
        // 保存第一个窗口的值
        res[pos++] = maxInQueue;

        // 从i=k开始循环
        for (; i < nums.length; i++) {
            int current = nums[i];
            // 移除元素为当前窗口起始位置前一位
            int out = nums[pos - 1];
            // 此时窗口已满  开始滑动  每次需要移除窗口第一个元素
            if (current > maxInQueue) {
                maxInQueue = current;
                maxNum = 1;
            } else if (current == maxInQueue && out != maxInQueue) {
                // 新进入一个最大值且退出的不是最大值时 最大值数量增加
                maxNum++;
            } else {
                if (out == maxInQueue) {
                    // 移除一个最大值
                    maxNum--;
                }
                if (maxNum == 0) {
                    // 最大值已完全移除  重新计算最大值
                    // 重置最大值
                    maxInQueue = Integer.MIN_VALUE;
                    int tempPos = pos;
                    while (tempPos < pos + k) {
                        int tempVal = nums[tempPos++];
                        if (tempVal > maxInQueue) {
                            maxInQueue = tempVal;
                            maxNum = 1;
                        } else if (maxInQueue == tempVal) {
                            maxNum++;
                        }
                    }
                }
            }
            res[pos++] = maxInQueue;
        }
        return res;
    }

    /**
     * 利用优先队列 maxHeap
     */
    public int[] maxSlidingWindowV2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((Pair p1, Pair p2) -> p2.value - p1.value);
        for (int i = 0; i < k; ++i) {
            maxHeap.offer(new Pair(nums[i], i));
        }
        int[] ans = new int[n - k + 1];
        ans[0] = maxHeap.peek().value;
        for (int i = k; i < n; ++i) {
            maxHeap.offer(new Pair(nums[i], i));
            while (maxHeap.peek().index <= i - k) {
                maxHeap.poll();
            }
            ans[i - k + 1] = maxHeap.peek().value;
        }
        return ans;
    }


    /**
     * 使用双端队列
     */
    public int[] maxSlidingWindowV3(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[n - k + 1];

        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                // 当新进入队列的值大于上一个则移除上一个的下标   保证队列按照倒序排列
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                // 当新进入队列的值大于上一个则移除上一个的下标   保证队列第一个时当前最大值
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                // 当最大值的下标识超出窗口范围  移除
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}

class Pair {
    public int value;
    public int index;

    public Pair() {

    }

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
