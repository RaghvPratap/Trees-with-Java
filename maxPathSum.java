public class maxPathSum {
    static Node root;
    static int msum=0;
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

    public static int maxSum(Node root){
        if(root==null){
            return 0;
        }
        int lsum=maxSum(root.left);
        int rsum=maxSum(root.right);
        lsum=Math.max(0,lsum);
        rsum=Math.max(0,rsum);
        int pathSum=lsum+rsum+root.data;
        msum=Math.max(msum,pathSum);
        return Math.max(lsum,rsum)+root.data;
    }

    public static void main(String[] args) {
        root = new Node(10, null, null);
        root.left = new Node(1, null, null);
        root.left.left = new Node(2, null, null);
        root.right = new Node(4, null, null);
        root.right.right = new Node(0, null, null);
        System.out.println(maxSum(root));
        ;
    }
}
