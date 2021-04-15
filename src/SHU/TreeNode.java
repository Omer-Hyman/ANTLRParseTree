package SHU;

import java.util.Stack;

public class TreeNode {
    private final String nodeName;
    private final String nodeContents;

    public String getNodeName() {
        return nodeName;
    }

    public String getNodeContents() {
        return nodeContents;
    }

    private static Stack<TreeNode> stack = new Stack<>();

    public Stack<TreeNode> getStack() {
        return stack;
    }

    public TreeNode(String nodeName, String nodeContents)
    {
        this.nodeName = nodeName;
        this.nodeContents = nodeContents;
        stack.add(this);
    }

    public TreeNode()
    {
        this.nodeName = null;
        this.nodeContents = null;
    }


}
