package SHU;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.Stack;


public class Tree extends JFrame {

    private JTree tree;

    public DefaultMutableTreeNode GetRootNode()
    {
        return (DefaultMutableTreeNode) this.tree.getModel().getRoot();
    }

    private JScrollPane sPane = new JScrollPane(tree,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

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

    public void getCtx(String ctx) {
        this.ctx = ctx;
    }

    public Tree() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Parse Tree");
        this.setVisible(true);
        this.setSize(400, 400);

        //TODO: CHANGE LEAF ICONS
        //TODO: DO MORE SAMPLE PROGRAMS - done ish
        //TODO: SUBTREES
        //TODO: FIX TREE TO ONLY DISPLAY THE RIGHT CTX.GETTEXT()
        //TODO: STRING TEMPLATE - TURN INTO JS

        //LEAF ICON SHIT
        /*ImageIcon imageIcon = new ImageIcon(Tree.class.getResource("images/leaf.png"));
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setLeafIcon(imageIcon);*/
        /*ImageIcon leafIcon = new ImageIcon("images/leaf.png");
        if (leafIcon != null) {
            System.err.println("IMAGE FOUND");//displays even if file not there
            DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
            renderer.setLeafIcon(leafIcon);
            tree.setCellRenderer(renderer);
        }
        else
            System.err.println("LEAF IMAGE MISSING!");*/

    }

    public void NewNode(TreeNode node) {
        DefaultMutableTreeNode temp = GetRootNode();
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

    public void CreateTree(TreeNode node)
    {
        tree = new JTree(new DefaultMutableTreeNode(node.getNodeName()));
        stack.add(node);

        add(sPane);

        setVisible(true);
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

    public void SubTree(String rootNode)
    {
        try {
            CreateTree(searchTree(rootNode, 1));
        }catch(Exception e)
        {
            System.err.println("Node couldn't be found!");
        }
    }

}