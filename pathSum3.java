public class pathSum3 {
    public static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static int numPath(Node root, int tgt) {
        if (root == null)
            return 0;
        int cnt = 0;
        if (root.val == tgt)
            return cnt++;
        return cnt + numPath(root.left, tgt - root.val) + numPath(root.right, tgt - root.val);
    }

    public static int path(Node root, int tgt) {
        if (root == null)
            return 0;
        int cnt = numPath(root, tgt);
        return cnt + ((numPath(root.left, tgt)) + (numPath(root.right, tgt)));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(1);
        Node b = new Node(2);
        root.left = b;
        root.right = a;

        Node p = new Node(1);
        Node q = new Node(1);
        Node r = new Node(2);
        p.left = r;
        p.right = q;

    }
}
