package SHU;

import java.util.Stack;

public class TreeNode {
    private final String nodeName;
    private final String nodeContents;
    private Tree tree;

    public String getNodeName() {
        return nodeName;
    }

    public String getNodeContents() {
        return nodeContents;
    }

    public TreeNode(String nodeName, String nodeContents)
    {
        this.nodeName = nodeName;
        this.nodeContents = nodeContents;
        //tree.getStack().add(this);
    }

    /*public TreeNode() {
        this.nodeName = null;
        this.nodeContents = null;
    }*/




}
