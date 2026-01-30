import java.util.*;

public class bottomView {
   static Node root;

   public static class Node {
      int val;
      Node left;
      Node right;

      Node(int val, Node left, Node right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
   }

   public static class Pair {
      Node node;
      int hd;

      Pair(Node node, int hd) {
         this.node = node;
         this.hd = hd;
      }
   }

   public static List<Integer> btmView(Node root) {

      List<Integer> ans = new ArrayList<>();
      if (root == null)
         return ans;
      Map<Integer, Integer> mp = new TreeMap<>();

      // If you don't want to use TreeMap then use,
      // List<Integer> keys = new ArrayList<>(map.keySet());
      // Collections.sort(keys);

      Queue<Pair> q = new ArrayDeque<>();

      q.add(new Pair(root, 0));

      while (!q.isEmpty()) {
         Pair temp = q.poll();
         Node curr = temp.node;
         int lvl = temp.hd;

         mp.put(lvl, curr.val);

         if (curr.left != null) {
            q.add(new Pair(curr.left, lvl - 1));
         }
         if (curr.right != null) {
            q.add(new Pair(curr.right, lvl + 1));
         }
      }

      for (int x : mp.values()) {
         ans.add(x);
      }
      return ans;
   }
}
