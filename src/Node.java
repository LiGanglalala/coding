import java.util.HashSet;

public class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    public static Node node11(Node node) {
        HashSet<Integer> set = new HashSet<>();
        Node result = node;
        while (node != null) {
            if (set.contains(node.data)) {
                if (node.next != null) {
                    node.next = node.next.next;
                }
            } else {
                set.add(node.data);
            }
            node = node.next;
        }
        return result;
    }

    public static Node node12(Node node, int k) {
        Node result = node;
        for (int i = 0; i < k; i++) {
            if (node == null) {
                return null;
            }
            node = node.next;
        }
        while (node != null) {
            node = node.next;
            result = result.next;
        }
        return result;
    }

    //注意删除尾结点是无解的
    public static void node13(Node node) {
        if (node != null && node.next != null) {
            node.data = node.next.data;
            node.next = node.next.next;
        }
    }

    public static Node node14(Node node, int x) {
        Node result = new Node(0);
        Node temp1 = result, temp2 = new Node(0);
        while (node != null) {
            if (node.data < x) {
                temp1.next = node;
                temp1 = temp1.next;
            } else {
                temp2.next = node;
                temp2 = temp2.next;
            }
            node = node.next;
        }
        temp1.next = temp2;
        return result.next;
    }

    //倒序的时候可以逐位相加，保留进位
    public static Node node15(Node node1, Node node2) {
        int num1 = 0;
        int i = 1;
        while (node1 != null) {
//            num1 = num1 * 10 + node1.data;
            num1 = num1 + node1.data * i;
            i = i * 10;
            node1 = node1.next;
        }
        int num2 = 0;
        //.....
        int sum = num1 + num2;
        Node result = new Node(sum % 10);
        Node temp = result;
        while (sum / 10 != 0) {
            sum = sum / 10;
            temp.next = new Node(sum);
            temp = temp.next;
        }
        Node pre = null;
        while (result.next != null) {
            Node t1 = result.next;
            Node t2 = result.next.next;
            result.next.next = result;
            result.next = pre;
            result = t2;
            pre = t1;


        }
        return result;
    }

    /**
     * 1.为什么快慢指针在有环链表一定相遇？
     *
     * 证明: 环长为n，起点从环外进入环节点需要m步，当慢指针走过k+m步，快指针走了z(k+m)
     * 求证 对任意给定的 m、n、z，存在k，使得
     * [(z-1)*(k+m)] mod n = 0
     * 令 (k+m) mod n = 0 则 k = n - m mod n
     *
     * 2.为什么相遇点和起点同时移动，再次相遇点是环的起点？
     *
     * 证明: 起点从环外进入环节点需要m步，相遇点距离环起点为 n - k = m mode n
     * (m mode n - m) mod n = 0，即 m mod n = m mod n
     *
     **/
    public static Node node16(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node  head = node;
        Node node1 = head.next, node2 = head.next.next;
        while (node2 != null && node1.next != null && node1 != node2) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        if (node1 == null || node2 == null || node1 != node2) {
            return null;
        }
        while (head != null && node1 != null && head != node1) {
            head = head.next;
            node1 = node1.next;
        }
        return head;
    }

    /**
     * 可以用快慢指针法，只比较一半，存也存一半（注意判断奇偶）
     *
     **/
    public static boolean node17(Node node) {
        Node node1 = node;
        Node node2 = null;
        while (node1 != null) {
            Node temp = new Node(node1.data);
            temp.next = node2;
            node2 = temp;
            node1 = node1.next;
        }
        node1 = node;
        while (node1 != null) {
            if (node1.data != node2.data) {
                return false;
            }
            node2 = node2.next;
            node1 = node1.next;
        }
        return true;
    }

    /**
     * 翻转链表，pre,current,next
     *
     **/
    public static Node node18(Node node) {
        Node current = node;
        Node pre = null;
        Node next = null;
        while (current.next != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return current;
    }
}
