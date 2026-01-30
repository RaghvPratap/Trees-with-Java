public class isSymmetric {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node root;

    public static void invertBT(Node n) {
        if (n == null)
            return;
        if (n.right == null && n.left == null)
            return;
        Node temp = n.left;
        n.left = n.right;
        n.right = temp;
        invertBT(n.left);
        invertBT(n.right);
    }

    public static boolean isSame(Node p, Node q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.data != q.data)
            return false;
        if (!isSame(p.left, q.left))
            return false;
        if (!isSame(p.right, q.right))
            return false;
        return true;
    }

    //Method-2:We are going to left side and right side at the same time

    public static boolean isMirror(Node p,Node q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;

        return (p.data==q.data) && (isMirror(p.left, q.right)) && (isMirror(p.right, q.left)); 
    }

    public static void main(String[] args) {
        root = new Node(10, null, null);
        root.left = new Node(1, null, null);
        root.left.left = new Node(2, null, null);
        root.right = new Node(4, null, null);
        root.right.right = new Node(0, null, null);
        invertBT(root);
        System.out.println(isSame(root.left, root.right));
        // System.out.println(isMirror(root.left, root.right));
    }
}
