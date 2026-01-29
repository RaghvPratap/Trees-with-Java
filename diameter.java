public class diameter {
    static int maxD=0;
    static Node root;

    //They belong to the class, not to any object. Only one copy exists, shared by all objects of the class.Used to global state information.Below function are static as only static method can access static variable (and we know that main() method is static).

    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }

    public static int ht(Node root){
        if(root==null) return 0;
        int lht=ht(root.left);
        int rht=ht(root.right);
        maxD=Math.max(maxD,lht+rht);
        return 1+Math.max(lht,rht);
    }

    public static void main(String[] args) {
        root = new Node(10, null, null);
        root.left = new Node(1, null, null);
        root.left.left = new Node(2, null, null);
        root.right = new Node(4, null, null);
        root.right.right = new Node(0, null, null);
        System.out.println(ht(root));
        ;
    }
}
