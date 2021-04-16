package SHU;

import org.antlr.v4.runtime.tree.ParseTree;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import parseTree.pdlBaseListener;
import parseTree.pdlParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Compiler extends pdlBaseListener {
    private StringBuilder sb = new StringBuilder();
    String program;
    public String getProgram() {return program.toString();}

    STGroup stg = new STGroupFile("./pdl.stg");

    ArrayList<String> converted = new ArrayList<>();
    TreeNode node = new TreeNode();

    @Override public void enterProgram(pdlParser.ProgramContext ctx) {
        System.out.println("SUCCESS! NOW COMPILING!");
    }

    @Override public void exitProgramEnds(pdlParser.ProgramEndsContext ctx) {
        //turn into string
        //converted.add(string);
    }

    @Override public void exitInputStatement(pdlParser.InputStatementContext ctx) {

    }

    @Override public void exitAssignment(pdlParser.AssignmentContext ctx) {
        String program = "let  = ";
        List<ParseTree> nodes = ctx.children;
        ArrayList<String> built = new ArrayList<String>();
        built.add("let");
        System.out.println("Printing assignment children\n\n");
        for (int i = 0; i < node.getStack().size(); i++)
        {
            System.out.println(node.getStack().get(i).getNodeName());
        }
        node.DisplayStack();

    }

    @Override public void exitBlock(pdlParser.BlockContext ctx) { }




    @Override public void exitProgramHeader(pdlParser.ProgramHeaderContext ctx) {
        List<ParseTree> nodes = ctx.children;
        ArrayList<String> built = new ArrayList<String>();
        if (ctx.getChildCount() <= 3) {
            for (int i = 0; i < ctx.getChildCount();i++)
                built.add(nodes.get(i).getText());
        }

        ST st = stg.getInstanceOf("programHeader");
        //st.add(built, );
        //sb.append(st.render());
        /*System.out.println("Printing program header children\n\n");
        for (int i = 0; i < ctx.getChildCount(); i++)
        {
            System.out.println(i + ": " + ctx.getChild(i).getText());
        }*/
    }

    @Override public void exitGlobals(pdlParser.GlobalsContext ctx) {
        List<ParseTree> values = ctx.children;
        ArrayList<String> valueNames = new ArrayList<String>();

        for(int i=1; i<ctx.getChildCount(); i+=2)
            valueNames.add(values.get(i).getText());

//        ST st = stg.getInstanceOf("globals");
//        st.add("values", valueNames);
//        System.out.println(valueNames);
        //sb.append(st.render());
    }



}
