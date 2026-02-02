import java.util.*;

public class burningTree {
    public static class Node{
        int val;
        Node left,right;
        Node(int data,Node left,Node right){
            this.val=data;
            this.left=left;
            this.right=right;
        }
    }

    public static void buildGraph(Node root,Map<Node,Node> map){
        if(root==null) return;
        if(root.left!=null) map.put(root.left, root);
        if(root.right!=null) map.put(root.right, root);
        buildGraph(root.left, map);
        buildGraph(root.right, map);
    }

    public static int burn(Node root,Node tgt){
        Set<Node> vis=new HashSet<>();
        Queue<Node> q=new ArrayDeque<>();
        Map<Node,Node> map=new HashMap<>();
        int time=0;
        buildGraph(root, map);
        q.add(root);
        vis.add(root);

        while(!q.isEmpty()){
            int x=q.size();
            for(int i=0;i<x;i++){
                Node curr=q.poll();
                if(curr.left!=null && !vis.contains(curr.left)){
                    q.add(curr.left);
                    vis.add(curr.left);
                }
                if(curr.right!=null && !vis.contains(curr.right)){
                    q.add(curr.right);
                    vis.add(curr.right);
                }
                if(map.containsKey(curr) && !vis.contains(map.get(curr))){
                    q.add(map.get(curr));
                    vis.add(map.get(curr));
                }
            }
            if(!q.isEmpty()) time++;
        }
        return time;
    }
}
