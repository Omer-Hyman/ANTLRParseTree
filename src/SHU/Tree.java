package SHU;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Tree extends JFrame {

    private JTree tree;
    private String ctx;

    private final Stack<TreeNode> nodes = new Stack<>();

    public Stack<TreeNode> getNodes() {
        return nodes;
    }

    public JTree getTree() { return this.tree; }

    DefaultMutableTreeNode temp = new DefaultMutableTreeNode();
    int level;

    public void setLevel(int level) {
        this.level = this.level + level;
    }

    public Tree() {


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Parse Tree");
        this.setSize(300, 300);
        //this.pack();
        this.setVisible(true);

//        this.setLayout(new BorderLayout());
//        JScrollPane scrollPane = new JScrollPane(tree);
//        this.add(scrollPane);

        //TODO: FIX SCROLL PANE

        level = -2;



        /*ImageIcon imageIcon = new ImageIcon(Tree.class.getResource("/leaf.jpg"));
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setLeafIcon(imageIcon);*/

    }

    public void getCtx(String ctx) {
        this.ctx = ctx;
    }

    public String searchTree(String nodeName)
    {
        String regex = ".*" + nodeName + ".*";
        Pattern pattern = Pattern.compile(regex);;
        Matcher matcher = pattern.matcher(ctx);

        System.out.println("STACK:\n" + nodes);

        int count = 0;
        System.out.println("CTX:\n" + ctx + "\nSEARCHING FOR:\n" + nodeName);
        while(matcher.find()) {
            count++;
            System.out.println(nodeName + " found " + count + " times.");
        }
        if (matcher.find())
            return nodeName;
        else
            return null;


        //TODO: regex works for some

        //STACK:
        //[
        // Program, programyanan:, output("anything mate",yanan), endprogram, procyananinput(yanan)endproc, program header, program, yanan, :,
        // block, output("anything mate",yanan), output, output, (, "anything mate", ,, yanan, ), program ends, endprogram, proc defun, proc, yanan, input(yanan),
        // endproc, block, input(yanan), Input, input, (, yanan, )
        // ]
        //CTX:
        //programyanan:output("anything mate",yanan)endprogramprocyananinput(yanan)endproc

        /*DefaultMutableTreeNode node = null;
        Enumeration e = GetRootNode().breadthFirstEnumeration();

        while (e.hasMoreElements()) {
            node = (DefaultMutableTreeNode) e.nextElement();
            if (nodeName.equals(node.toString())) {
                return node.toString() + " found at depth " + node.getLevel() + " at index " + node.getSiblingCount();


              //TODO: MAKE SEARCH RESULTS BETTER
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

    public void NewNode(String name) {
        temp = GetRootNode();
        //System.out.println("\nNode: " + name + "\nTemp: " + temp + "\nTemp.getDepth(): " + temp.getDepth() + "\nLevel: " + level );
        try{
            for (int i = 0; i < level; i++)
                temp = (DefaultMutableTreeNode) temp.getLastChild();
            for (int i = 0; i > level; i--)
                temp = (DefaultMutableTreeNode) temp.getParent();
            temp.add(new DefaultMutableTreeNode(name));
        }
        catch (Exception e) {
            System.err.println("WORKING ON NODE " + name + ". TEMP IS " + temp + ". NODE NOT ADDED TO TREE");
            if (temp != null)
                System.err.println(e);
        }
    }

    public DefaultMutableTreeNode GetRootNode()
    {
        return (DefaultMutableTreeNode) tree.getModel().getRoot();
    }

    public void CreateTree(String name, String contents)
    {
        tree = new JTree(new DefaultMutableTreeNode(name));
        add(tree);
        nodes.push(new TreeNode(name, contents));
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

}
