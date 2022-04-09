package edu.marist.chandu;

/**
 * Below class is the implementation of binary tree.
 */
public class BinaryTree {
    private Node root;
    private int nodeCount;

    /**
     * below method is the binary tree insert method with new data as argument.
     * @param newData
     * @return
     */
    public Node insert(String newData) {
        root = insertNode(root, newData);
        return root;
    }

    /**
     * This method is to get root node.
     * @return
     */
    public Node getRoot() {
        return root;
    }

    /**
     * This method is to set root node.
     * @param root
     */
    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * This method is to set node count.
     * @param nodeCount
     */
    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }

    /**
     * This method is to insert node.
     * @param currentElm
     * @param newData
     * @return
     */
    private Node insertNode(Node currentElm, String newData) {
        if (currentElm == null) {
            return new Node(newData);
        }

        if (newData.compareTo(currentElm.getData()) <= 0) {
            currentElm.setPrev(insertNode(currentElm.getPrev(), newData));
        } else if (newData.compareTo(currentElm.getData()) > 0) {
            currentElm.setNext(insertNode(currentElm.getNext(), newData));
        }

        return currentElm;
    }

    /**
     * This method is to remove using data as argument.
     * @param data
     * @return
     */
    public Node remove(String data) {
        return removeNode(root, data);
    }

    /**
     * This method is to remove node from binary tree.
     * @param currentElm
     * @param data
     * @return
     */
    private Node removeNode(Node currentElm, String data) {
        if (currentElm == null) {
            return  currentElm;
        }

        if (data.compareTo(currentElm.getData()) < 0) {
            currentElm.setPrev(removeNode(currentElm.getPrev(), data));
        } else if (data.compareTo(currentElm.getData()) > 0) {
            currentElm.setNext(removeNode(currentElm.getNext(), data));
        } else {
            if (currentElm.getPrev() == null) {
                return currentElm.getNext();
            } else if (currentElm.getNext() == null) {
                return currentElm.getPrev();
            }
            currentElm.setData(inOrderSuccessor(currentElm.getNext()));
            currentElm.setNext(removeNode(currentElm.getNext(), currentElm.getData()));
            nodeCount--;
        }
        return currentElm;
    }

    /**
     * This method to order successor in binary tree.
     * @param currentElm
     * @return
     */
    public String inOrderSuccessor(Node currentElm) {
        String rval = currentElm.getData();
        while (currentElm.getPrev() != null) {
            rval = currentElm.getData();
            currentElm = currentElm.getPrev();
        }
        return rval;
    }

    /**
     * This method is to search in binary tree with data as argument.
     * @param data
     * @return
     */
    public Node search(String data) {
        return searchNode(root, data);
    }

    /**
     * This method is to search with node and data as argument.
     * @param currentElm
     * @param data
     * @return
     */
    private Node searchNode(Node currentElm, String data) {
        Node found = null;
        while (currentElm != null && found != null) {
            String value = currentElm.getData();
            if (data.compareTo(value) < 0) {
                currentElm = currentElm.getPrev();
            } else if (data.compareTo(value) > 0) {
                currentElm = currentElm.getNext();
            } else {
                found = currentElm;
                break;
            }
            found = searchNode(currentElm, data);
        }
        return found;
    }

    /**
     * This method is to return tree as string.
     * @return
     */
    public String treeToString() {
        StringBuilder sb = new StringBuilder();
        traverse(sb, "", "", root);
        return sb.toString();
    }

    /**
     * This method is to traverse the tree.
     * @param sb
     * @param padding
     * @param pointer
     * @param node
     */
    private void traverse(StringBuilder sb, String padding, String pointer, Node node) {

        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getData());
            sb.append("\n");

            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("│  ");

            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "└──";
            String pointerForLeft = (node.getNext() != null) ? "├──" : "└──";

            traverse(sb, paddingForBoth, pointerForLeft, node.getPrev());
            traverse(sb, paddingForBoth, pointerForRight, node.getNext());
        }
    }

    /**
     * This method is to get node count.
     * @return
     */
    public int getNodeCount() {
        nodeCount = getSize(root);
        return nodeCount;
    }

    /**
     * This method is to get binary tree size.
     * @param node
     * @return
     */
    private int getSize(Node node) {
        if (node == null) {
            return 0;
        }
        int ls = getSize(node.getPrev());
        int rs = getSize(node.getNext());
        return ls + rs + 1;
    }

    /**
     * This method is to get binary tree height.
     * @return
     */
    public int height() {
        return getHeight(root);
    }

    /**
     * This method is to get binary tree height.
     * @param node
     * @return
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int lh = getHeight(node.getPrev());
        int rh = getHeight(node.getNext());
        return Math.max(lh, rh) + 1;
    }
}
