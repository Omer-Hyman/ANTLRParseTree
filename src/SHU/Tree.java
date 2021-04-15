package SHU;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Tree extends JFrame {
    private JTree tree;
    private TreeNode node = new TreeNode();

    public DefaultMutableTreeNode GetRootNode()
    {
        return (DefaultMutableTreeNode) this.tree.getModel().getRoot();
    }


    private String ctx;
    int level = -2;

    public JTree getTree() { return this.tree; }

    public void setLevel(int level) {
        this.level = this.level + level;
    }

    public void setCtx(String ctx) {
        this.ctx = ctx;
    }

    public Tree() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Parse Tree");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);


        //TODO: CHANGE LEAF ICONS
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
            System.err.println("TEMP IS " + temp + ". " + node.getNodeName() + " NOT ADDED TO TREE");
            if (temp != null)
                System.err.println(e);
        }
    }

    public void CreateTree(TreeNode node)
    {
        tree = new JTree(new DefaultMutableTreeNode(node.getNodeName()));

        JScrollPane sPane = new JScrollPane(tree);

        add(sPane);
        setVisible(true);
    }


    public void SubTree(String rootNode)
    {
        try {
            //CreateTree(node.searchTree(rootNode, 1));
        }catch(Exception e)
        {
            System.err.println("Node couldn't be found!");
        }
    }

}