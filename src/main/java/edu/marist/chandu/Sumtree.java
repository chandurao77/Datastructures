package edu.marist.chandu;

// public class Sumtree {

//     private Node root;

//     public Sumtree(Node root) {
//         this.root = root;
//     }

//     public boolean isSumTree() {
//         if (this.root == null) return false;
//         if (this.root.getRight() == null && this.root.getLeft() == null) return false;

//         int sum = getSum(this.root.getLeft()) + getSum(this.root.getRight());
//         if (sum == this.root.getValue())
//             return true;
//         else
//             return false;

//     }

//     private int getSum(Node node) {
//         if (node == null)
//             return 0;
//         else
//             return getSum(node.getLeft()) + (Integer)node.getValue() + getSum(node.getRight());
//     }
// }
