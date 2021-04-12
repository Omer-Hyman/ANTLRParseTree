package SHU;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.Stack;


public class Tree extends JFrame {

    private JFrame frame = new JFrame();
    private JPanel panel;
    private JTree tree;


    private String ctx;
    int level = -2;

    public JTree getTree() { return this.tree; }
    public void setLevel(int level) {
        this.level = this.level + level;
    }
    private Stack<TreeNode> stack = new Stack<>();
    public Stack<TreeNode> getStack() {
        return stack;
    }

    public Tree() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Parse Tree");
        this.setMinimumSize(new Dimension(300, 300));
        this.setVisible(true);

        this.pack();


        //TODO: FIX SCROLL PANE
        //TODO: CHANGE ICONS
        //TODO: DO MORE SAMPLE PROGRAMS
        //TODO: SUBTREES?
        //TODO: FIX TREE TO ONLY DISPLAY THE RIGHT CTX.GETTEXT()
        //TODO: STRING TEMPLATE - TURN INTO JS

        /*ImageIcon imageIcon = new ImageIcon(Tree.class.getResource("/leaf.png"));
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setLeafIcon(imageIcon);*/

    }

    public void getCtx(String ctx) {
        this.ctx = ctx;
    }

    public TreeNode searchTree(String nodeName, int option)
    {
        Stack<String> nodeIndex = new Stack<>();
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

    public void NewNode(TreeNode node) {
        DefaultMutableTreeNode temp = GetRootNode();
        stack.add(node);
        try{
            for (int i = 0; i < level; i++)
                temp = (DefaultMutableTreeNode) temp.getLastChild();
            for (int i = 0; i > level; i--)
                temp = (DefaultMutableTreeNode) temp.getParent();
            temp.add(new DefaultMutableTreeNode(node.getNodeName()));

//            temp = (DefaultMutableTreeNode) temp.getLastChild();
//            temp.add(new DefaultMutableTreeNode(node.getNodeContents()));
//            temp = (DefaultMutableTreeNode) temp.getParent();
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
        //tryingGUI gui = new tryingGUI();

        tree = new JTree(new DefaultMutableTreeNode(node.getNodeName()));
        stack.add(node);

        //TreePath path = tree.getAnchorSelectionPath();
        //tree.scrollPathToVisible(path);
        //jPane.getViewport().setBackground(Color.RED);

        JScrollPane sPane = new JScrollPane(tree,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sPane.setPreferredSize(new Dimension(300, 300));
        add(sPane);

        ImageIcon leafIcon = new ImageIcon("images/leaf.png");
        if (leafIcon != null) {
            System.err.println("IMAGE FOUND");//displays even if file not there
            DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
            renderer.setLeafIcon(leafIcon);
            tree.setCellRenderer(renderer);
        }
        else
            System.err.println("LEAF IMAGE MISSING!");
    }

    public void DisplayStack()
    {
        System.out.println("Stack size: " + stack.size());
        for (int i = 0; i < stack.size();i++)
        {
            System.out.println("\nNode: " + stack.get(i).getNodeName()+ "\nNode Contents: " + stack.get(i).getNodeContents());
        }
    }

    public void SubTree(String rootNode)
    {
        try {
            CreateTree(searchTree(rootNode, 1));
        }catch(Exception e)
        {
            System.err.println("Node couldn't be found!");
        }

        DisplayStack();

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
