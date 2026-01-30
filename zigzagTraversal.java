import java.util.*;

public class zigzagTraversal {
    public static class Node {
       int val;
       Node left,right;
        
       Node(int val){
        this.val=val;
       }
    }
 
    public static List<Integer> traverse(Node root){
       List<Integer> ans=new ArrayList<>();
       if(root==null) return ans;
       Queue<Node> q=new LinkedList<>();
       boolean lr=true;
       q.add(root);
       while(!q.isEmpty()){
        int n=q.size();
        Node curr=q.poll();
        ans.add(curr.val);
        for(int i=0;i<n;i++){
            if(lr){
              if(curr.left!=null) q.add(curr.left);
              if(curr.right!=null) q.add(curr.right);
            }else{
              if(curr.left!=null) q.add(curr.left);
              if(curr.right!=null) q.add(curr.right);
            }
            lr=!lr;
        }
       }
       return ans;
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
        
        }
}
