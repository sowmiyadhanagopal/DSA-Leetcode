package Leetcode.Tree;
import java.util.*;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class CreateBinaryTreeFromDescriptions {

        public TreeNode createBinaryTree(int[][] descriptions) {
            Map<Integer,TreeNode> map=new HashMap<>();
            Set<Integer>children=new HashSet<>();
            for(int d[]:descriptions)
            {
                int parent=d[0];
                int child=d[1];
                int isLeft=d[2];
                map.putIfAbsent(parent,new TreeNode(parent));
                map.putIfAbsent(child,new TreeNode(child));
                TreeNode parentnode=map.get(parent);
                TreeNode childnode=map.get(child);
                if(isLeft==1)
                {
                    parentnode.left=childnode;
                }
                else
                {
                    parentnode.right=childnode;
                }
                children.add(child);
            }
            for(int value:map.keySet())
            {
                if(!children.contains(value))
                {
                    return map.get(value);
                }
            }
            return null;
        }
    }

