package SHU;

import java.util.Stack;

public class TreeNode {
    private final String nodeName;
    private final String nodeContents;
    private static Tree tree;

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

    public TreeNode() {
        this.nodeName = null;
        this.nodeContents = null;
    }

    public TreeNode searchTree(String nodeName, int option)
    {
        switch (option)
        {
            case 1:
                for (int i = 0; i < stack.size(); i++)
                {
                    if (stack.get(i).getNodeName().equals(nodeName))
                    {
                        System.out.println(nodeName + " found! at index " + i);
                        return stack.get(i);
                    }
                }
                break;
            case 2:
                for (int i = 0; i < stack.size(); i++)
                {
                    if (stack.get(i).getNodeContents().equals(nodeName))//NOT PROPER
                    {
                        System.out.println(nodeName + " found! at index " + i);
                        return stack.get(i);
                    }
                }
                break;
            case 3:
                break;
        }
        return null;
        //System.out.println("Stack size: " + stack.size());

        //TODO: CARRY ON SEARCH. IMPLEMENT 3RD CASE. MAYBE IMPROVE WITH REGEX.
        //TODO: TRY TO HIGHLIGHT SEARCHED NODE

    }

    public void DisplayStack()
    {
        for (int i = 0; i < stack.size();i++)
        {
            System.out.println("\nNode: " + stack.get(i).getNodeName()+ "\nNode Contents: " + stack.get(i).getNodeContents());
        }
        System.out.println("Stack size: " + stack.size());
    }


}
