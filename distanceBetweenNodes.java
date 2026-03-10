class solution{
 public int distance(Node root,int p,int q){
   if(root==null) return 0;
   Map<Node,Node> map=new HashMap<>();
   Queue<Node> q=new LinkedList<>();
   Set<Node> vis=new HashSet<>();
   q.add(root);
   Node st=null;
   while(!q.isEmpty()){
     Node curr=q.poll();
     if(curr==p) st=curr;
     if(curr.left!=null){
       map.put(curr.left,curr);
       q.add(curr.left);
     }
     if(curr.right!=null){
       map.put(curr.right,curr);
       q.add(curr.right);
     }
   }
   vis.add(st);
   q.add(st);
   int d=0;
   while(!q.isEmpty()){
     int s=q.size();
     for(int i=0;i<s;i++){
       Node curr=q.poll();
       if(curr==q) return d;
       if(curr.left!=null && vis.add(curr.left)){
         q.add(curr.left);
       }
       if(curr.right!=null && vis.add(curr.right)){
         q.add(curr.right);
       }
       if(map.containsKey(curr) && vis.add(map.get(curr))){
         q.add(map.get(curr));
       }
     }
     d++;
   }
   return -1;
 }
}
