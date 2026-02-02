import java.util.*;

public class maxWidth {
    public static class Node{
        int val;
        Node left,right;
        Node(int data,Node left,Node right){
            this.val=data;
            this.left=left;
            this.right=right;
        }
    }

    public static class Pair {
        Node nd;
        int ht;
        Pair(Node nd,int ht){
            this.nd=nd;
            this.ht=ht;
        }        
    }

    public static int width(Node root){
        if(root==null) return 0;
        int ans=0;
        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            int sz=q.size();
            int min=q.poll().ht;
            int f=0,l=0;
            for(int i=0;i<sz;i++){
                int currlvl=q.peek().ht-min;
                Node temp=q.peek().nd;
                q.poll();
                if(i==0) f=currlvl;
                if(i==sz-1) l=currlvl;
                if(temp.left!=null){
                   q.add(new Pair(temp.left, currlvl*2+1));
                }
                if(temp.right!=null){
                   q.add(new Pair(temp.right, currlvl*2+2));
                }
                ans=Math.max(ans,l-f+1);
            }
        }
        return ans;
    }
}
