public class inorderPostorder {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }

    public static Node helper(int[] inorder,int[] postorder,int ilow, int ihigh, int plow, int phigh){
        if(plow>phigh || ilow>ihigh) return null;
        int r=0;
        while(inorder[r]!=postorder[postorder.length-1]) r++;
        Node root=new Node(postorder[postorder.length-1]);
        int ls=r-ilow;
        root.left=helper(inorder, postorder, ilow, ilow+ls-1, plow, plow+ls-1);
        root.right=helper(inorder, postorder, ilow+ls, ihigh+ls-1, plow+ls, phigh-1);
        return root;
    }

    public static void main(String[] args) {
    Node root=new Node(0);
    Node a=new Node(1);
    Node b=new Node(2);
    Node c=new Node(3);
    Node d=new Node(4);
    Node e=new Node(5);
    Node f=new Node(6);
    root.left=b;
    root.right=a;
    b.left=c;
    b.right=d;
    a.right=e;
    a.left=f;
}
}
