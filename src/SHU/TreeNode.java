package SHU;

import java.util.Stack;

public class TreeNode {
    private String nodeName;
    private String nodeContents;

    private final Stack<TreeNode> nodes = new Stack<>();

    public Stack<TreeNode> getNodes() {
        return nodes;
    }

    public TreeNode(String nodeName, String nodeContents)
    {
        this.nodeName = nodeName;
        this.nodeContents = nodeContents;
        nodes.add(this);
    }
}
