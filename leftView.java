
import java.util.*;
public class leftView {
    public static class Node{
        int data;
        Node left,right;
        Node(int data,Node right,Node left){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }

    public static List<Integer> view(Node root){
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<Node> q=new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                Node curr=q.poll();
                ans.add(curr.data);
                if(i==0) ans.add(curr.data); // for right view
                // if(i==n-1) ans.add(curr.data);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        return ans;
    }
}
