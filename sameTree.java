public class sameTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }

    public static boolean isSame(Node p,Node q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    public static void main(String[] args) {
    Node root=new Node(1);
    Node a=new Node(1);
    Node b=new Node(2);
    root.left=b;
    root.right=a;
   
    Node p=new Node(1);
    Node q=new Node(1);
    Node r=new Node(2);
    p.left=r;
    p.right=q;
    
    System.out.println(isSame(root,p));
    }
    
}
