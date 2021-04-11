package SHU;

import java.util.Stack;

public class TreeNode {
    private String nodeName;
    private String nodeContents;
    private static Tree tree;


    public TreeNode(String nodeName, String nodeContents)
    {
        this.nodeName = nodeName;
        this.nodeContents = nodeContents;
        tree.getNodes().add(this);
    }
}
