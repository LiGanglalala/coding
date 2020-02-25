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
}
