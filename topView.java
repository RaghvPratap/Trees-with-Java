import java.util.*;

public class topView {
    static Node root;
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val,Node left,Node right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }

    public static class Pair{
        Node nd;
        int hd;// horizontal distance or vertical index
        Pair(Node nd, int hd){
            this.nd=nd;
            this.hd=hd;
        }
    }

    public static List<Integer> topV(Node root){
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<Pair> q=new LinkedList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair p=q.poll();
            Node curr=p.nd;
            int hd=p.hd;
            if(!map.containsKey(hd)){
                map.put(hd,curr.val);
            }
            if(curr.left!=null){
                q.add(new Pair(curr.left, hd-1));
            }
            if(curr.right!=null){
                q.add(new Pair(curr.right, hd+1));
            }
        }

        for(int x:map.values()){
            ans.add(x);
        }
        return ans;
    }

    public static void main(String[] args) {
        root = new Node(10, null, null);
        root.left = new Node(1, null, null);
        root.left.left = new Node(2, null, null);
        root.right = new Node(4, null, null);
        root.right.right = new Node(0, null, null);
        System.out.println(topV(root));
        ;
    }
}
