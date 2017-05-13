package chapter_1;

import java.util.Stack;

/**
 * 
 * @author ldj
 * @time 2017年5月13日 下午9:46:32
 * @version 1.0
 * @description 仅用递归函数和栈操作逆序一个栈
 */

public class Problem_03_ReverseStackUsingRecursive {

	/**
	 * 
	 * @param stack
	 * @return
	 * @Description: 用递归获得最后一个元素
	 */
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();

		if (stack.isEmpty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}

	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}

		/**
		 * 每次获得最后一个元素后，栈的大小都会减少1个
		 */
		int i = getAndRemoveLastElement(stack);
		/**
		 * 递归调用
		 */
		reverse(stack);
		stack.push(i);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		reverse(stack);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
