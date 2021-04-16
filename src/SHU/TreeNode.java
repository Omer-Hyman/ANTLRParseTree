package SHU;

import java.util.Stack;
import java.util.regex.Pattern;

public class TreeNode {
    private final String nodeName;
    private final String nodeContents;
    private int level;

    Worker worker = new Worker();

    public String getNodeName() {
        return nodeName;
    }

    public String getNodeContents() {
        return nodeContents;
    }

    public int getLevel() {
        return level;
    }

    public TreeNode(String nodeName, String nodeContents, int level)
    {
        this.nodeName = nodeName;
        this.nodeContents = nodeContents;
        this.level = level;
        worker.getStack().add(this);
    }

    public TreeNode()
    {
        this.nodeName = null;
        this.nodeContents = null;
    }
}
