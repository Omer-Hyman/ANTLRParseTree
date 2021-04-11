package SHU;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Stack;


public class Tree extends JFrame {

    private JTree tree;
    public JTree getTree() { return this.tree; }

    private String ctx;

    int level = -2;
    public void setLevel(int level) {
        this.level = this.level + level;
    }

    DefaultMutableTreeNode temp = new DefaultMutableTreeNode();

    private Stack<TreeNode> stack = new Stack<>();
    public Stack<TreeNode> getStack() {
        return stack;
    }

    public Tree() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Parse Tree");
        this.setSize(300, 300);
        this.setVisible(true);

//        this.setLayout(new BorderLayout());
//        JScrollPane scrollPane = new JScrollPane(tree);
//        this.add(scrollPane);

        //TODO: FIX SCROLL PANE

        /*ImageIcon imageIcon = new ImageIcon(Tree.class.getResource("/leaf.jpg"));
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setLeafIcon(imageIcon);*/

    }

    public void getCtx(String ctx) {
        this.ctx = ctx;
    }

    public void searchTree(String nodeName, int option)
    {
        /*String regex = ".*" + nodeName + ".*";
        Pattern pattern = Pattern.compile(regex);;
        Matcher matcher = pattern.matcher(ctx);*/

        /*int count = 0;
        System.out.println("CTX:\n" + ctx + "\nSEARCHING FOR:\n" + nodeName);
        while(matcher.find()) {
            count++;
            System.out.println(nodeName + " found " + count + " times.");
        }
        if (matcher.find())
            return nodeName;
        else
            return null;*/

        String[] nodes = new String[stack.size()];

        switch (option)
        {
            case 1:
                for (int i = 0; i < stack.size(); i++)
                {
                    nodes[i] = stack.get(i).getNodeName();
                }
                break;
            case 2:
                for (int i = 0; i < stack.size(); i++)
                {
                    nodes[i] = stack.get(i).getNodeContents();
                }
                break;
            case 3:
                break;
        }
        System.out.println("Stack size: " + stack.size());

        for (int i = 0; i < stack.size(); i++)
        {
            if (nodeName.equals(nodes[i]))
            {
                System.out.println(nodeName + " found! at index " + i);
            }
            else
                System.out.println(nodeName + " does not = " + stack.get(i).getNodeName());
        }

        //TODO: CARRY ON SEARCH. NODE SEARCH KINDA WORKS, TEST FOR NODE CONTENTS

        //PAST SEARCH BLOCK
        /*DefaultMutableTreeNode node = null;
        Enumeration e = GetRootNode().breadthFirstEnumeration();

        while (e.hasMoreElements()) {
            node = (DefaultMutableTreeNode) e.nextElement();
            if (nodeName.equals(node.toString())) {
                return node.toString() + " found at depth " + node.getLevel() + " at index " + node.getSiblingCount();
            }
        }*/
    }

    //TRYING TO HIGHLIGHT SEARCHED NODE
    /*tree.setCellRenderer(new DefaultTreeCellRenderer() {
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
        boolean leaf, int row, boolean hasFocus) {
            JLabel label = (JLabel)super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            YourNode node = (YourNode)value;
            if (node.isFlagged())
                label.setForeground(Color.RED);

            return label;
        }
    });*/

    public void NewNode(TreeNode node) {
        temp = GetRootNode();
        stack.add(node);
        //System.out.println("\nNode: " + name + "\nTemp: " + temp + "\nTemp.getDepth(): " + temp.getDepth() + "\nLevel: " + level );
        try{
            for (int i = 0; i < level; i++)
                temp = (DefaultMutableTreeNode) temp.getLastChild();
            for (int i = 0; i > level; i--)
                temp = (DefaultMutableTreeNode) temp.getParent();
            temp.add(new DefaultMutableTreeNode(node.getNodeName()));

            temp = (DefaultMutableTreeNode) temp.getLastChild();
            temp.add(new DefaultMutableTreeNode(node.getNodeContents()));
            temp = (DefaultMutableTreeNode) temp.getParent();

        }
        catch (Exception e) {
            System.err.println("WORKING ON NODE " + node.getNodeName() + ". TEMP IS " + temp + ". NODE NOT ADDED TO TREE");
            if (temp != null)
                System.err.println(e);
        }
    }

    public DefaultMutableTreeNode GetRootNode()
    {
        return (DefaultMutableTreeNode) tree.getModel().getRoot();
    }

    public void CreateTree(TreeNode node)
    {
        tree = new JTree(new DefaultMutableTreeNode(node.getNodeName()));
        add(tree);
        stack.add(node);
    }

}

// TREE
// STACK (TREENODE(NAME, CONTENTS))

//program{                    open, temp stays
//    program head{}          closed, temp stays
//    block{                  open, temp moves down a level
//        output{}            closed, temp moves up a level
//    }
//    program ends{}          closed, temp stays
//    proc defun{             open, temp moves down a level
//        block{              open, temp moves down a level
//            input{}
//        }
//    }
// }
