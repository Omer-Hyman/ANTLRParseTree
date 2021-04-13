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
    public DefaultMutableTreeNode GetRootNode()
    {
        return (DefaultMutableTreeNode) this.tree.getModel().getRoot();
    }

    private JScrollPane sPane = new JScrollPane(tree,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private String ctx;
    int level = -2;

    TreeNode node = new TreeNode();

    public JTree getTree() { return this.tree; }

    public void setLevel(int level) {
        this.level = this.level + level;
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

    public void getCtx(String ctx) {
        this.ctx = ctx;
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
        add(sPane);

        setVisible(true);
    }



    public void SubTree(String rootNode)
    {
        try {
            CreateTree(node.searchTree(rootNode, 1));
        }catch(Exception e)
        {
            System.err.println("Node couldn't be found!");
        }
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
