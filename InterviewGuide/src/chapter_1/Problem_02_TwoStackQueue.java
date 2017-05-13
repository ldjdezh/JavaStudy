package chapter_1;

import java.util.Stack;

/**
 * 
 * @author ldj
 * @time 2017年5月13日 下午9:32:22
 * @version 1.0
 * @description 用两个栈组成队列
 */

public class Problem_02_TwoStackQueue {
	public static class TwoStackQueue {
		Stack<Integer> stackPush;
		Stack<Integer> stackPop;

		public TwoStackQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}

		public void add(int pushInt) {
			stackPush.push(pushInt);
		}

		public int poll() {
			if (stackPop.isEmpty() && stackPush.isEmpty()) {
				throw new RuntimeException("Queue is empty");
			} else if (stackPop.isEmpty()) {
				while (!stackPush.isEmpty()) {
					stackPop.push(stackPush.pop());
				}
			}

			return stackPop.pop();
		}

		public int peek() {
			if (stackPop.isEmpty() && stackPush.isEmpty()) {
				throw new RuntimeException("Queue is empty");
			} else if (stackPop.isEmpty()) {
				while (!stackPush.isEmpty()) {
					stackPop.push(stackPush.pop());
				}
			}

			return stackPop.peek();
		}
	}

	public static void main(String[] args) {
		TwoStackQueue tsq = new TwoStackQueue();

		tsq.add(1);
		tsq.add(2);
		tsq.add(3);
		tsq.add(4);
		tsq.add(5);

		System.out.println(tsq.poll());
		System.out.println(tsq.poll());
		System.out.println(tsq.poll());
		System.out.println(tsq.poll());
		System.out.println(tsq.poll());
	}
}
