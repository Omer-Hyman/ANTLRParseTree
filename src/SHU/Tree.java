package SHU;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;


public class Tree extends JFrame {
    private JTree tree;
    private Worker worker = new Worker();

    public DefaultMutableTreeNode GetRootNode()
    {
        return (DefaultMutableTreeNode) tree.getModel().getRoot();
    }

    private String ctx;

    public JTree getTree() { return this.tree; }

    public void setCtx(String ctx) {
        this.ctx = ctx;
    }

    public Tree() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Parse Tree");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);

        //TODO: CHANGE LEAF ICONS
        //TODO: FIX TREE TO DISPLAY THE RIGHT LEAF NODES

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
            for (int i = 0; i < node.getLevel(); i++)
                temp = (DefaultMutableTreeNode) temp.getLastChild();
            for (int i = 0; i > node.getLevel(); i--)
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

    public void DisplayTree()
    {
        tree = new JTree(new DefaultMutableTreeNode(worker.getStack().get(0).getNodeName()));
        for (int i = 1; i < worker.getStack().size(); i++)
        {
            NewNode(worker.getStack().get(i));
        }
        JScrollPane sPane = new JScrollPane(tree);
        add(sPane);
        setVisible(true);
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }
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