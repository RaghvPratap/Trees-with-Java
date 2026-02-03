public class pathSum{
    public static class Node{
        int val;
        Node left,right;
        Node(int val){
            this.val=val;
        }
    }

    public static boolean hasPath(Node root,int t){
        return dfs(root,0,t);
    }

    public static boolean dfs(Node root,int sum,int tgt){
        if(root==null) return false;
        if(root!=null && (root.left==null && root.right==null)){
            return (root.val==tgt);
        }
        sum+=root.val;
        return dfs(root.left,sum,tgt) || dfs(root.right, sum, tgt);
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        Node a=new Node(1);
        Node b=new Node(2);
        root.left=b;
        root.right=a;
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        b.left=c;
        b.right=d;
        a.right=e;
        a.left=f;
        System.out.println(hasPath(root, 100));
        }
}