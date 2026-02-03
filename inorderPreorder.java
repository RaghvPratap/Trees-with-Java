public class inorderPreorder {
    static Node root;
    public static class Node{
        int data;
        Node left,right;
        Node(int val, Node left, Node right){
            this.data=val;
            this.left=left;
            this.right=right;
        }
    }

    public static Node helper(int[] inorder,int[] preorder,int ilow, int ihigh, int plow, int phigh){
        int r=0;
        if(ilow>ihigh || plow>phigh) return null;
        while(inorder[r]!=preorder[0]) r++;
        int ls=r-ilow;
        Node root=new Node(preorder[0], null, null);
        root.left=helper(inorder, preorder, ilow, ilow+ls-1, plow+1, plow+ls);
        root.right=helper(inorder, preorder, r+1, ihigh, plow+ls+1, phigh);
        return root;
    }

    public static void main(String[] args) {
        root = new Node(10, null, null);
        root.left = new Node(1, null, null);
        root.left.left = new Node(2, null, null);
        root.right = new Node(4, null, null);
        root.right.right = new Node(0, null, null);        

    }
}
