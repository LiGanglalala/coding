import java.util.ArrayList;
import java.util.Stack;

public class Stack$Queue {

    public static class Stack1 {
//        Object[] data = new Object[];

    }

    /**
     * 用栈记录最小值，在pop的时候判断如果等于栈顶就pop
     **/
    public static class Stack2 {
        Node data;
        Node minData;

        public Node pop() {
            Node temp = data;
            data = data.next;
            temp.next = null;
            return temp;
        }

        public void push(Node node) {
            if (minData == null || minData.data > node.data) {
                minData = node;
            }
            node.next = data;
            data = node;
        }

        public Node min() {
            return minData;
        }

        static class Node {
            int data;
            Node next;
        }
    }

    public static class Stack3 {
        private final static int SIZE = 5;
        ArrayList<Stack<Integer>> stacks = new ArrayList<>();

        public void push(int value) {
            Stack<Integer> stack = null;
            if (stacks.size() != 0) {
                stack = stacks.get(stacks.size() - 1);
            }
            if (stack == null || stack.size() == SIZE) {
                stack = new Stack<>();
                stacks.add(stack);
            }
            stack.push(value);
        }

        public int pop() {
            Stack<Integer> stack = null;
            if (stacks.size() != 0) {
                stack = stacks.get(stacks.size() - 1);
            }
            if (stack == null) {
                return -1;
            }
            int result = stack.pop();
            if (stack.size() == 0) {
                stacks.remove(stack);
            }
            return result;
        }

        public int popAt(int index) {
            if (index < 0 || index >= stacks.size()) {
                return -1;
            }
            Stack<Integer> stack = stacks.get(index);
            int result = stack.pop();
            if (stack.size() == 0) {
                stacks.remove(stack);
            }
            return result;
        }
    }

    /**
     * 递归。。。。。仔细想想仔细想想
     **/
    public static void stack4(Stack<Integer> stack1, Stack<Integer> stack2, Stack<Integer> stack3) {
        int n = stack1.size();
        temp1(n - 1, stack1, stack2, stack3);
        stack3.push(stack1.pop());
        temp1(n - 1, stack2, stack3, stack1);

    }

    public static void temp1(int n, Stack<Integer> stack1, Stack<Integer> stack2, Stack<Integer> buffer) {
        if (n == 1) {
            stack2.push(stack1.pop());
            return;
        }
        temp1(n- 1, stack1, buffer, stack2);
        stack2.push(stack1.pop());
        temp1(n- 1, buffer, stack2, stack1);
    }

    public static class Queue5 {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        void push(int value) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(value);
        }

        int pop() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    /**
     * 给一个栈排序，用到另一个栈和一个临时变量
     *
     * mergesort或者quicksort ????
     **/
    public static void stack6(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        int i = stack.pop();
        while (!stack.isEmpty()) {
            if (temp.isEmpty() || i > temp.peek()) {
                temp.push(i);
                i = stack.pop();
            } else {
                stack.push(temp.pop());
            }
        }
    }
}
