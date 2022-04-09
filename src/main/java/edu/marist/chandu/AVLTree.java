package edu.marist.chandu;

/**
 * This class is implementation of AVL Tree.
 */
public class AVLTree {
    private AVLNode root;
    private int nodeCount;

    /**
     * This is the method to insert data.
     * @param data
     * @return
     */
    public AVLNode insert(String data) {
        root = insert(data, root);
        return root;
    }

    /**
     * This is the AVL insert method having data and node as arguments.
     * @param data
     * @param node
     * @return
     */
    private AVLNode insert(String data, AVLNode node) {
        if (node == null) {
            return new AVLNode(data);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(insert(data, node.getLeft()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(insert(data, node.getRight()));
        } else {
            return node;
        }
        updateHeight(node);
        return applyRotation(node);
    }

    /**
     * This method is to update height with node as argument.
     * @param node
     */
    private void updateHeight(AVLNode node) {
        int maxHeight = Math.max(
                height(node.getLeft()),
                height(node.getRight())
        );
        node.setHeight(maxHeight + 1);
    }

    /**
     * This method is to get height using node as argument.
     * @param node
     * @return
     */
    private int height(AVLNode node) {
        return node != null ? node.getHeight() : 0;
    }

    /**
     * This method is to apply rotation.
     * @param node
     * @return
     */
    private AVLNode applyRotation(AVLNode node) {
        int balance = balance(node);
        if (balance > 1) {
            if (balance(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (balance(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }
        return node;
    }

    /**
     * This method is to get balance using node as argument.
     * @param node
     * @return
     */
    private int balance(AVLNode node) {
        return node != null ? height(node.getLeft()) - height(node.getRight()) : 0;
    }

    /**
     * This method is to rotate right.
     * @param node
     * @return
     */
    private AVLNode rotateRight(AVLNode node) {
        AVLNode leftNode = node.getLeft();
        AVLNode centerNode = leftNode.getRight();
        leftNode.setRight(node);
        node.setLeft(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    /**
     * This method is to rotate left.
     * @param node
     * @return
     */
    private AVLNode rotateLeft(AVLNode node) {
        AVLNode rightNode = node.getRight();
        AVLNode centerNode = rightNode.getLeft();
        rightNode.setLeft(node);
        node.setRight(centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    /**
     * This method is to delete element for given data.
     * @param data
     * @return
     */
    public AVLNode delete(String data) {
        root = delete(data, root);
        return root;
    }

    /**
     * This method is to delete element using data and node as arguments.
     * @param data
     * @param node
     * @return
     */
    private AVLNode delete(String data, AVLNode node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(delete(data, node.getLeft()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(delete(data, node.getRight()));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            node.setData(getMax(node.getLeft()));
            node.setLeft(delete(node.getData(), node.getLeft()));
        }
        updateHeight(node);
        return applyRotation(node);
    }

    /**
     * This method is to get max.
     * @return
     */
    public String getMax() {
        if (isEmpty()) {
            return null;
        }
        return getMax(root);
    }

    /**
     * This method is to get max using node as argument.
     * @param node
     * @return
     */
    private String getMax(AVLNode node) {
        if (node.getRight() != null) {
            return getMax(node.getRight());
        }
        return node.getData();
    }

    /**
     * this method is to check empty.
     * @return
     */
    public boolean isEmpty() {
        return root == null;
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
     * This method is to traverse tree.
     * @param sb
     * @param padding
     * @param pointer
     * @param node
     */
    private void traverse(StringBuilder sb, String padding, String pointer, AVLNode node) {

        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getData());
            sb.append("\n");
            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("│  ");
            String bothPadding = paddingBuilder.toString();
            String rightPadding = "└─";
            String leftPadding = (node.getRight() != null) ? "├" : "└";
            traverse(sb, bothPadding, leftPadding, node.getLeft());
            traverse(sb, bothPadding, rightPadding, node.getRight());
        }
    }

    /**
     * This method is to search using data as argument.
     * @param data
     * @return
     */
    public AVLNode search(String data) {
        return searchNode(root, data);
    }

    /**
     * This method is to search node usign node and data as argument.
     * @param thisElm
     * @param data
     * @return
     */
    private AVLNode searchNode(AVLNode thisElm, String data) {
        AVLNode flag = null;
        while (thisElm != null && flag != null) {
            String value = thisElm.getData();
            if (data.compareTo(value) < 0) {
                thisElm = thisElm.getLeft();
            } else if (data.compareTo(value) > 0) {
                thisElm = thisElm.getRight();
            } else {
                flag = thisElm;
                break;
            }
            flag = searchNode(thisElm, data);
        }
        return flag;
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
     * This method to get tree size.
     * @param node
     * @return
     */
    private int getSize(AVLNode node) {
        if (node == null) {
            return 0;
        }
        int ls = getSize(node.getLeft());
        int rs = getSize(node.getRight());
        return ls + rs + 1;
    }

    /**
     * This method is to get height.
     * @return
     */
    public int getHeight() {
        return getHeight(root);
    }

    /**
     * This method is to get height using node as argument.
     * @param node
     * @return
     */
    private int getHeight(AVLNode node) {
        if (node == null) {
            return 0;
        }
        int lh = getHeight(node.getLeft());
        int rh = getHeight(node.getRight());
        return Math.max(lh, rh) + 1;
    }

    /**
     * This method is to get root of the tree.
     * @return
     */
    public AVLNode getRoot() {
        return root;
    }

    /**
     * This method is to set root node.
     * @param root
     */
    public void setRoot(AVLNode root) {
        this.root = root;
    }

    /**
     * This method is to set node count.
     * @param nodeCount
     */
    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }
}
