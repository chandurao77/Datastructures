package edu.marist.chandu;

/**
 * Below class is AVL implementation.
 */
public class AVLNode {
    private String data;
    private AVLNode left;
    private AVLNode right;
    private int height;

    /**
     * Below is the AVL node constructor.
     * @param data
     */
    public AVLNode(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 0;
    }

    /**
     * This method is to get data.
     * @return
     */
    public String getData() {
        return data;
    }

    /**
     * This method is to set data.
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * This method is to get left element.
     * @return
     */
    public AVLNode getLeft() {
        return left;
    }

    /**
     * This method is to set left element.
     * @param left
     */
    public void setLeft(AVLNode left) {
        this.left = left;
    }

    /**
     * This method is to get right element.
     * @return
     */
    public AVLNode getRight() {
        return right;
    }

    /**
     * This method is to set right element.
     * @param right
     */
    public void setRight(AVLNode right) {
        this.right = right;
    }

    /**
     * This method is to get height.
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     * This method is to set height.
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }
}
