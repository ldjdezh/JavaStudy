package chapter_1;

import java.util.Stack;

/**
 * 
 * @author ldj
 * @time 2017年5月13日 下午6:22:48
 * @version 1.0
 * @description 设计一个有getMin功能的栈
 */

public class Problem_01_GetMinStack {
	
	/**
	 * 
	 * @author ldj
	 * @time 2017年5月13日 下午9:10:38
	 * @version 1.0
	 * @description 静态内部类，只能引用外部类的静态变量
	 * 用两个栈，一个放变量，另一个放最小值
	 */
	public static class MyStack1 {
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;

		public MyStack1() {
			stackData = new Stack<Integer>();
			stackMin = new Stack<Integer>();
		}

		public void push(int newNum) {
			if (stackMin.isEmpty()) {
				stackMin.push(newNum);
			} else if (newNum <= getMin()) {
				stackMin.push(newNum);
			}

			stackData.push(newNum);
		}

		public int pop() {
			if (stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty");
			}

			int value = stackData.pop();

			if (value == getMin()) {
				stackMin.pop();
			}

			return value;
		}

		public int getMin() {
			if (stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty");
			}
			return stackMin.peek();
		}
	}

	public static class MyStack2 {
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;

		public MyStack2() {
			stackData = new Stack<Integer>();
			stackMin = new Stack<Integer>();
		}

		public void push(int newNum) {
			if (stackMin.isEmpty()) {
				stackMin.push(newNum);
			} else if (newNum < getMin()) {
				stackMin.push(newNum);
			} else {
				int newMin = stackMin.peek();
				stackMin.push(newMin);
			}

			stackData.push(newNum);
		}

		public int pop() {
			if (stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty");
			}

			stackMin.pop();

			return stackData.pop();
		}

		public int getMin() {
			if (stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty");
			}

			return stackMin.peek();
		}
	}

	public static void main(String[] args) {
		MyStack1 myStack1 = new MyStack1();

		myStack1.push(5);
		myStack1.push(4);
		myStack1.push(7);
		myStack1.push(1);
		myStack1.push(2);

		System.out.println(myStack1.getMin());

		System.out.println("--------------------");

		MyStack2 myStack2 = new MyStack2();

		myStack2.push(5);
		myStack2.push(4);
		myStack2.push(7);
		myStack2.push(1);
		myStack2.push(2);

		System.out.println(myStack2.getMin());

		myStack2.pop();
		myStack2.pop();
		System.out.println(myStack2.getMin());
	}
}
