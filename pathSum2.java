import java.util.*;

public class pathSum2 {
    public static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void helper(List<List<Integer>> ans, List<Integer> arr, Node root, int sum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            arr.add(root.val);
            if (root.val == sum) {
                // List<Integer> a=new ArrayList<>();
                // for(int i=0;i<arr.size();i++){
                // a.add(arr.get(i));
                // }
                List<Integer> a = new ArrayList<>(arr);
                ans.add(a);
            }
            arr.remove(arr.size() - 1);
            return;
        }
        arr.add(root.val);
        helper(ans, arr, root.left, sum - root.val);
        helper(ans, arr, root.right, sum - root.val);
        arr.remove(arr.size() - 1);
    }

    public static List<List<Integer>> path(Node root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        helper(ans, arr, root, sum);
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(1);
        Node b = new Node(2);
        root.left = b;
        root.right = a;

        Node p = new Node(1);
        Node q = new Node(1);
        Node r = new Node(2);
        p.left = r;
        p.right = q;

    }
}
