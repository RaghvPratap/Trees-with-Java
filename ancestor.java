public class ancestor {
    public static class Node{
        int val;
        Node left,right;
        Node(int val){
            this.val=val;
        }
    }

    public static boolean contains(Node root,Node p){
        if(root==null) return false;
        if(root==p) return true;
        return (contains(root.left, p)) || (contains(root.right, p));
    }

    public static Node commonAncestor(Node root,Node p,Node q){
        if(p==root || q==root) return root;
        if(p==q) return p;
        boolean l=contains(root.left, p);
        boolean r=contains(root.right, q);
        if((l && r) || (!l && !r)) return root;
        if(l & !r) return commonAncestor(root.left, p, q);
        if(!l & r) return commonAncestor(root.right, p, q);
        return root;
    }

    public static void main(String[] args) {
    Node root = new Node(1);
    Node a = new Node(1);
    Node b = new Node(2);
    root.left = b;
    root.right = a;
        
    System.out.println( commonAncestor(root, b, a).val);
    }
}
