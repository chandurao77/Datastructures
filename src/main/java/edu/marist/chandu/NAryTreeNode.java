package edu.marist.chandu;

import java.util.ArrayList;

/**
 * This is Narytree node.
 */
public class NAryTreeNode {
    private String data;
    private ArrayList<NAryTreeNode> children = new ArrayList<>();

    /**
     * constructor for tree node.
     * @param data
     */
    protected NAryTreeNode(String data) {
        this.data = data;
    }

    /**
     * This method to get data.
     * @return
     */
    public String getData() {
        return data;
    }

    /**
     * This method to set data.
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * This method to get children.
     * @return
     */
    public ArrayList<NAryTreeNode> getChildren() {
        return children;
    }

    /**
     * This method to set children.
     * @param children
     */
    public void setChildren(ArrayList<NAryTreeNode> children) {
        this.children = children;
    }
}
