package edu.marist.chandu;

import java.util.Iterator;

/**
 * Below class is NAryTree implementation.
 */
public class NAryTree {
    private NAryTreeNode root;
    private int order;
    private int counter;
    private Queue nodeQueue;
    private NAryTreeNode found;
    private int nodeCount;

    /**
     * Below is the constructor.
     * @param order
     */
    NAryTree(int order) {
        this.order = order;
        nodeQueue = new Queue();
    }

    /**
     * Below method to insert data.
     * @param data
     * @return
     */
    public NAryTreeNode insert(String data) {
        NAryTreeNode node = new NAryTreeNode(data);
        if (counter == order) {
            nodeQueue.deqeueue();
            counter = 0;
        }
        if (nodeQueue.isEmpty()) {
            root = node;
        } else {
            nodeQueue.enqueue(String.valueOf(node));
        }
        nodeQueue.enqueue(String.valueOf(node));
        counter++;
        return root;
    }

    /**
     * Below method to remove data.
     * @param data
     * @return
     */
    public NAryTreeNode remove(String data) {
        NAryTreeNode result = null;
        removeNode(root, data);
        if (found != null) {
            result = found;
            found = null;
        }
        return result;
    }

    /**
     * Below method to remove node.
     * @param node
     * @param data
     */
    private void removeNode(NAryTreeNode node, String data) {
        Iterator<NAryTreeNode> itr = node.getChildren().iterator();
        while (itr.hasNext()) {
            NAryTreeNode dt = itr.next();
            if (dt.getData().equals(data)) {
                itr.remove();
                found = dt;
            } else {
                removeNode(dt, data);
            }
        }
    }

    /**
     * Below method to search for data.
     * @param data
     * @return
     */
    public NAryTreeNode search(String data) {
        NAryTreeNode result = null;
        searchNode(root, data);
        if (found != null) {
            result = found;
            found = null;
        }
        return result;
    }

    /**
     * Below method to search node.
     * @param node
     * @param data
     * @return
     */
    private NAryTreeNode searchNode(NAryTreeNode node, String data) {
        for (NAryTreeNode current: node.getChildren()) {
            if (current.getData().equals(data)) {
                found = current;
            } else {
                searchNode(current, data);
            }
        }
        return found;
    }

    /**
     * Below method to get size.
     * @return
     */
    public int size() {
        nodeCount = getSize(root);
        return nodeCount;
    }

    /**
     * Below method to get size.
     * @param node
     * @return
     */
    private int getSize(NAryTreeNode node) {
        int s = 0;
        for (NAryTreeNode current: node.getChildren()) {
            int cs = getSize(current);
            s = s + cs;
        }
        s = s + 1;
        return s;
    }

    /**
     * This method to get height.
     * @return
     */
    public int height() {
        return getHeight(root);
    }

    /**
     * This method to get height.
     * @param node
     * @return
     */
    public int getHeight(NAryTreeNode node) {
        int ht = -1;
        for (NAryTreeNode child : node.getChildren()) {
            int ch = getHeight(child);
            ht = Math.max(ch, ht);
        }
        ht += 1;
        return ht;
    }

    /**
     * This method to string.
     * @return
     */
    public String treeToString() {
        StringBuilder sb = new StringBuilder();
        display(sb, root);
        return sb.toString();
    }

    /**
     * This method to display tree.
     * @param sb
     * @param node
     */
    private void display(StringBuilder sb, NAryTreeNode node) {
        String str = node.getData() + " -> ";
        for (NAryTreeNode child:node.getChildren()) {
            str += child.getData() + ", ";
        }
        str += ".";
        sb.append(str + "\n");
        for (NAryTreeNode child:node.getChildren()) {
            display(sb, child);
        }
    }
}
