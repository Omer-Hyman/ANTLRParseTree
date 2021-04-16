package SHU;

import java.util.Stack;
import java.util.regex.Pattern;

public class TreeNode {
    private final String nodeName;
    private final String nodeContents;
    private int level;

    public String getNodeName() {
        return nodeName;
    }

    public String getNodeContents() {
        return nodeContents;
    }

    public int getLevel() {
        return level;
    }

    private static Stack<TreeNode> stack = new Stack<>();

    public Stack<TreeNode> getStack() {
        return stack;
    }

    public TreeNode(String nodeName, String nodeContents, int level)
    {
        this.nodeName = nodeName;
        this.nodeContents = nodeContents;
        this.level = level;
        stack.add(this);
    }

    public TreeNode()
    {
        this.nodeName = null;
        this.nodeContents = null;
    }

    public void DisplayStack()
    {
        for (int i = 0; i < stack.size();i++)
        {
            System.out.println("\nNode: " + stack.get(i).getNodeName()+ "\nNode Contents: " + stack.get(i).getNodeContents());
        }
        System.out.println("\nStack size: " + stack.size());
    }

    public void SearchTree(String nodeName, int option)
    {
//        Pattern regex = Pattern.compile(nodeName, Pattern.CASE_INSENSITIVE);//search for
//        Matcher matcher = regex.matcher(node.getStack().toString());//in this text
//        //Pattern.matches(nodeName, node.getStack().toString());
//
//        boolean matchFound = matcher.find();

        for (int i = 0; i < stack.size(); i++)
        {
            if(Pattern.matches(nodeName, stack.get(i).getNodeName())) {
                System.out.println("Match found at index " + i);
            } else if(i == stack.size() - 1) {
                System.out.println("Match not found");
            }
        }
    }




    //TODO: TRY TO HIGHLIGHT SEARCHED NODE

}
